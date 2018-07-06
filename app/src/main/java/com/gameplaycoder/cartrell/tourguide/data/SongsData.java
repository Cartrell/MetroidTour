package com.gameplaycoder.cartrell.tourguide.data;

import android.content.Context;

import com.gameplaycoder.cartrell.tourguide.R;

public final class SongsData extends BaseItemsData {
  //===================================================================================
  // public
  //===================================================================================

  //-----------------------------------------------------------------------------------
  // ctor
  //-----------------------------------------------------------------------------------
  public SongsData(Context context) {
    super(context);
    addItems(context);
  }

  //===================================================================================
  // private
  //===================================================================================

  //-----------------------------------------------------------------------------------
  // addItems
  //-----------------------------------------------------------------------------------
  private void addItems(Context context) {
    final int MUSIC_ICON = R.drawable.music_icon;
    addItem(context, R.string.songTitle, MUSIC_ICON, R.raw.title);
    addItem(context, R.string.songEnergize, MUSIC_ICON, R.raw.energize);
    addItem(context, R.string.songBrinstar, MUSIC_ICON, R.raw.brinstar);
    addItem(context, R.string.songNorfair, MUSIC_ICON, R.raw.norfair);
    addItem(context, R.string.songKraidsLair, MUSIC_ICON, R.raw.kraid);
    addItem(context, R.string.songRidleysLair, MUSIC_ICON, R.raw.ridley);
    addItem(context, R.string.songTourian, MUSIC_ICON, R.raw.tourian);
    addItem(context, R.string.songMotherBrain, MUSIC_ICON, R.raw.mother_brain);
    addItem(context, R.string.songEscape, MUSIC_ICON, R.raw.escape);
    addItem(context, R.string.songEnding, MUSIC_ICON, R.raw.ending);
    addItem(context, R.string.songSecret, MUSIC_ICON, R.raw.secret);
    addItem(context, R.string.songPowerUp, MUSIC_ICON, R.raw.power_up);
  }
}
