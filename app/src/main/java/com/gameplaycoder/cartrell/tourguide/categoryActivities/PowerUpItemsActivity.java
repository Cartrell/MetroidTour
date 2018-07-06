package com.gameplaycoder.cartrell.tourguide.categoryActivities;

import android.content.Intent;
import android.os.Bundle;

import com.gameplaycoder.cartrell.tourguide.MainActivity;
import com.gameplaycoder.cartrell.tourguide.data.CategoryItemData;

public class PowerUpItemsActivity extends BaseCategoryActivity {

  //===================================================================================
  // protected
  //===================================================================================

  //-----------------------------------------------------------------------------------
  // onCreate
  //-----------------------------------------------------------------------------------
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    Intent intent = getIntent();
    int itemId = intent.getIntExtra(BaseCategoryActivity.CATEGORY_INTENT_PROP_ITEM_ID, 0);
    CategoryItemData data = MainActivity.PowerUpItems.GetById(itemId);
    init(data);
  }
}
