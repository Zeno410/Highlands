package exterminatorJeff.undergroundBiomes.common.item;

import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.item.ItemSlab;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 *
 * @author Zeno410
 */
public class ItemMetadataSlab extends ItemSlab {

    private final boolean isDouble;

    public static BlockSlab singleSlab(Block one, Block two) {
        if (slab(one).isDoubleSlab()) return (BlockSlab)two;
        return (BlockSlab)one;
    }

    public static BlockSlab doubleSlab(Block one, Block two) {
        if (slab(one).isDoubleSlab()) return (BlockSlab)one;
        return (BlockSlab)two;
    }

    public ItemMetadataSlab(Block slab, BlockStoneSlab otherSlab) {
        super(slab,singleSlab(slab,otherSlab), doubleSlab(slab,otherSlab), slab(slab).isDoubleSlab());
        isDouble = slab(slab).isDoubleSlab();
    }

}
