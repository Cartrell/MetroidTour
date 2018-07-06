package com.gameplaycoder.cartrell.tourguide.data;

import android.content.Context;
import com.gameplaycoder.cartrell.tourguide.R;
import java.util.ArrayList;

public final class LocationsData extends BaseItemsData {
  //===================================================================================
  // public
  //===================================================================================

  //-----------------------------------------------------------------------------------
  // ctor
  //-----------------------------------------------------------------------------------
  public LocationsData(Context context) {
    super(context);
    addLocations(context);
  }

  //===================================================================================
  // private
  //===================================================================================

  //-----------------------------------------------------------------------------------
  // addLocations
  //-----------------------------------------------------------------------------------
  private void addLocations(Context context) {
    //add locations data
    addItem(context, R.string.brinstar, R.string.brinstarDescription,
      R.drawable.location_brinstar_icon, FeaturedImageIds.LocationBrinstar,
      R.drawable.background_brinstar);

    addItem(context, R.string.norfair, R.string.norfairDescription,
      R.drawable.location_norfair_icon, FeaturedImageIds.LocationNorfair,
      R.drawable.background_norfair);

    addItem(context, R.string.kraidsLair, R.string.kraidsLairDescription,
      R.drawable.location_kraids_lair_icon, FeaturedImageIds.LocationKraidsLair,
      R.drawable.background_kraids_lair);

    addItem(context, R.string.ridleysLair, R.string.ridleysLairDescription,
      R.drawable.location_ridleys_lair_icon, FeaturedImageIds.LocationRidleysLair,
      R.drawable.background_ridleys_lair);

    addItem(context, R.string.tourian, R.string.tourianDescription,
      R.drawable.location_tourian_icon, FeaturedImageIds.LocationTourian,
      R.drawable.background_tourian);
  }
}