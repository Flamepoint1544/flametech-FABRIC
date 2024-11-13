package flamepoint1544.flametech.items;

import java.util.Map;
import java.util.Optional;

import com.google.common.collect.ImmutableMap;

import flamepoint1544.flametech.ModBlocks;
import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import net.minecraft.world.event.GameEvent.Emitter;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class Hammer extends PickaxeItem{
    protected static final Map<Block, Block> CRUSHED_BLOCKS;
    static{
        CRUSHED_BLOCKS = (new ImmutableMap.Builder()).put(Blocks.STONE, Blocks.COBBLESTONE).put(Blocks.SMOOTH_STONE, Blocks.COBBLESTONE).put(Blocks.CRACKED_STONE_BRICKS, Blocks.COBBLESTONE).put(Blocks.COBBLESTONE, Blocks.GRAVEL).put(Blocks.MOSSY_COBBLESTONE, Blocks.GRAVEL).put(Blocks.GRAVEL, Blocks.SAND).put(Blocks.STONE_BRICKS, Blocks.CRACKED_STONE_BRICKS).put(Blocks.MOSSY_STONE_BRICKS, Blocks.CRACKED_STONE_BRICKS).put(Blocks.POLISHED_GRANITE, Blocks.GRANITE).put(Blocks.POLISHED_ANDESITE, Blocks.ANDESITE).put(Blocks.POLISHED_DIORITE, Blocks.DIORITE).put(Blocks.DEEPSLATE, Blocks.COBBLED_DEEPSLATE).put(Blocks.CHISELED_DEEPSLATE, Blocks.DEEPSLATE).put(Blocks.POLISHED_DEEPSLATE, Blocks.DEEPSLATE).put(Blocks.CRACKED_DEEPSLATE_BRICKS, Blocks.DEEPSLATE).put(Blocks.CRACKED_DEEPSLATE_TILES, Blocks.DEEPSLATE).put(Blocks.DEEPSLATE_BRICKS, Blocks.CRACKED_DEEPSLATE_BRICKS).put(Blocks.DEEPSLATE_TILES, Blocks.CRACKED_DEEPSLATE_TILES).put(Blocks.MUD_BRICKS, Blocks.PACKED_MUD).put(Blocks.SANDSTONE, Blocks.SAND).put(Blocks.CHISELED_SANDSTONE, Blocks.SAND).put(Blocks.SMOOTH_SANDSTONE, Blocks.SAND).put(Blocks.CUT_SANDSTONE, Blocks.SAND).put(Blocks.RED_SANDSTONE, Blocks.RED_SAND).put(Blocks.CHISELED_RED_SANDSTONE, Blocks.RED_SAND).put(Blocks.SMOOTH_RED_SANDSTONE, Blocks.RED_SAND).put(Blocks.CUT_RED_SANDSTONE, Blocks.RED_SAND).put(Blocks.PRISMARINE_BRICKS, Blocks.PRISMARINE).put(Blocks.DARK_PRISMARINE, Blocks.PRISMARINE).put(Blocks.NETHER_BRICKS, Blocks.CRACKED_NETHER_BRICKS).put(Blocks.CRACKED_NETHER_BRICKS, Blocks.NETHERRACK).put(Blocks.SMOOTH_BASALT, Blocks.BASALT).put(Blocks.CHISELED_POLISHED_BLACKSTONE, Blocks.BLACKSTONE).put(Blocks.POLISHED_BLACKSTONE, Blocks.BLACKSTONE).put(Blocks.POLISHED_BLACKSTONE_BRICKS, Blocks.CRACKED_POLISHED_BLACKSTONE_BRICKS).put(Blocks.CRACKED_POLISHED_BLACKSTONE_BRICKS, Blocks.BLACKSTONE).put(Blocks.END_STONE_BRICKS, Blocks.END_STONE).put(Blocks.CHISELED_QUARTZ_BLOCK, Blocks.QUARTZ_BLOCK).put(Blocks.QUARTZ_BRICKS, Blocks.QUARTZ_BLOCK).put(Blocks.SMOOTH_QUARTZ, Blocks.QUARTZ_BLOCK).put(Blocks.WHITE_CONCRETE, Blocks.WHITE_CONCRETE_POWDER).put(Blocks.LIGHT_GRAY_CONCRETE, Blocks.LIGHT_GRAY_CONCRETE_POWDER).put(Blocks.GRAY_CONCRETE, Blocks.GRAY_CONCRETE_POWDER).put(Blocks.BLACK_CONCRETE, Blocks.BLACK_CONCRETE_POWDER).put(Blocks.BROWN_CONCRETE, Blocks.BROWN_CONCRETE_POWDER).put(Blocks.RED_CONCRETE, Blocks.RED_CONCRETE_POWDER).put(Blocks.ORANGE_CONCRETE, Blocks.ORANGE_CONCRETE_POWDER).put(Blocks.YELLOW_CONCRETE, Blocks.YELLOW_CONCRETE_POWDER).put(Blocks.LIME_CONCRETE, Blocks.LIME_CONCRETE_POWDER).put(Blocks.GREEN_CONCRETE, Blocks.GREEN_CONCRETE_POWDER).put(Blocks.CYAN_CONCRETE, Blocks.CYAN_CONCRETE_POWDER).put(Blocks.LIGHT_BLUE_CONCRETE, Blocks.LIGHT_BLUE_CONCRETE_POWDER).put(Blocks.BLUE_CONCRETE, Blocks.BLUE_CONCRETE_POWDER).put(Blocks.PURPLE_CONCRETE, Blocks.PURPLE_CONCRETE_POWDER).put(Blocks.MAGENTA_CONCRETE, Blocks.MAGENTA_CONCRETE_POWDER).put(Blocks.PINK_CONCRETE, Blocks.PINK_CONCRETE_POWDER).put(Blocks.WHITE_GLAZED_TERRACOTTA, Blocks.WHITE_TERRACOTTA).put(Blocks.LIGHT_GRAY_GLAZED_TERRACOTTA, Blocks.LIGHT_GRAY_TERRACOTTA).put(Blocks.GRAY_GLAZED_TERRACOTTA, Blocks.GRAY_TERRACOTTA).put(Blocks.BLACK_GLAZED_TERRACOTTA, Blocks.BLACK_TERRACOTTA).put(Blocks.BROWN_GLAZED_TERRACOTTA, Blocks.BROWN_TERRACOTTA).put(Blocks.RED_GLAZED_TERRACOTTA, Blocks.RED_TERRACOTTA).put(Blocks.ORANGE_GLAZED_TERRACOTTA, Blocks.RED_TERRACOTTA).put(Blocks.YELLOW_GLAZED_TERRACOTTA, Blocks.YELLOW_TERRACOTTA).put(Blocks.LIME_GLAZED_TERRACOTTA, Blocks.LIME_TERRACOTTA).put(Blocks.GREEN_GLAZED_TERRACOTTA, Blocks.GREEN_TERRACOTTA).put(Blocks.CYAN_GLAZED_TERRACOTTA, Blocks.CYAN_TERRACOTTA).put(Blocks.LIGHT_BLUE_GLAZED_TERRACOTTA, Blocks.LIGHT_BLUE_TERRACOTTA).put(Blocks.BLUE_GLAZED_TERRACOTTA, Blocks.BLUE_TERRACOTTA).put(Blocks.PURPLE_GLAZED_TERRACOTTA, Blocks.PURPLE_TERRACOTTA).put(Blocks.MAGENTA_GLAZED_TERRACOTTA, Blocks.MAGENTA_TERRACOTTA).put(Blocks.PINK_GLAZED_TERRACOTTA, Blocks.PINK_TERRACOTTA).put(Blocks.GLASS, Blocks.AIR).put(Blocks.TINTED_GLASS, Blocks.AIR).put(Blocks.WHITE_STAINED_GLASS, Blocks.AIR).put(Blocks.LIGHT_GRAY_STAINED_GLASS, Blocks.AIR).put(Blocks.GRAY_STAINED_GLASS, Blocks.AIR).put(Blocks.BLACK_STAINED_GLASS, Blocks.AIR).put(Blocks.BROWN_STAINED_GLASS, Blocks.AIR).put(Blocks.RED_STAINED_GLASS, Blocks.AIR).put(Blocks.ORANGE_STAINED_GLASS, Blocks.AIR).put(Blocks.YELLOW_STAINED_GLASS, Blocks.AIR).put(Blocks.GREEN_STAINED_GLASS, Blocks.AIR).put(Blocks.CYAN_STAINED_GLASS, Blocks.AIR).put(Blocks.LIGHT_BLUE_STAINED_GLASS, Blocks.AIR).put(Blocks.BLUE_STAINED_GLASS, Blocks.AIR).put(Blocks.PURPLE_STAINED_GLASS, Blocks.AIR).put(Blocks.MAGENTA_STAINED_GLASS, Blocks.AIR).put(Blocks.PINK_STAINED_GLASS, Blocks.AIR).put(Blocks.GLASS_PANE, Blocks.AIR).put(Blocks.WHITE_STAINED_GLASS_PANE, Blocks.AIR).put(Blocks.LIGHT_GRAY_STAINED_GLASS_PANE, Blocks.AIR).put(Blocks.GRAY_STAINED_GLASS_PANE, Blocks.AIR).put(Blocks.BLACK_STAINED_GLASS_PANE, Blocks.AIR).put(Blocks.BROWN_STAINED_GLASS_PANE, Blocks.AIR).put(Blocks.RED_STAINED_GLASS_PANE, Blocks.AIR).put(Blocks.ORANGE_STAINED_GLASS_PANE, Blocks.AIR).put(Blocks.YELLOW_STAINED_GLASS_PANE, Blocks.AIR).put(Blocks.GREEN_STAINED_GLASS_PANE, Blocks.AIR).put(Blocks.CYAN_STAINED_GLASS_PANE, Blocks.AIR).put(Blocks.LIGHT_BLUE_STAINED_GLASS_PANE, Blocks.AIR).put(Blocks.BLUE_STAINED_GLASS_PANE, Blocks.AIR).put(Blocks.PURPLE_STAINED_GLASS_PANE, Blocks.AIR).put(Blocks.MAGENTA_STAINED_GLASS_PANE, Blocks.AIR).put(Blocks.PINK_STAINED_GLASS_PANE, Blocks.AIR).put(Blocks.SNOW_BLOCK, Blocks.AIR).put(Blocks.BLUE_ICE, Blocks.PACKED_ICE).put(Blocks.PACKED_ICE, Blocks.ICE).put(Blocks.ICE, Blocks.SNOW_BLOCK).put(Blocks.SOUL_SAND, Blocks.SOUL_SOIL).put(Blocks.COAL_ORE, Blocks.COBBLESTONE).put(Blocks.IRON_ORE, Blocks.COBBLESTONE).put(Blocks.COPPER_ORE, Blocks.COBBLESTONE).put(Blocks.GOLD_ORE, Blocks.COBBLESTONE).put(Blocks.REDSTONE_ORE, Blocks.COBBLESTONE).put(Blocks.EMERALD_ORE, Blocks.COBBLESTONE).put(Blocks.LAPIS_ORE, Blocks.COBBLESTONE).put(Blocks.DIAMOND_ORE, Blocks.COBBLESTONE).put(Blocks.DEEPSLATE_COAL_ORE, Blocks.COBBLED_DEEPSLATE).put(Blocks.DEEPSLATE_IRON_ORE, Blocks.COBBLED_DEEPSLATE).put(Blocks.DEEPSLATE_COPPER_ORE, Blocks.COBBLED_DEEPSLATE).put(Blocks.DEEPSLATE_GOLD_ORE, Blocks.COBBLED_DEEPSLATE).put(Blocks.DEEPSLATE_REDSTONE_ORE, Blocks.COBBLED_DEEPSLATE).put(Blocks.DEEPSLATE_EMERALD_ORE, Blocks.COBBLED_DEEPSLATE).put(Blocks.DEEPSLATE_LAPIS_ORE, Blocks.COBBLED_DEEPSLATE).put(Blocks.DEEPSLATE_DIAMOND_ORE, Blocks.COBBLED_DEEPSLATE).put(Blocks.NETHER_GOLD_ORE, Blocks.NETHERRACK).put(Blocks.NETHER_QUARTZ_ORE, Blocks.NETHERRACK).put(Blocks.BUDDING_AMETHYST, Blocks.AMETHYST_BLOCK).put(ModBlocks.BURNT_STONE, ModBlocks.CRUSHED_BURNT_STONE).build();
    }

    public Hammer(Settings settings, ToolMaterial material, int attackDamage, float attackSpeed, int maxDamage) {
        super(material, attackDamage, attackSpeed, settings.maxDamage(maxDamage));
    }

    @Override
    public ItemStack getRecipeRemainder(ItemStack stack) {
        ItemStack defStack = this.getDefaultStack();
        defStack.setDamage(stack.getDamage() + 1);
        return defStack;
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        BlockPos pos = context.getBlockPos();
        PlayerEntity player = context.getPlayer();
        BlockState state = world.getBlockState(pos);
        Optional<BlockState> optional1 = this.getCrushedState(state);
        Optional<BlockState> optional2 = Optional.empty();
        ItemStack stack = context.getStack();
        if(optional1.isPresent()){
            world.playSound(player, pos, SoundEvents.BLOCK_ANVIL_BREAK, SoundCategory.BLOCKS, 1.0F, 1.0F);
            optional2 = optional1;
        }

        if(optional2.isPresent()){
            if(player instanceof ServerPlayerEntity){
                Criteria.ITEM_USED_ON_BLOCK.trigger((ServerPlayerEntity)player, pos, stack);
            }

            world.setBlockState(pos, (BlockState)optional2.get(), 11);
            world.emitGameEvent(GameEvent.BLOCK_CHANGE, pos, Emitter.of(player, optional2.get()));
            if(player != null){
                stack.damage(1, player, (p) -> {
                    p.sendToolBreakStatus(context.getHand());
                });
            }

            return ActionResult.success(world.isClient);
        }
        else{
            return ActionResult.PASS;
        }
    }

    private Optional<BlockState> getCrushedState(BlockState state) {
      return Optional.ofNullable((Block)CRUSHED_BLOCKS.get(state.getBlock())).map((block) -> {
         return (BlockState)block.getDefaultState();
      });
   }
}