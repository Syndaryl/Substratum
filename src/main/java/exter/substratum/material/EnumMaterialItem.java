package exter.substratum.material;

import com.google.common.collect.ImmutableList;

import exter.substratum.util.SubstratumUtils;

public enum EnumMaterialItem
{
  INGOT("ingot",ImmutableList.of(
      EnumMaterial.COPPER,
      EnumMaterial.TIN,
      EnumMaterial.BRONZE,
      EnumMaterial.ELECTRUM,
      EnumMaterial.INVAR,
      EnumMaterial.NICKEL,
      EnumMaterial.ZINC,
      EnumMaterial.BRASS,
      EnumMaterial.SILVER,
      EnumMaterial.STEEL,
      EnumMaterial.LEAD,
      EnumMaterial.PLATINUM,
      EnumMaterial.CUPRONICKEL,
      EnumMaterial.SIGNALUM,
      EnumMaterial.LUMIUM,
      EnumMaterial.ENDERIUM,
      EnumMaterial.NULL,
      EnumMaterial.ALUMINIUM,
      EnumMaterial.CHROMIUM,
      EnumMaterial.OSMIUM)),
  
  DUST("dust",ImmutableList.of(
      EnumMaterial.COAL,
      EnumMaterial.IRON,
      EnumMaterial.GOLD,
      EnumMaterial.COPPER,
      EnumMaterial.TIN,
      EnumMaterial.BRONZE,
      EnumMaterial.ELECTRUM,
      EnumMaterial.INVAR,
      EnumMaterial.NICKEL,
      EnumMaterial.ZINC,
      EnumMaterial.BRASS,
      EnumMaterial.SILVER,
      EnumMaterial.STEEL,
      EnumMaterial.LEAD,
      EnumMaterial.PLATINUM,
      EnumMaterial.CUPRONICKEL,
      EnumMaterial.ENDERPEARL,
      EnumMaterial.SIGNALUM,
      EnumMaterial.LUMIUM,
      EnumMaterial.ENDERIUM,
      EnumMaterial.CHARCOAL,
      EnumMaterial.OBSIDIAN,
      EnumMaterial.SULFUR,
      EnumMaterial.NITER,
      EnumMaterial.ALUMINA,
      EnumMaterial.ALUMINIUM,
      EnumMaterial.CHROMIUM,
      EnumMaterial.OSMIUM)),
  
  NUGGET("nugget",ImmutableList.of(
      EnumMaterial.IRON,
      EnumMaterial.COPPER,
      EnumMaterial.TIN,
      EnumMaterial.BRONZE,
      EnumMaterial.ELECTRUM,
      EnumMaterial.INVAR,
      EnumMaterial.NICKEL,
      EnumMaterial.ZINC,
      EnumMaterial.BRASS,
      EnumMaterial.SILVER,
      EnumMaterial.STEEL,
      EnumMaterial.LEAD,
      EnumMaterial.PLATINUM,
      EnumMaterial.CUPRONICKEL,
      EnumMaterial.SIGNALUM,
      EnumMaterial.LUMIUM,
      EnumMaterial.ENDERIUM,
      EnumMaterial.NULL,
      EnumMaterial.ALUMINIUM,
      EnumMaterial.CHROMIUM,
      EnumMaterial.OSMIUM)),

  //1 gear = 4 ingots
  GEAR("gear",ImmutableList.of(
      EnumMaterial.STONE,
      EnumMaterial.IRON,
      EnumMaterial.GOLD,
      EnumMaterial.COPPER,
      EnumMaterial.TIN,
      EnumMaterial.BRONZE,
      EnumMaterial.ELECTRUM,
      EnumMaterial.INVAR,
      EnumMaterial.NICKEL,
      EnumMaterial.ZINC,
      EnumMaterial.BRASS,
      EnumMaterial.SILVER,
      EnumMaterial.STEEL,
      EnumMaterial.LEAD,
      EnumMaterial.PLATINUM,
      EnumMaterial.CUPRONICKEL,
      EnumMaterial.SIGNALUM,
      EnumMaterial.LUMIUM,
      EnumMaterial.ENDERIUM,
      EnumMaterial.ALUMINIUM,
      EnumMaterial.CHROMIUM,
      EnumMaterial.OSMIUM)),

