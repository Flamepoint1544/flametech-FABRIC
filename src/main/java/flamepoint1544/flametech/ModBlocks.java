package flamepoint1544.flametech;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.*;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {
    // Blocks
    public static final Block TEST_BLOCK = register(new Block(AbstractBlock.Settings.create().sounds(BlockSoundGroup.GRASS)), "test_block", true);
    public static final Block BURNT_STONE = register(new Block(AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE)), "burnt_stone", true);

    public static Block register(Block block, String id, boolean registerItem){
        // Create Identifier
        Identifier blockID = Identifier.of(FlameTech.MOD_ID, id);

        // check to see if it should register an item
        if(registerItem){
            BlockItem blockItem = new BlockItem(block, new Item.Settings());
            Registry.register(Registries.ITEM, blockID, blockItem);
        }

        return Registry.register(Registries.BLOCK, blockID, block);
    }

    public static void initialize(){
        
    }
}
