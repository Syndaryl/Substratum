package exter.substratum.proxy;

import java.util.Map;

import exter.substratum.block.SubstratumBlocks;
import exter.substratum.config.SubstratumConfig;
import exter.substratum.fluid.SubstratumFluids;
import exter.substratum.block.BlockDustOre;
import exter.substratum.block.BlockMetal;
import exter.substratum.block.BlockMetalSlab;
import exter.substratum.block.BlockOre;
import exter.substratum.item.SubstratumItems;
import exter.substratum.material.EnumDyePowderColor;
import exter.substratum.material.EnumMaterial;
import exter.substratum.material.EnumMaterialItem;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMap;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fluids.BlockFluidBase;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ClientProxy extends CommonProxy
{
  static private class SimpleItemMeshDefinition implements ItemMeshDefinition
  {
    public final ModelResourceLocation location;
    
    public SimpleItemMeshDefinition(ModelResourceLocation location)
    {
      this.location = location;
    }

    @Override
    public ModelResourceLocation getModelLocation(ItemStack stack)
    {
      return location;
    }    
  }
  
  private void registerItemModel(Block block,String name,int meta)
  {
    registerItemModel(Item.getItemFromBlock(block), name, meta);
  }

  private void registerItemModel(Item item,String name,int meta)
  {
    name = "substratum:" + name;
    ModelBakery.registerItemVariants(item, new ResourceLocation(name));
    Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
    .register(item, meta, new ModelResourceLocation(name, "inventory"));
  }

  private void registerItemModel(Item item,String name)
  {
    name = "substratum:" + name;
    ModelBakery.registerItemVariants(item, new ResourceLocation(name));
    Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
    .register(item, new SimpleItemMeshDefinition(new ModelResourceLocation(name, "inventory")));
  }
  
  private void registerFluidModel(Fluid fluid,String name)
  {
    Block block = fluid.getBlock();
    Item item = Item.getItemFromBlock(block);
    ModelBakery.registerItemVariants(item);
    ModelLoader.setCustomMeshDefinition( item, new SimpleItemMeshDefinition(new ModelResourceLocation("substratum:" + name)));
    ModelLoader.setCustomStateMapper(block, (new StateMap.Builder()).ignore(BlockFluidBase.LEVEL).build());
  }

  @Override
  public void preInit()
  {
    registerFluidModel(SubstratumFluids.liquid_redstone,"liquid_redstone");
    registerFluidModel(SubstratumFluids.liquid_glowstone,"liquid_glowstone");
    registerFluidModel(SubstratumFluids.liquid_enderpearl,"liquid_enderpearl");
  }
  
  private void registerEquipment(Map<EnumMaterial,? extends Item> map,String prefix)
  {
    for(Map.Entry<EnumMaterial,? extends Item> e:map.entrySet())
    {
      registerItemModel(e.getValue(),String.format("%s_%s", prefix, e.getKey().suffix_lc));
    }
  }

  @Override
  public void init()
  {   
    for(BlockOre.EnumVariant ore:BlockOre.EnumVariant.values())
    {
      registerItemModel(SubstratumBlocks.block_ore,"ore_" + ore.material.suffix_lc, ore.ordinal());
    }

    for(BlockDustOre.EnumVariant ore:BlockDustOre.EnumVariant.values())
    {
      registerItemModel(SubstratumBlocks.block_ore_dust,"ore_" + ore.material.suffix_lc, ore.ordinal());
    }

    for(BlockMetal block:SubstratumBlocks.block_metal)
    {
      for(BlockMetal.Variant v:block.getVariants())
      {
        registerItemModel(block,"block_" + v.material.suffix_lc, v.id);
      }
    }

    for(BlockMetalSlab block:SubstratumBlocks.block_slab)
    {
      for(BlockMetalSlab.Variant v:block.getVariants())
      {
        registerItemModel(block,"slab_" + v.material.suffix_lc, block.getBottomVariantMeta(v));
      }
    }

    for(Map.Entry<EnumMaterial, ItemStack> e:SubstratumBlocks.stairs_stacks.entrySet())
    {
      ItemStack item = e.getValue();
      registerItemModel(item.getItem(),"stairs_" + e.getKey().suffix_lc,item.getMetadata());
    }


    for(EnumMaterialItem matitem:EnumMaterialItem.values())
    {
      for(EnumMaterial material:EnumMaterial.values())
      {
        ItemStack item = SubstratumItems.getStack(matitem, material, false);
        if(item != null)
        {
          registerItemModel(item.getItem(),String.format("%s_%s", matitem.prefix_lc,material.suffix_lc), item.getMetadata());
        }
      }
    }
    
    //TODO: Remove in later versions
    registerItemModel(
        SubstratumItems.item_materials.get(EnumMaterialItem.NUGGET),"nugget_iron",
            EnumMaterialItem.NUGGET.materials.indexOf(EnumMaterial.IRON));
    
    if(SubstratumConfig.dye_enabled)
    {
      for(EnumDyePowderColor color:EnumDyePowderColor.values())
      {
        registerItemModel(SubstratumItems.item_dye_powder,"dye_" + color.name_lc, color.ordinal());
        registerItemModel(SubstratumItems.item_dye_powder_small,"dye_small_" + color.name_lc, color.ordinal());
      }
    }

    if(SubstratumItems.item_mortar != null)
    {
      registerItemModel(SubstratumItems.item_mortar,"mortar");
    }

    registerEquipment(SubstratumItems.pickaxes,"pickaxe");
    registerEquipment(SubstratumItems.axes,"axe");
    registerEquipment(SubstratumItems.shovels,"shovel");
    registerEquipment(SubstratumItems.hoes,"hoe");
    registerEquipment(SubstratumItems.swords,"sword");

    registerEquipment(SubstratumItems.helmets,"helmet");
    registerEquipment(SubstratumItems.chestplates,"chestplate");
    registerEquipment(SubstratumItems.leggings,"leggings");
    registerEquipment(SubstratumItems.boots,"boots");
  }
  

  @Override
  public void postInit()
  {

  }

}
