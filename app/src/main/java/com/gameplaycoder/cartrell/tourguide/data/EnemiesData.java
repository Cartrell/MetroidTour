package com.gameplaycoder.cartrell.tourguide.data;

import android.content.Context;

import com.gameplaycoder.cartrell.tourguide.R;

public final class EnemiesData extends BaseItemsData {
  //===================================================================================
  // public
  //===================================================================================

  //-----------------------------------------------------------------------------------
  // ctor
  //-----------------------------------------------------------------------------------
  public EnemiesData(Context context) {
    super(context);
    addEnemies(context);
  }

  //===================================================================================
  // private
  //===================================================================================

  //-----------------------------------------------------------------------------------
  // addEnemies
  //-----------------------------------------------------------------------------------
  private void addEnemies(Context context) {
    addItem(context, R.string.deesgeega, R.string.dessgeegaDescription,
      R.drawable.enemy_deesgeega_icon, R.drawable.enemy_deesgeega_animation,
      R.drawable.background_ridleys_lair);

    addItem(context, R.string.gamet, R.string.gametDescription,
      R.drawable.enemy_gamet_icon, R.drawable.enemy_gamut_animation,
      R.drawable.background_norfair);

    addItem(context, R.string.geega, R.string.geegaDescription,
      R.drawable.enemy_geega_icon, R.drawable.enemy_geega_animation,
      R.drawable.background_kraids_lair);

    addItem(context, R.string.geruta, R.string.gerutaDescription,
      R.drawable.enemy_geruta_icon, R.drawable.enemy_geruta_animation,
      R.drawable.background_norfair);

    addItem(context, R.string.holtz, R.string.holtzDescription,
      R.drawable.enemy_holtz_icon, R.drawable.enemy_holtz_animation,
      R.drawable.background_ridleys_lair);

    addItem(context, R.string.kraid, R.string.kraidDescription,
      R.drawable.enemy_kraid_icon, R.drawable.enemy_kraid_animation,
      R.drawable.background_kraids_lair);

    addItem(context, R.string.lavaDragon, R.string.lavaDragonDescription,
      R.drawable.enemy_lavadragon_icon, R.drawable.enemy_lava_dragon_animation,
      R.drawable.background_norfair);

    addItem(context, R.string.mella, R.string.mellaDescription,
      R.drawable.enemy_melias_icon, R.drawable.enemy_melias_animation,
      R.drawable.background_norfair);

    addItem(context, R.string.mellow, R.string.mellowDescription,
      R.drawable.enemy_mellow_icon, R.drawable.enemy_mellow_animation,
      R.drawable.background_brinstar);

    addItem(context, R.string.memu, R.string.memuDescription,
      R.drawable.enemy_memu_icon, R.drawable.enemy_memu_animation,
      R.drawable.background_ridleys_lair);

    addItem(context, R.string.metroid, R.string.metroidDescription,
      R.drawable.enemy_metroid_icon, R.drawable.enemy_metroid_animation,
      R.drawable.background_tourian);

    addItem(context, R.string.motherBrain, R.string.motherBrainDescription,
      R.drawable.enemy_mother_brain_icon, R.drawable.enemy_mother_brain_animation,
      R.drawable.background_tourian);

    addItem(context, R.string.multiviola, R.string.multiviolaDescription,
      R.drawable.enemy_multiviola_icon, R.drawable.enemy_multiviola_animation,
      R.drawable.background_ridleys_lair);

    addItem(context, R.string.nova, R.string.novaDescription,
      R.drawable.enemy_nova_icon, R.drawable.enemy_nova_animation,
      R.drawable.background_norfair);

    addItem(context, R.string.polyp, R.string.polypDescription,
      R.drawable.enemy_polyp_icon, R.drawable.enemy_polyp_animation,
      R.drawable.background_norfair);

    addItem(context, R.string.reo, R.string.reoDescription,
      R.drawable.enemy_reo_icon, R.drawable.enemy_reo_animation,
      R.drawable.background_brinstar);

    addItem(context, R.string.ridley, R.string.ridleysLairDescription,
      R.drawable.enemy_ridley_icon, R.drawable.enemy_ridley_animation,
      R.drawable.background_ridleys_lair);

    addItem(context, R.string.rinka, R.string.rinkaDescription,
      R.drawable.enemy_rinka_icon, R.drawable.enemy_rinka_animation,
      R.drawable.background_tourian);

    addItem(context, R.string.ripper, R.string.ripperDescription,
      R.drawable.enemy_ripper_icon, R.drawable.enemy_ripper_animation,
      R.drawable.background_brinstar);

    addItem(context, R.string.ripper2, R.string.ripper2Description,
      R.drawable.enemy_ripper_ii_icon, R.drawable.enemy_ripper2_animation,
      R.drawable.background_norfair);

    addItem(context, R.string.sidehopper, R.string.sidehopperDescription,
      R.drawable.enemy_sidehopper_icon, R.drawable.enemy_sidehopper_animation,
      R.drawable.background_kraids_lair);

    addItem(context, R.string.skree, R.string.skreeDescription,
      R.drawable.enemy_skree_icon, R.drawable.enemy_skree_animation,
      R.drawable.background_brinstar);

    addItem(context, R.string.squeept, R.string.squeeptDescription,
      R.drawable.enemy_squeept_icon, R.drawable.enemy_squeept_animation,
      R.drawable.background_norfair);

    addItem(context, R.string.viola, R.string.violaDescription,
      R.drawable.enemy_viola_icon, R.drawable.enemy_viola_animation,
      R.drawable.background_ridleys_lair);

    addItem(context, R.string.waver, R.string.waverDescription,
      R.drawable.enemy_waver_icon, R.drawable.enemy_waver_animation,
      R.drawable.background_brinstar);

    addItem(context, R.string.zeb, R.string.zebDescription,
      R.drawable.enemy_zeb_icon, R.drawable.enemy_zeb_animation,
      R.drawable.background_brinstar);

    addItem(context, R.string.zebbo, R.string.zebboDescription,
      R.drawable.enemy_zeebo_icon, R.drawable.enemy_zeebo_animation,
      R.drawable.background_ridleys_lair);

    addItem(context, R.string.zeela, R.string.zeelaDescription,
      R.drawable.enemy_zeela_icon, R.drawable.enemy_zeela_animation,
      R.drawable.background_kraids_lair);

    addItem(context, R.string.zoomer, R.string.zoomerDescription,
      R.drawable.enemy_zoomer_icon, R.drawable.enemy_zoomer_animation,
      R.drawable.background_brinstar);
  }
}
