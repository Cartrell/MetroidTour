package com.gameplaycoder.cartrell.tourguide.adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.gameplaycoder.cartrell.tourguide.R;
import com.gameplaycoder.cartrell.tourguide.fragments.EnemiesFragment;
import com.gameplaycoder.cartrell.tourguide.fragments.ItemsFragment;
import com.gameplaycoder.cartrell.tourguide.fragments.LocationsFragment;
import com.gameplaycoder.cartrell.tourguide.fragments.SongsFragment;

public class CategoryPagerAdapter extends FragmentPagerAdapter {
  //===================================================================================
  // static / const
  //===================================================================================
  private final int POSITION_LOCATIONS = 0;
  private final int POSITION_ITEMS = 1;
  private final int POSITION_ENEMIES = 2;
  private final int POSITION_MUSIC = 3;

  //===================================================================================
  // members
  //===================================================================================
  private String mTabTitles[];

  //===================================================================================
  // public
  //===================================================================================

  //-----------------------------------------------------------------------------------
  // ctor
  //-----------------------------------------------------------------------------------
  public CategoryPagerAdapter(Context context, FragmentManager fm) {
    super(fm);

    mTabTitles = new String[] {
      context.getString(R.string.locations),
      context.getString(R.string.items),
      context.getString(R.string.enemies),
      context.getString(R.string.soundTracks)
    };
  }

  //-----------------------------------------------------------------------------------
  // getCount
  //-----------------------------------------------------------------------------------
  @Override
  public int getCount() {
    return(mTabTitles.length);
  }

  //-----------------------------------------------------------------------------------
  // getItem
  //-----------------------------------------------------------------------------------
  @Override
  public Fragment getItem(int position) {
    if (position == POSITION_LOCATIONS) {
      return(new LocationsFragment());
    } else if (position == POSITION_ITEMS) {
      return(new ItemsFragment());
    } else if (position == POSITION_ENEMIES) {
      return(new EnemiesFragment());
    } else if (position == POSITION_MUSIC) {
      return(new SongsFragment());
    }

    return(null);
  }

  //-----------------------------------------------------------------------------------
  // getPageTitle
  //-----------------------------------------------------------------------------------
  @Override
  public CharSequence getPageTitle(int position) {
    // Generate title based on item position
    return(mTabTitles[position]);
  }
}
