package flamepoint1544.flametech.items;

import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
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

        if(world.isClient){
            return ActionResult.SUCCESS;
        }

        if(playerEntity.getMainHandStack().getItem() == playerEntity.getOffHandStack().getItem()){
            world.setBlockState(firePos, Blocks.FIRE.getDefaultState());
            return ActionResult.SUCCESS;
        }

        return ActionResult.FAIL;
    }
}
