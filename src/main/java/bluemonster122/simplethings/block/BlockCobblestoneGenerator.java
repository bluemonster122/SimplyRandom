package bluemonster122.simplethings.block;

import bluemonster122.simplethings.handler.ConfigurationHandler;
import bluemonster122.simplethings.item.SimpleItemBlockBase;
import bluemonster122.simplethings.reference.Names;
import bluemonster122.simplethings.tileentity.TileCobblestoneGenerator;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

public class BlockCobblestoneGenerator extends SimpleBlockBase implements ITileEntityProvider
{
    public BlockCobblestoneGenerator()
    {
        super(Material.IRON, Names.COBBLESTONE_GENERATOR);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public boolean addExtraInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced)
    {
        String extension = ".extra";
        if (ConfigurationHandler.cobblestone_generator_req_power > 0)
            extension += ".energy";
        else
            extension += ".noenergy";
        SimpleItemBlockBase.addStringToTooltip(I18n.format("simplethings.tooltip." + getUnlocalizedName() + extension, ConfigurationHandler.cobblestone_generator_req_power), tooltip);
        return true;
    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta)
    {
        return new TileCobblestoneGenerator();
    }
}