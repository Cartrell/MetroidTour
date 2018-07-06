package com.gameplaycoder.cartrell.tourguide;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.gameplaycoder.cartrell.tourguide.adapters.CategoryPagerAdapter;
import com.gameplaycoder.cartrell.tourguide.data.EnemiesData;
import com.gameplaycoder.cartrell.tourguide.data.LocationsData;
import com.gameplaycoder.cartrell.tourguide.data.PowerUpItemsData;
import com.gameplaycoder.cartrell.tourguide.data.SongsData;

public class MainActivity extends AppCompatActivity {
  //===================================================================================
  // static / const
  //===================================================================================
  public static LocationsData Locations;
  public static PowerUpItemsData PowerUpItems;
  public static EnemiesData Enemies;
  public static SongsData Songs;

  public static int CurrentlyPlayingSongId;

  //===================================================================================
  // public
  //===================================================================================

  //-----------------------------------------------------------------------------------
  // onCreate
  //-----------------------------------------------------------------------------------
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    //setup the category data containers
    Locations = new LocationsData(getApplicationContext());
    PowerUpItems = new PowerUpItemsData(getApplicationContext());
    Enemies = new EnemiesData(getApplicationContext());
    Songs = new SongsData(getApplicationContext());

    //find the view pager that will allow the user to swipe between fragments
    ViewPager viewPager = findViewById(R.id.viewpager);

    //create an adapter that knows which fragment should be shown on each page
    CategoryPagerAdapter adapter = new CategoryPagerAdapter(this, getSupportFragmentManager());

    //set the adapter onto the view pager
    viewPager.setAdapter(adapter);

    //give the TabLayout the ViewPager
    TabLayout tabLayout = findViewById(R.id.sliding_tabs);
    tabLayout.setupWithViewPager(viewPager);
  }
}
