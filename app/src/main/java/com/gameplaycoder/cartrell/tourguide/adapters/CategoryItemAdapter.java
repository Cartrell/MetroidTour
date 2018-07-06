package com.gameplaycoder.cartrell.tourguide.adapters;

import android.animation.ArgbEvaluator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.gameplaycoder.cartrell.tourguide.MainActivity;
import com.gameplaycoder.cartrell.tourguide.R;
import com.gameplaycoder.cartrell.tourguide.data.CategoryItemData;

import java.util.ArrayList;
import java.util.Arrays;

public class CategoryItemAdapter extends ArrayAdapter<CategoryItemData> {

  //===================================================================================
  // members
  //===================================================================================
  private int mStartColor;
  private int mEndColor;

  //===================================================================================
  // public
  //===================================================================================

  //-----------------------------------------------------------------------------------
  // ctor
  //-----------------------------------------------------------------------------------
  public CategoryItemAdapter(Context context, ArrayList<CategoryItemData> items) {
    super(context, 0, items);
    initColors();
  }

  //-----------------------------------------------------------------------------------
  // getView
  //-----------------------------------------------------------------------------------
  @NonNull
  @Override
  public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
    // Check if the existing view is being reused, otherwise inflate the view
    View listItemView = convertView;

    if (listItemView == null) {
      listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent,
        false);
    }

    // Get the data at this position in the list
    final CategoryItemData itemData = getItem(position);

    //populate the view components of the list view item
    setName(listItemView, itemData);
    setIconImage(listItemView, itemData);
    setPlayIcon(listItemView, itemData);
    setListItemBackgroundColor(listItemView, position);

    return(listItemView);
  }

  //===================================================================================
  // private
  //===================================================================================

  //-----------------------------------------------------------------------------------
  // setIconImage
  //-----------------------------------------------------------------------------------
  private void initColors() {
    //set the background of the list item by interpolating between start and end colors,
    // using the first item in the list as the start fraction and the last item as the
    // end fraction

    Integer[] colorValues = new Integer[] {
      0xff0000a0, //bright-blue
      0xff000040, //dark-blue
      0xffa00000, //bright-red
      0xff400000, //dark-red
      0xff00a000, //bright-green
      0xff004000, //dark-green
      0xffa000a0, //bright-purple
      0xff400040, //dark-purple
      0xff00a0a0, //bright-cyan
      0xff004040, //dark-cyan
      0xffa0a000, //bright-yellow
      0xff404000  //dark-yellow
    };

    ArrayList<Integer> colors = new ArrayList<>(Arrays.asList(colorValues));

    int colorIndex = (int)(Math.random() * colors.size());
    mStartColor = colors.get(colorIndex);

    colors.remove(colorIndex);
    colorIndex = (int)(Math.random() * colors.size());
    mEndColor = colors.get(colorIndex);
  }

  //-----------------------------------------------------------------------------------
  // setIconImage
  //-----------------------------------------------------------------------------------
  private void setIconImage(View listItemView, CategoryItemData itemData) {
    ImageView imageView = listItemView.findViewById(R.id.icon_image);
    int imageResourceId;

    if (itemData != null) {
      imageResourceId = itemData.getIconImageResourceId();
    } else {
      imageResourceId = 0;
    }

    imageView.setBackgroundResource(imageResourceId);
  }

  //-----------------------------------------------------------------------------------
  // setListItemBackgroundColor
  //-----------------------------------------------------------------------------------
  private void setListItemBackgroundColor(View listItemView, int position) {

    ArgbEvaluator evaluator = new ArgbEvaluator();
    float fraction = (float)position / (float)getCount();
    int color = (int)evaluator.evaluate(fraction, mStartColor, mEndColor);
    listItemView.setBackgroundColor(color);
  }

  //-----------------------------------------------------------------------------------
  // setName
  //-----------------------------------------------------------------------------------
  private void setName(View listItemView, CategoryItemData itemData) {
    TextView textView = listItemView.findViewById(R.id.txt_name);

    //sanity check
    if (itemData == null) {
      textView.setText("");
    } else {
      textView.setText(itemData.getName());
    }
  }

  //-----------------------------------------------------------------------------------
  // setPlayIcon
  //-----------------------------------------------------------------------------------
  private void setPlayIcon(View listItemView, CategoryItemData itemData) {
    int musicResourceId;

    //sanity check
    if (itemData != null) {
      musicResourceId = itemData.getMusicResourceId();
    } else {
      musicResourceId = 0;
    }

    ImageView playIconImage = listItemView.findViewById(R.id.play_icon_image);
    if (musicResourceId > 0) {
      //we have a valid music resource

      int drawableResourceId;
      if (MainActivity.CurrentlyPlayingSongId > 0) {
        //a song is currently playing

        if (musicResourceId == MainActivity.CurrentlyPlayingSongId) {
          //the song represented by this list view item is currently playing, so show the
          // stop icon
          drawableResourceId = R.drawable.baseline_stop_arrow_white_48;
        } else {
          //a song represented by some other list view item is currently playing, so show the
          // play icon
          drawableResourceId = R.drawable.baseline_play_arrow_white_48;
        }
      } else {
        //no song is playing, so set the 'play' icon
        drawableResourceId = R.drawable.baseline_play_arrow_white_48;
      }

      Context context = getContext();
      Drawable drawable = ContextCompat.getDrawable(context, drawableResourceId);
      playIconImage.setImageDrawable(drawable);

      playIconImage.setVisibility(View.VISIBLE);
    } else {
      playIconImage.setVisibility(View.INVISIBLE);
    }
  }
}
