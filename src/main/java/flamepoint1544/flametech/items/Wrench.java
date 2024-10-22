package flamepoint1544.flametech.items;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.enums.Attachment;
import net.minecraft.block.enums.BlockHalf;
import net.minecraft.block.enums.ChestType;
import net.minecraft.block.enums.RailShape;
import net.minecraft.block.enums.SlabType;
import net.minecraft.block.enums.WallMountLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

public class Wrench extends Item{
    public Wrench(Settings settings, int maxDamage) {
        super(settings.maxDamage(maxDamage));
    }
    
    @Override
    public ItemStack getRecipeRemainder(ItemStack stack) {
        ItemStack defStack = this.getDefaultStack();
        defStack.setDamage(stack.getDamage() + 1);
        return defStack;
    }

    private BlockState getNextState(BlockState state){
		// declare
        BlockState newState = null;

        // Check if slab
		if(state.contains(Properties.SLAB_TYPE)){
            // change slab type
			SlabType slabType = switch(state.get(Properties.SLAB_TYPE)){
				case TOP -> SlabType.BOTTOM;
				case BOTTOM -> SlabType.TOP;
				default -> state.get(Properties.SLAB_TYPE);
			};

            // get new state
			newState = state.with(Properties.SLAB_TYPE, slabType);
		}

        // check if it rotates
		else if(state.contains(Properties.ROTATION)){
			// change the rotation
            int rot = state.get(Properties.ROTATION) + 1;

            // cap it
			if(rot == 16){
                rot = 0;
            }

            // get new state
			newState = state.with(Properties.ROTATION, rot);
		}

        // check if it has an axis 
		else if(state.contains(Properties.AXIS)){
            // switch the axis direction
			Direction.Axis axis = switch(state.get(Properties.AXIS)){
				case X -> Direction.Axis.Y;
				case Y -> Direction.Axis.Z;
				case Z -> Direction.Axis.X;
			};

            // get new state
			newState = state.with(Properties.AXIS, axis);
		}

        // check if has a facing direction
		else if(state.contains(Properties.FACING)){
            // Switch the direction
			Direction direction = switch (state.get(Properties.FACING)) {
				case UP -> Direction.NORTH;
				case NORTH -> Direction.EAST;
				case EAST -> Direction.SOUTH;
				case SOUTH -> Direction.WEST;
				case WEST -> Direction.DOWN;
				case DOWN -> Direction.UP;
			};

            // get new state
			newState = state.with(Properties.FACING, direction);
		}

        // check if hopper
		else if(state.contains(Properties.HOPPER_FACING)){
            // change facing direction
			Direction direction = switch(state.get(Properties.HOPPER_FACING)){
				case DOWN -> Direction.NORTH;
				case NORTH -> Direction.EAST;
				case EAST -> Direction.SOUTH;
				case SOUTH -> Direction.WEST;
				case WEST -> Direction.DOWN;
				default -> state.get(Properties.HOPPER_FACING);
			};

            // get new state
			newState = state.with(Properties.HOPPER_FACING, direction);
		}

        // check if horizontal facing
		else if(state.contains(Properties.HORIZONTAL_FACING)){
            // switch direction
			Direction direction = switch(state.get(Properties.HORIZONTAL_FACING)) {
				case NORTH -> Direction.EAST;
				case EAST -> Direction.SOUTH;
				case SOUTH -> Direction.WEST;
				case WEST -> Direction.NORTH;
				default -> state.get(Properties.HORIZONTAL_FACING);
			};

            // get new state
			newState = state.with(Properties.HORIZONTAL_FACING, direction);

            // check if block half facing west
			if (state.contains(Properties.BLOCK_HALF) && state.get(Properties.HORIZONTAL_FACING) == Direction.WEST){
				// get wich half
                BlockHalf blockHalf = state.get(Properties.BLOCK_HALF);
				
                // get new state
                newState = newState.with(Properties.BLOCK_HALF, blockHalf == BlockHalf.TOP ? BlockHalf.BOTTOM : BlockHalf.TOP);
			}

            // Check if attached west
			if (state.contains(Properties.ATTACHMENT) && state.get(Properties.HORIZONTAL_FACING) == Direction.WEST){
				// switch the attachment location
                Attachment attachment = switch(state.get(Properties.ATTACHMENT)) {
					case FLOOR -> Attachment.SINGLE_WALL;
					case SINGLE_WALL -> Attachment.DOUBLE_WALL;
					case DOUBLE_WALL -> Attachment.CEILING;
					case CEILING -> Attachment.FLOOR;
				};

                // get new state
				newState = newState.with(Properties.ATTACHMENT, attachment);
			}

            // check if wall mount
			if (state.contains(Properties.WALL_MOUNT_LOCATION) && state.get(Properties.HORIZONTAL_FACING) == Direction.WEST){
				// switch the wall mount location
                WallMountLocation wallMountLocation = switch(state.get(Properties.WALL_MOUNT_LOCATION)) {
					case FLOOR -> WallMountLocation.WALL;
					case WALL -> WallMountLocation.CEILING;
					case CEILING -> WallMountLocation.FLOOR;
				};

                // get the new state
				newState = newState.with(Properties.WALL_MOUNT_LOCATION, wallMountLocation);
			}
		}

        // check if straight rail
		else if(state.contains(Properties.STRAIGHT_RAIL_SHAPE)){
            // switch the rail state
			RailShape railShape = switch(state.get(Properties.STRAIGHT_RAIL_SHAPE)){
				case NORTH_SOUTH -> RailShape.EAST_WEST;
				case EAST_WEST -> RailShape.NORTH_SOUTH;
				default -> state.get(Properties.STRAIGHT_RAIL_SHAPE);
			};

            // get the new state
			newState = state.with(Properties.STRAIGHT_RAIL_SHAPE, railShape);
		}

        // check if curved rail
		else if(state.contains(Properties.RAIL_SHAPE)){
            // Switch the rail state
            RailShape railShape = switch(state.get(Properties.RAIL_SHAPE)){
				case NORTH_SOUTH -> RailShape.EAST_WEST;
				case EAST_WEST -> RailShape.NORTH_EAST;
				case NORTH_EAST -> RailShape.SOUTH_EAST;
				case SOUTH_EAST -> RailShape.SOUTH_WEST;
				case SOUTH_WEST -> RailShape.NORTH_WEST;
				case NORTH_WEST -> RailShape.NORTH_SOUTH;
				default -> state.get(Properties.RAIL_SHAPE);
			};

            // get the new state
			newState = state.with(Properties.RAIL_SHAPE, railShape);
		}

        // Check if it's hanging
		else if(state.contains(Properties.HANGING)){
            // get the new state
			newState = state.with(Properties.HANGING, !state.get(Properties.HANGING));
		}

		return newState;
	}

