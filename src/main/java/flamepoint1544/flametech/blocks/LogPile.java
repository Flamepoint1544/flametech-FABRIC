package flamepoint1544.flametech.blocks;

import net.minecraft.block.Block;
import net.minecraft.sound.BlockSoundGroup;

public class LogPile extends Block{

    public LogPile(Settings settings) {
        super(settings.sounds(BlockSoundGroup.WOOD));
    }
    
}
