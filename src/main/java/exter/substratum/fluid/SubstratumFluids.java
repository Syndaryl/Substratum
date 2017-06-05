package exter.substratum.fluid;

import java.util.EnumMap;
import java.util.Map;

import exter.substratum.block.BlockSubstratumLiquid;
import exter.substratum.block.SubstratumBlocks;
import exter.substratum.material.EnumMaterial;
import exter.substratum.util.SubstratumUtils;
import net.minecraft.block.Block;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

public class SubstratumFluids
{
  static public FluidSubstratum liquid_redstone;
  static public FluidSubstratum liquid_glowstone;
  static public FluidSubstratum liquid_enderpearl;
  static public FluidSubstratum liquid_osmium;

  static public Map<EnumMaterial,Fluid> material_fluids = new EnumMap<EnumMaterial,Fluid>(EnumMaterial.class);
  
  static private FluidSubstratum register(EnumMaterial material,String name,int temperature,int luminosity)
  {
    FluidSubstratum fluid = new FluidSubstratum(material, name,
        new ResourceLocation("substratum","blocks/" + SubstratumUtils.convertToRegistryName(name) + "_still"),
        new ResourceLocation("substratum","blocks/" + SubstratumUtils.convertToRegistryName(name) + "_flow"),
        temperature, luminosity);
    FluidRegistry.registerFluid(fluid);

    Block liquid_block = new BlockSubstratumLiquid(fluid, name);
    SubstratumBlocks.register(liquid_block);

    fluid.setBlock(liquid_block);

    material_fluids.put(material, fluid);
    
    return fluid;
  }
  
  static public void registerFluids()
  {
    liquid_redstone = register(EnumMaterial.REDSTONE, "liquidRedstone", 800, 4);
    liquid_glowstone = register(EnumMaterial.GLOWSTONE, "liquidGlowstone", 1100, 15);
    liquid_enderpearl = register(EnumMaterial.ENDERPEARL, "liquidEnderpearl", 1400, 2);
    liquid_osmium = register(EnumMaterial.OSMIUM, "liquidOsmium", 1000, 5);
  }
}
