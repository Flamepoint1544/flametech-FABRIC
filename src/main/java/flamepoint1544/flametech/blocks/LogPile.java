package flamepoint1544.flametech.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

public class LogPile extends Block{

    // @SuppressWarnings("deprecation")
    public LogPile(Settings settings) {
        super(settings.sounds(BlockSoundGroup.WOOD).nonOpaque());
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return VoxelShapes.cuboid(0.0, 0.0, 0.0, 1.0, 0.45, 1.0);
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return VoxelShapes.cuboid(0.0, 0.0, 0.0, 1.0, 0.45, 1.0);
    }
}
