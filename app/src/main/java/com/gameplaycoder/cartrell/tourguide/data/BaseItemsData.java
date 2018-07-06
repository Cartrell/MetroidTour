package com.gameplaycoder.cartrell.tourguide.data;

import android.content.Context;

import java.util.ArrayList;

abstract public class BaseItemsData {
  //===================================================================================
  // members
  //===================================================================================
  //array of all category data items
  private ArrayList<CategoryItemData> mData;

  //===================================================================================
  // public
  //===================================================================================

  //-----------------------------------------------------------------------------------
  // GetAll
  //-----------------------------------------------------------------------------------
  public ArrayList<CategoryItemData>GetAll() {
    return(mData);
  }

  //-----------------------------------------------------------------------------------
  // GetById
  //-----------------------------------------------------------------------------------
  public CategoryItemData GetById(int id) {
    for (CategoryItemData data : mData) {
      if (data.getId() == id) {
        return(data);
      }
    }
    return(null);
  }

  //===================================================================================
  // package-private
  //===================================================================================

  //-----------------------------------------------------------------------------------
  // ctor
  //-----------------------------------------------------------------------------------
  BaseItemsData(Context context) {
    mData = new ArrayList<>();
  }

  //-----------------------------------------------------------------------------------
  // addItem
  //-----------------------------------------------------------------------------------
  void addItem(Context context, int nameStringId, int descriptionStringId,
  int iconImageResourceId, int animationDrawableResourceId, int backgroundImageResourceId) {
    mData.add(new CategoryItemData(
      context.getString(nameStringId),
      context.getString(descriptionStringId),
      iconImageResourceId,
      animationDrawableResourceId,
      backgroundImageResourceId));
  }

  //-----------------------------------------------------------------------------------
  // addItem
  //-----------------------------------------------------------------------------------
  void addItem(Context context, int nameStringId,  int descriptionStringId,
  int iconImageResourceId, int featureImageResourceIds[], int backgroundImageResourceId) {
    mData.add(new CategoryItemData(
      context.getString(nameStringId),
      context.getString(descriptionStringId),
      iconImageResourceId,
      featureImageResourceIds,
      backgroundImageResourceId));
  }

  //-----------------------------------------------------------------------------------
  // addItem
  //-----------------------------------------------------------------------------------
  void addItem(Context context, int nameStringId, int iconImageResourceId, int songResourceId) {
    mData.add(new CategoryItemData(
      context.getString(nameStringId),
      iconImageResourceId,
      songResourceId));
  }
}