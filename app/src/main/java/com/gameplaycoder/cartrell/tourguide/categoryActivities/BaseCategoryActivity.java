package com.gameplaycoder.cartrell.tourguide.categoryActivities;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.gameplaycoder.cartrell.tourguide.R;
import com.gameplaycoder.cartrell.tourguide.data.CategoryItemData;

abstract public class BaseCategoryActivity extends AppCompatActivity {
  //===================================================================================
  // static / const
  //===================================================================================
  public static final String CATEGORY_INTENT_PROP_ITEM_ID = "itemId";

  //===================================================================================
  // members
  //===================================================================================
  //some category items will show featured images; others will show an animation
  private FeaturedImagesManager mFeaturedImagesManager;
  private AnimationDrawable mAnimatedDrawable;

  //===================================================================================
  // protected
  //===================================================================================

  //-----------------------------------------------------------------------------------
  // init
  //-----------------------------------------------------------------------------------
  protected void init(CategoryItemData data) {
    setBackgroundImage(data.getBackgroundImageResourceId());

    TextView textView = findViewById(R.id.txt_item_header);
    textView.setText(data.getName());

    textView = findViewById(R.id.txt_item_description);
    textView.setText(data.getDescription());

    //some category items will show featured images; others will show an animation
    if (!initFeaturedImages(data)) {
      initAnimatedImage(data);
    }
  }

  //-----------------------------------------------------------------------------------
  // onCreate
  //-----------------------------------------------------------------------------------
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_category_item);
  }

  //-----------------------------------------------------------------------------------
  // onDestroy
  //-----------------------------------------------------------------------------------
  @Override
  protected void onDestroy() {
    super.onDestroy();

    if (mAnimatedDrawable != null) {
      mAnimatedDrawable.stop();
      mAnimatedDrawable = null;
    }

    if (mFeaturedImagesManager != null) {
      mFeaturedImagesManager.stop();
      mFeaturedImagesManager = null;
    }
  }

  //===================================================================================
  // private
  //===================================================================================

  //-----------------------------------------------------------------------------------
  // initAnimatedImage
  //-----------------------------------------------------------------------------------
  private void initAnimatedImage(CategoryItemData data) {
    View imagesLayout = findViewById(R.id.featured_images_layout);
    int animatedDrawableResourceId = data.getAnimationDrawableResourceId();
    if (animatedDrawableResourceId == 0) {
      imagesLayout.setVisibility(View.GONE);
      return;
    }

    Context context = getApplicationContext();
    ImageView imageView = findViewById(R.id.feature_image1);
    mAnimatedDrawable = (AnimationDrawable)ContextCompat.getDrawable(context,
      animatedDrawableResourceId);
    imageView.setImageDrawable(mAnimatedDrawable);
    if (mAnimatedDrawable != null) {
      mAnimatedDrawable.start();
    }

    imagesLayout.setVisibility(View.VISIBLE);
  }

  //-----------------------------------------------------------------------------------
  // initFeaturedImages
  //-----------------------------------------------------------------------------------
  private boolean initFeaturedImages(CategoryItemData data) {
    View imagesLayout = findViewById(R.id.featured_images_layout);
    int imageIds[] = data.getFeatureImageResourceIds();
    if (imageIds == null) {
      imagesLayout.setVisibility(View.GONE);
      return(false);
    }

    ImageView imageView1 = findViewById(R.id.feature_image1);

    ImageView imageView2 = findViewById(R.id.feature_image2);
    imageView2.setVisibility(View.VISIBLE);

    imagesLayout.setVisibility(View.VISIBLE);
    mFeaturedImagesManager = new FeaturedImagesManager(imageView1, imageView2, imageIds);
    mFeaturedImagesManager.start();
    return(true);
  }

  //-----------------------------------------------------------------------------------
  // setBackgroundImage
  //-----------------------------------------------------------------------------------
  private void setBackgroundImage(int imageResourceId) {
    Context context = getApplicationContext();
    Drawable drawable = ContextCompat.getDrawable(context, imageResourceId);
    ImageView backgroundImage = findViewById(R.id.image_background);
    backgroundImage.setImageDrawable(drawable);
  }
}