package com.gameplaycoder.cartrell.tourguide.data;

import android.content.Context;

import com.gameplaycoder.cartrell.tourguide.R;

public final class PowerUpItemsData extends BaseItemsData {
  //===================================================================================
  // public
  //===================================================================================

  //-----------------------------------------------------------------------------------
  // ctor
  //-----------------------------------------------------------------------------------
  public PowerUpItemsData(Context context) {
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
    addItem(context, R.string.bombs, R.string.bombsDescription,
      R.drawable.item_bombs_icon, R.drawable.item_bombs_animation, R.drawable.background_brinstar);

    addItem(context, R.string.energyTank, R.string.energyTankDescription,
      R.drawable.item_energy_tank_icon, R.drawable.item_energy_tank_animation, R.drawable.background_brinstar);

    addItem(context, R.string.highJumpBoots, R.string.highJumpBootsDescription,
      R.drawable.item_boots_icon, R.drawable.item_boots_animation, R.drawable.background_norfair);

    addItem(context, R.string.iceBeam, R.string.iceBeamDescription,
      R.drawable.item_ice_icon, R.drawable.item_ice_animation, R.drawable.background_brinstar);

    addItem(context, R.string.longBeam, R.string.longBeamDescription,
      R.drawable.item_long_icon, R.drawable.item_long_animation, R.drawable.background_brinstar);

    addItem(context, R.string.maruMari, R.string.maruMariDescription,
      R.drawable.item_ball_icon, R.drawable.item_ball_animation, R.drawable.background_brinstar);

    addItem(context, R.string.missiles, R.string.missilesDescription,
      R.drawable.item_missiles_icon, R.drawable.item_missiles_animation, R.drawable.background_brinstar);

    addItem(context, R.string.screwAttack, R.string.screwAttackDescription,
      R.drawable.item_screw_icon, R.drawable.item_screw_animation, R.drawable.background_norfair);

    addItem(context, R.string.varia, R.string.variaDescription,
      R.drawable.item_varia_icon, R.drawable.item_varia_animation, R.drawable.background_brinstar);

    addItem(context, R.string.waveBeam, R.string.waveBeamDescription,
      R.drawable.item_wave_icon, R.drawable.item_wave_animation, R.drawable.background_norfair);
  }
}