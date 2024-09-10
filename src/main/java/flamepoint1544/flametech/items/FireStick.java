package flamepoint1544.flametech.items;

import java.util.Random;

import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

public class FireStick extends Item {

    public FireStick(Settings settings) {
        super(settings.maxCount(1));
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        // Declare
        World world = context.getWorld();
        BlockPos positionClicked = context.getBlockPos();
        Direction clickedFace = context.getSide();
        BlockPos firePos = positionClicked.offset(clickedFace);
        PlayerEntity playerEntity = context.getPlayer();
        ItemStack stack = context.getPlayer().getMainHandStack();
        ItemStack offStack = context.getPlayer().getOffHandStack();
        Random r = new Random();

        // check if client
        if(world.isClient){
            return ActionResult.SUCCESS;
        }

        // Check if holding the same item in off hand and main hand
        if(playerEntity.getMainHandStack().getItem() == playerEntity.getOffHandStack().getItem()){
            if(r.nextInt(10) == 0){
                // create the fire
                world.setBlockState(firePos, Blocks.FIRE.getDefaultState());
                world.playSound(null, firePos, SoundEvents.ITEM_FLINTANDSTEEL_USE, SoundCategory.BLOCKS);
                
                // check if creative
                if(!playerEntity.isCreative()){
                    // remove the items
                    stack.decrement(1);
                    offStack.decrement(1);
                }
                return ActionResult.SUCCESS;
            }
        }

        return ActionResult.FAIL;
    }
}
