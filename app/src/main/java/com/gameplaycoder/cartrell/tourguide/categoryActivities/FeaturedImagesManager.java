package com.gameplaycoder.cartrell.tourguide.categoryActivities;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.os.Handler;
import android.widget.ImageView;

final class FeaturedImagesManager {
  /*
  Featured images are images that are shown in sequence, one at a time, for a short time. Kind of
  like a slide show on automatic. There is additional polish that will fade the new image onto the
  current one, resembling a crossfade.
   */
  //===================================================================================
  // static / const
  //===================================================================================

  //duration, in ms, that each image is shown
  private final int FRAME_DURATION = 3000;

  //duration, in ms of the crossfade transition
  private final int IMAGE_FADE_DURATION = 500;

  //===================================================================================
  // members
  //===================================================================================

  //The series of images, by their resource ids. The images are cross-faded in this order
  private int[] mImageResourceIds;

  //Image views 1 and 2 are the actual images. The "next" image view is just a reference to
  // one of them, and it represents the image that will be crossfaded in next.
  private ImageView mImageView1;
  private ImageView mImageView2;
  private ImageView mNextImageView;

  //responsible for timer
  private Handler mTimerHandler;
  private Runnable mTimerRunnable;

  private ObjectAnimator mAnimation;

  //index to the currently show featured image. this number will loop repeatedly
  private int mImageIndex;

  //===================================================================================
  // package-private
  //===================================================================================

  //-----------------------------------------------------------------------------------
  // ctor
  //-----------------------------------------------------------------------------------
  FeaturedImagesManager(ImageView imageView1, ImageView imageView2, int[] imageResourceIds) {
    mImageResourceIds = imageResourceIds;
    mImageView1 = imageView1;
    mImageView2 = imageView2;

    setNextTargetImage(mImageView2);
    setImage(mImageView1,0);

    initTimer();
  }

  //-----------------------------------------------------------------------------------
  // start
  //-----------------------------------------------------------------------------------
  void start() {
    mTimerHandler.postDelayed(mTimerRunnable, FRAME_DURATION);
  }

  //-----------------------------------------------------------------------------------
  // stop
  //-----------------------------------------------------------------------------------
  void stop() {
    if (mAnimation != null) {
      mAnimation.cancel();
      mAnimation = null;
    }

    mTimerHandler.removeCallbacks(mTimerRunnable);
  }

  //===================================================================================
  // private
  //===================================================================================

  //-----------------------------------------------------------------------------------
  // initTimer
  //-----------------------------------------------------------------------------------
  /**
   * Sets up the timer and its run callback
   */
  private void initTimer() {
    mTimerHandler = new Handler();
    mTimerRunnable = new Runnable() {
      //-------------------------------------------------------------------------------
      // run
      //-------------------------------------------------------------------------------
      @Override
      public void run() {
        onTimerRunnable();
      }
    };
  }

  //-----------------------------------------------------------------------------------
  // onTimerRunnable
  //-----------------------------------------------------------------------------------
  private void onTimerRunnable() {
    //set the next image, looping back to 0 if we've went past the past one
    setImage(mNextImageView, (mImageIndex + 1) % mImageResourceIds.length);

    mAnimation = ObjectAnimator.ofFloat(mNextImageView, "alpha", 1.0f);
    mAnimation.setDuration(IMAGE_FADE_DURATION);

    mAnimation.addListener(new AnimatorListenerAdapter() {
      //-------------------------------------------------------------------------------
      // onAnimationEnd
      //-------------------------------------------------------------------------------
      @Override
      public void onAnimationEnd(Animator animation) {
        //when crossfading. swap between which image will be the next one to crossfade
        if (mNextImageView == mImageView1) {
          setNextTargetImage(mImageView2);
        } else  {
          setNextTargetImage(mImageView1);
        }

        //start the timer again
        mTimerHandler.postDelayed(mTimerRunnable, FRAME_DURATION);
      }
    });

    mAnimation.start();
  }

  //-----------------------------------------------------------------------------------
  // setImage
  //-----------------------------------------------------------------------------------
  private void setImage(ImageView imageView, int imageIndex) {
    mImageIndex = imageIndex;
    imageView.setBackgroundResource(mImageResourceIds[mImageIndex]);
  }

  //-----------------------------------------------------------------------------------
  // setNextTargetImage
  //-----------------------------------------------------------------------------------
  private void setNextTargetImage(ImageView imageView) {
    mNextImageView = imageView;
    mNextImageView.setAlpha(0f);

    //a crossfade is "faked" by bringing the next image to the top, and setting its alpha to
    // 0 (fully transparent). When its image is set, and its ready to fade in, it does so
    // over the current image, making it appear to look like a crossfade
    mNextImageView.getParent().bringChildToFront(mNextImageView);
  }
}