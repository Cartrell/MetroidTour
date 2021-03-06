package com.gameplaycoder.cartrell.tourguide.fragments;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.gameplaycoder.cartrell.tourguide.MainActivity;
import com.gameplaycoder.cartrell.tourguide.R;
import com.gameplaycoder.cartrell.tourguide.adapters.CategoryItemAdapter;
import com.gameplaycoder.cartrell.tourguide.categoryActivities.BaseCategoryActivity;
import com.gameplaycoder.cartrell.tourguide.categoryActivities.PowerUpItemsActivity;
import com.gameplaycoder.cartrell.tourguide.data.CategoryItemData;

/**
 * A simple {@link Fragment} subclass.
 */
public class ItemsFragment extends Fragment {
  //===================================================================================
  // members
  //===================================================================================
  private AdapterView.OnItemClickListener mListItemClickListener;

  //===================================================================================
  // public
  //===================================================================================

  //-----------------------------------------------------------------------------------
  // ctor
  //-----------------------------------------------------------------------------------
  public ItemsFragment() {
    initListItemClickListener();
  }

  //-----------------------------------------------------------------------------------
  // onCreateView
  //-----------------------------------------------------------------------------------
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View rootView = inflater.inflate(R.layout.category_items_list, container, false);

    CategoryItemAdapter adapter = new CategoryItemAdapter(getActivity(), MainActivity.PowerUpItems.GetAll());
    ListView listView = rootView.findViewById(R.id.category_items_list);
    listView.setAdapter(adapter);
    listView.setOnItemClickListener(mListItemClickListener);

    return(rootView);
  }

  //===================================================================================
  // private
  //===================================================================================

  //-----------------------------------------------------------------------------------
  // initListItemClickListener
  //-----------------------------------------------------------------------------------
  private void initListItemClickListener() {
    mListItemClickListener = new AdapterView.OnItemClickListener() {
      //-------------------------------------------------------------------------------
      // onItemClick
      //-------------------------------------------------------------------------------
      @Override
      public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        CategoryItemData categoryItemData = (CategoryItemData)parent.getItemAtPosition(position);

        Activity activity = getActivity();
        if (activity == null) {
          return;
        }

        Intent intent = new Intent(activity, PowerUpItemsActivity.class);
        intent.putExtra(BaseCategoryActivity.CATEGORY_INTENT_PROP_ITEM_ID, categoryItemData.getId());
        activity.startActivity(intent);
      }
    };
  }
}