	@Override
	public ActionResult useOnBlock(ItemUsageContext context){
        // declare
		World world = context.getWorld();
		BlockPos pos = context.getBlockPos();
		BlockState state = world.getBlockState(pos);
		BlockState newState = null;
		Block block = state.getBlock();

		// Ignore some blocks and properties
		if(block == Blocks.END_PORTAL_FRAME || (state.contains(Properties.CHEST_TYPE) && state.get(Properties.CHEST_TYPE) != ChestType.SINGLE) || (state.contains(Properties.EXTENDED) && state.get(Properties.EXTENDED) == true)){
			return ActionResult.PASS;
		}

		// Get next state
		newState = getNextState(state);

		while(newState != null && !newState.canPlaceAt(world, pos)){
			// get the new state
            newState = getNextState(newState);

			// Break if looped
			if(newState.equals(state)){
				// check if valid
                newState = null;
				break;
			}
		}

		// Apply block state
		if(newState != null){
            // play sound to player
			context.getPlayer().playSound(SoundEvents.ENTITY_ITEM_FRAME_ROTATE_ITEM, 1.0F, 1.0F);

            // Change the block
			world.setBlockState(pos, newState);

            // end
			return ActionResult.SUCCESS;
		}
		
        else{
			return ActionResult.PASS;
		}
	}
}
