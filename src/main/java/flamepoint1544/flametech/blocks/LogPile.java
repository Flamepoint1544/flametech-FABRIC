package flamepoint1544.flametech.blocks;

import flamepoint1544.flametech.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class LogPile extends Block{
    public LogPile(Settings settings) {
        super(settings.sounds(BlockSoundGroup.WOOD).nonOpaque().hardness(1));
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit){
        if(!player.getAbilities().allowModifyWorld){
            return ActionResult.PASS;
        }
        else{
            if(player.getMainHandStack().getItem() == player.getOffHandStack().getItem()){
                if(player.getMainHandStack().getItem() == ModItems.FIRE_STICK){
                    world.setBlockState(pos, Blocks.CAMPFIRE.getDefaultState());
                    player.getMainHandStack().decrement(1);
                    player.getOffHandStack().decrement(1);
                    return ActionResult.SUCCESS;
                }
            }
            
            else if(player.getMainHandStack().getItem() == Items.FLINT_AND_STEEL){
                world.setBlockState(pos, Blocks.CAMPFIRE.getDefaultState());
                return ActionResult.SUCCESS;
            }

            else if(player.getOffHandStack().getItem() == Items.FLINT_AND_STEEL){
                world.setBlockState(pos, Blocks.CAMPFIRE.getDefaultState());
                return ActionResult.SUCCESS; 
            }

            return ActionResult.FAIL;
        }
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
