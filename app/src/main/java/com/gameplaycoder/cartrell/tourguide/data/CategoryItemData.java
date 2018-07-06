package com.gameplaycoder.cartrell.tourguide.data;

/*
The storage data for a single category item. Not all categories use all the members, hence there
are multiple constructors.
 */
public class CategoryItemData {
  //===================================================================================
  // static / const
  //===================================================================================
  //Value of the next id to be used by the next category item created. Every category item
  // must have a unique id
  private static int smNextId;

  //===================================================================================
  // members
  //===================================================================================

  //for items that used featured items, this is the sequence of images, represented by their
  //resource ids.
  private int mFeatureImageResourceIds[];

  //name of the item
  private String mName;

  //description of the item
  private String mDescription;

  //unique id - mainly used for look-ups when transferring category items across activities
  // via intents. All that needs to be put in extra itent data is this id. The receiving activity
  // can then look up the item by that id.
  private int mId;

  //the image id of the item when displayed in a list view
  private int mIconImageResourceId;

  //if the item uses an animation when shown in an activity, this is the resource id of the
  // animation drawable
  private int mAnimationDrawableResourceId;

  //optional image resource id of the image that the item changes the background of the category to
  private int mBackgroundImageResourceId;

  //optional audio resource id that is used for soundtracks only
  private int mMusicResourceId;

  //===================================================================================
  // public
  //===================================================================================

  //-----------------------------------------------------------------------------------
  // ctor
  //-----------------------------------------------------------------------------------
  /*
  This ctor is used for enemies and items
   */
  public CategoryItemData(String name, String description, int iconImageResourceId,
  int animationDrawableResourceId, int backgroundImageResourceId) {
    basicInit(name, description, iconImageResourceId, backgroundImageResourceId);
    mAnimationDrawableResourceId = animationDrawableResourceId;
  }

  //-----------------------------------------------------------------------------------
  // ctor
  //-----------------------------------------------------------------------------------
  /*
  This ctor is used for locations
   */
  public CategoryItemData(String name, String description, int iconImageResourceId,
  int featureImageResourceIds[], int backgroundImageResourceId) {
    basicInit(name, description, iconImageResourceId, backgroundImageResourceId);
    mFeatureImageResourceIds = featureImageResourceIds;
  }

  //-----------------------------------------------------------------------------------
  // ctor
  //-----------------------------------------------------------------------------------
  /*
  This ctor is used for sound tracks
   */
  public CategoryItemData(String name, int iconImageResourceId, int musicResourceId) {
    basicInit(name, iconImageResourceId);
    mMusicResourceId = musicResourceId;
  }

  //-----------------------------------------------------------------------------------
  // getAnimationDrawableResourceId
  //-----------------------------------------------------------------------------------
  public int getAnimationDrawableResourceId() {
    return(mAnimationDrawableResourceId);
  }

  //-----------------------------------------------------------------------------------
  // getBackgroundImageResourceId
  //-----------------------------------------------------------------------------------
  public int getBackgroundImageResourceId() {
    return(mBackgroundImageResourceId);
  }

  //-----------------------------------------------------------------------------------
  // getDescription
  //-----------------------------------------------------------------------------------
  public String getDescription() {
    return(mDescription);
  }

  //-----------------------------------------------------------------------------------
  // getFeatureImageResourceIds
  //-----------------------------------------------------------------------------------
  public int[] getFeatureImageResourceIds() {
    return(mFeatureImageResourceIds);
  }

  //-----------------------------------------------------------------------------------
  // getIconImageResourceId
  //-----------------------------------------------------------------------------------
  public int getIconImageResourceId() {
    return(mIconImageResourceId);
  }

  //-----------------------------------------------------------------------------------
  // getId
  //-----------------------------------------------------------------------------------
  public int getId() {
    return(mId);
  }

  //-----------------------------------------------------------------------------------
  // getMusicResourceId
  //-----------------------------------------------------------------------------------
  public int getMusicResourceId() {
    return(mMusicResourceId);
  }

  //-----------------------------------------------------------------------------------
  // getName
  //-----------------------------------------------------------------------------------
  public String getName() {
    return(mName);
  }

  //===================================================================================
  // private
  //===================================================================================

  //-----------------------------------------------------------------------------------
  // basicInit
  //-----------------------------------------------------------------------------------
  private void basicInit(String name, String description, int iconImageResourceId,
  int backgroundImageResourceId) {
    mId = ++smNextId;
    mName = name;
    mDescription = description;
    mIconImageResourceId = iconImageResourceId;
    mBackgroundImageResourceId = backgroundImageResourceId;
  }

  //-----------------------------------------------------------------------------------
  // basicInit
  //-----------------------------------------------------------------------------------
  private void basicInit(String name, int iconImageResourceId) {
    mId = ++smNextId;
    mName = name;
    mIconImageResourceId = iconImageResourceId;
  }
}