  //1 plate = 1 ingot
  PLATE("plate",ImmutableList.of(
      EnumMaterial.IRON,
      EnumMaterial.GOLD,
      EnumMaterial.COPPER,
      EnumMaterial.TIN,
      EnumMaterial.BRONZE,
      EnumMaterial.ELECTRUM,
      EnumMaterial.INVAR,
      EnumMaterial.NICKEL,
      EnumMaterial.ZINC,
      EnumMaterial.BRASS,
      EnumMaterial.SILVER,
      EnumMaterial.STEEL,
      EnumMaterial.LEAD,
      EnumMaterial.PLATINUM,
      EnumMaterial.CUPRONICKEL,
      EnumMaterial.SIGNALUM,
      EnumMaterial.LUMIUM,
      EnumMaterial.ENDERIUM,
      EnumMaterial.ALUMINIUM,
      EnumMaterial.CHROMIUM,
      EnumMaterial.OSMIUM)),  
  
  BOTTLE_DUST("bottleDust", ImmutableList.of(
      EnumMaterial.REDSTONE,
      EnumMaterial.GLOWSTONE,
      EnumMaterial.ENDERPEARL)),

  BUCKET_LIQUID("bucketLiquid", ImmutableList.of(
      EnumMaterial.REDSTONE,
      EnumMaterial.GLOWSTONE,
      EnumMaterial.ENDERPEARL,
      EnumMaterial.OSMIUM)),

  //4 bottles = 1 bucket
  BOTTLE_LIQUID("bottleLiquid", ImmutableList.of(
      EnumMaterial.REDSTONE,
      EnumMaterial.GLOWSTONE,
      EnumMaterial.ENDERPEARL)),

  //2 rods = 1 ingot
  ROD("rod",ImmutableList.of(
      EnumMaterial.IRON,
      EnumMaterial.GOLD,
      EnumMaterial.COPPER,
      EnumMaterial.TIN,
      EnumMaterial.BRONZE,
      EnumMaterial.ELECTRUM,
      EnumMaterial.INVAR,
      EnumMaterial.NICKEL,
      EnumMaterial.ZINC,
      EnumMaterial.BRASS,
      EnumMaterial.SILVER,
      EnumMaterial.STEEL,
      EnumMaterial.LEAD,
      EnumMaterial.PLATINUM,
      EnumMaterial.CUPRONICKEL,
      EnumMaterial.SIGNALUM,
      EnumMaterial.LUMIUM,
      EnumMaterial.ENDERIUM,
      EnumMaterial.ALUMINIUM,
      EnumMaterial.CHROMIUM,
      EnumMaterial.OSMIUM)),
  
  //4 small dust = 1 dust
  DUST_SMALL("dustSmall",ImmutableList.of(
      EnumMaterial.COAL,
      EnumMaterial.IRON,
      EnumMaterial.GOLD,
      EnumMaterial.COPPER,
      EnumMaterial.TIN,
      EnumMaterial.BRONZE,
      EnumMaterial.ELECTRUM,
      EnumMaterial.INVAR,
      EnumMaterial.NICKEL,
      EnumMaterial.ZINC,
      EnumMaterial.BRASS,
      EnumMaterial.SILVER,
      EnumMaterial.STEEL,
      EnumMaterial.LEAD,
      EnumMaterial.PLATINUM,
      EnumMaterial.CUPRONICKEL,
      EnumMaterial.ENDERPEARL,
      EnumMaterial.SIGNALUM,
      EnumMaterial.LUMIUM,
      EnumMaterial.ENDERIUM,
      EnumMaterial.CHARCOAL,
      EnumMaterial.OBSIDIAN,
      EnumMaterial.SULFUR,
      EnumMaterial.NITER,
      EnumMaterial.GUNPOWDER,
      EnumMaterial.BLAZE,
      EnumMaterial.REDSTONE,
      EnumMaterial.GLOWSTONE,
      EnumMaterial.ALUMINA,
      EnumMaterial.ALUMINIUM,
      EnumMaterial.CHROMIUM,
      EnumMaterial.OSMIUM));
      
  public final ImmutableList<EnumMaterial> materials;
  public final String prefix;
  public final String prefix_lc;

  EnumMaterialItem(String prefix, ImmutableList<EnumMaterial> materials)
  {
    this.materials = materials;
    this.prefix = prefix;
    this.prefix_lc = SubstratumUtils.convertToRegistryName(prefix);
  }
}
