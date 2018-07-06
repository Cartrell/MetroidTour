package com.gameplaycoder.cartrell.tourguide.fragments;


import android.content.Context;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.gameplaycoder.cartrell.tourguide.MainActivity;
import com.gameplaycoder.cartrell.tourguide.R;
import com.gameplaycoder.cartrell.tourguide.adapters.CategoryItemAdapter;
import com.gameplaycoder.cartrell.tourguide.data.CategoryItemData;

/**
 * A simple {@link Fragment} subclass.
 */
public class SongsFragment extends Fragment {
  //===================================================================================
  // members
  //===================================================================================
  private AdapterView.OnItemClickListener mListItemClickListener;
  private MediaPlayer mMediaPlayer;
  private AudioManager mAudioManager;
  private MediaPlayer.OnCompletionListener mMediaPlayerCompletionListener;
  private AudioManager.OnAudioFocusChangeListener mAudioFocusChangeListener;
  private View mCurrentlyPlayingListItemView;

  //===================================================================================
  // public
  //===================================================================================

  //-----------------------------------------------------------------------------------
  // ctor
  //-----------------------------------------------------------------------------------
  public SongsFragment() {
    initItemClickListener();
    initMediaPlayerCompleteListener();
    initAudioFocusChangeListener();
  }

  //-----------------------------------------------------------------------------------
  // onStop
  //-----------------------------------------------------------------------------------
  public void onStop() {
    super.onStop();
    // When the activity is stopped, release the media player resources because we won't
    // be playing any more sounds.
    releaseMediaPlayer();
  }

  //-----------------------------------------------------------------------------------
  // onCreateView
  //-----------------------------------------------------------------------------------
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    //create the audio manager
    FragmentActivity fragmentActivity = getActivity();
    if (fragmentActivity != null) {
      mAudioManager = (AudioManager)fragmentActivity.getSystemService(Context.AUDIO_SERVICE);
    } else {
      Log.w("SongsFragment", "Unable to obtain an AudioManager.");
    }

    // Inflate the layout for this fragment
    View rootView = inflater.inflate(R.layout.category_items_list, container, false);

    CategoryItemAdapter adapter = new CategoryItemAdapter(getActivity(), MainActivity.Songs.GetAll());
    ListView listView = rootView.findViewById(R.id.category_items_list);
    listView.setAdapter(adapter);
    listView.setOnItemClickListener(mListItemClickListener);

    return(rootView);
  }

  //===================================================================================
  // private
  //===================================================================================

  //-----------------------------------------------------------------------------------
  // initAudioFocusChangeListener
  //-----------------------------------------------------------------------------------
  private void initAudioFocusChangeListener() {
    mAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {

      //-------------------------------------------------------------------------------
      // onAudioFocusChange
      //-------------------------------------------------------------------------------
      @Override
      public void onAudioFocusChange(int focusChange) {
        switch (focusChange) {
          case AudioManager.AUDIOFOCUS_GAIN:
          case AudioManager.AUDIOFOCUS_GAIN_TRANSIENT:
            mMediaPlayer.start();
            break;

          case AudioManager.AUDIOFOCUS_LOSS:
            releaseMediaPlayer();
            break;

          case AudioManager.AUDIOFOCUS_LOSS_TRANSIENT:
          case AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK:
            mMediaPlayer.pause();
            mMediaPlayer.seekTo(0);
            break;
        }
      }
    };
  }

  //-----------------------------------------------------------------------------------
  // initItemClickListener
  //-----------------------------------------------------------------------------------
  private void initItemClickListener() {
    mListItemClickListener = new AdapterView.OnItemClickListener() {
      //-------------------------------------------------------------------------------
      // onItemClick
      //-------------------------------------------------------------------------------
      @Override
      public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
      CategoryItemData categoryItemData = (CategoryItemData)parent.getItemAtPosition(position);
        if (mAudioManager == null) {
          //cancel the whole thing if we've no audio manager
          return;
        }

        int requestedSongId = categoryItemData.getMusicResourceId();
        boolean isStoppingCurrentSong = MainActivity.CurrentlyPlayingSongId == requestedSongId;

        //stop any currently playing media player first
        releaseMediaPlayer();

        if (isStoppingCurrentSong) {
          return;
        }

        mMediaPlayer = MediaPlayer.create(getActivity(), requestedSongId);
        mMediaPlayer.setOnCompletionListener(mMediaPlayerCompletionListener);

        int request = mAudioManager.requestAudioFocus(mAudioFocusChangeListener,
          AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

        if (request == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
          mMediaPlayer.start();
          MainActivity.CurrentlyPlayingSongId = requestedSongId;
          setPlayingListViewItem(view);
        } else if (request == AudioManager.AUDIOFOCUS_REQUEST_FAILED) {
          releaseMediaPlayer();
        }
      }
    };
  }

  //-----------------------------------------------------------------------------------
  // initMediaPlayerCompleteListener
  //-----------------------------------------------------------------------------------
  private void initMediaPlayerCompleteListener() {
    mMediaPlayerCompletionListener = new MediaPlayer.OnCompletionListener() {

      //-------------------------------------------------------------------------------
      // onCompletion
      //-------------------------------------------------------------------------------
      @Override
      public void onCompletion(MediaPlayer mediaPlayer) {
        releaseMediaPlayer();
      }
    };
  }

  //-----------------------------------------------------------------------------------
  // releaseMediaPlayer
  //-----------------------------------------------------------------------------------
  private void releaseMediaPlayer() {
    if (mMediaPlayer != null) {
      mMediaPlayer.release();
      mMediaPlayer = null;
    }

    MainActivity.CurrentlyPlayingSongId = 0;
    if (mAudioManager != null) {
      mAudioManager.abandonAudioFocus(mAudioFocusChangeListener);
    }

    setPlayingListViewItem(null);
  }

  //-----------------------------------------------------------------------------------
  // setPlayingListViewItem
  //-----------------------------------------------------------------------------------
  private void setPlayingListViewItem(View view) {
    if (mCurrentlyPlayingListItemView != null) {
      setIconOnListViewItem(mCurrentlyPlayingListItemView, R.drawable.baseline_play_arrow_white_48);
    }

    mCurrentlyPlayingListItemView = view;

    if (mCurrentlyPlayingListItemView != null) {
      setIconOnListViewItem(mCurrentlyPlayingListItemView, R.drawable.baseline_stop_arrow_white_48);
    }
  }

  //-----------------------------------------------------------------------------------
  // setIconOnListViewItem
  //-----------------------------------------------------------------------------------
  private void setIconOnListViewItem(View view, int drawableResourceId) {
    Context context = getContext();
    if (context == null) {
      return;
    }

    Drawable drawable = ContextCompat.getDrawable(context, drawableResourceId);
    ImageView playIconImage = view.findViewById(R.id.play_icon_image);
    playIconImage.setImageDrawable(drawable);
  }
}