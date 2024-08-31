package flamepoint1544.flametech;

import java.util.concurrent.CompletableFuture;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.RegistryWrapper.WrapperLookup;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class FlameTechDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
 
        pack.addProvider(ItemTagGenerator::new);
		pack.addProvider(BlockTagGenerator::new);
	}

	private static class ItemTagGenerator extends FabricTagProvider.ItemTagProvider {
        public ItemTagGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
            super(output, completableFuture);
        }

		// private static final TagKey<Item> ITEMS_KEY = TagKey.of(RegistryKeys.ITEM, new Identifier(FlameTech.MOD_ID + "items"));
		
 
        @Override
        protected void configure(RegistryWrapper.WrapperLookup arg) {
			// getOrCreateTagBuilder(ITEMS_KEY)
			// .add(Items.SLIME_BALL)
			// .addOptionalTag(ItemTags.DIRT);
        }
    }

	@SuppressWarnings("unused")
	private static class BlockTagGenerator extends FabricTagProvider.BlockTagProvider {
		public BlockTagGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
            super(output, completableFuture);
        }

		// Barrels
		private static final TagKey<Block> BARRELS = TagKey.of(RegistryKeys.BLOCK, new Identifier("c", "barrels"));
			private static final TagKey<Block> BARRELS_WOOD = TagKey.of(RegistryKeys.BLOCK, new Identifier("c", "barrels/wooden"));

		// Bookshelves
		private static final TagKey<Block> BOOKSHELVES = TagKey.of(RegistryKeys.BLOCK, new Identifier("c", "bookshelves"));

		// Budding blocks
		private static final TagKey<Block> BUDDING_BLOCKS = TagKey.of(RegistryKeys.BLOCK, new Identifier("c", "budding_blocks"));

		// Buds
		private static final TagKey<Block> BUDS = TagKey.of(RegistryKeys.BLOCK, new Identifier("c", "buds"));

		// Chains
		private static final TagKey<Block> CHAINS = TagKey.of(RegistryKeys.BLOCK, new Identifier("c", "chains"));

		// Chests
		private static final TagKey<Block> CHESTS = TagKey.of(RegistryKeys.BLOCK, new Identifier("c", "chests"));
			private static final TagKey<Block> CHESTS_WOODEN = TagKey.of(RegistryKeys.BLOCK, new Identifier("c", "chests/wooden"));

		// clusters
		private static final TagKey<Block> CLUSTERS = TagKey.of(RegistryKeys.BLOCK, new Identifier("c", "clusters"));

		// cobblestones
		private static final TagKey<Block> COBBLESTONES = TagKey.of(RegistryKeys.BLOCK, new Identifier("c", "cobblestones"));

		// concrete
		private static final TagKey<Block> CONCRETE = TagKey.of(RegistryKeys.BLOCK, new Identifier("c", "concrete"));

		// Glass blocks
		private static final TagKey<Block> GLASS_BLOCKS = TagKey.of(RegistryKeys.BLOCK, new Identifier("c", "glass_blocks"));
			private static final TagKey<Block> GLASS_BLOCKS_COLORLESS = TagKey.of(RegistryKeys.BLOCK, new Identifier("c", "glass_blocks/colorless"));
			private static final TagKey<Block> GLASS_BLOCKS_CHEAP = TagKey.of(RegistryKeys.BLOCK, new Identifier("c", "glass_blocks/cheap"));
			private static final TagKey<Block> GLASS_BLOCKS_TINTED = TagKey.of(RegistryKeys.BLOCK, new Identifier("c", "glass_blocks/tinted"));

		// Glass panes
		private static final TagKey<Block> GLASS_PANES = TagKey.of(RegistryKeys.BLOCK, new Identifier("c", "glass_panes"));
		private static final TagKey<Block> GLASS_PANES_COLORLESS = TagKey.of(RegistryKeys.BLOCK, new Identifier("c", "glass_panes/colorless"));

		// Glazed terracotta
		private static final TagKey<Block> GLAZED_TERRACOTTA = TagKey.of(RegistryKeys.BLOCK, new Identifier("c", "glazed_terracotta"));

		// Hidden?
		private static final TagKey<Block> HIDDEN_FROM_RECIPE_VIEWERS = TagKey.of(RegistryKeys.BLOCK, new Identifier("c", "hidden_from_recipe_viewers"));
		
		// Ores
		private static final TagKey<Block> ORES = TagKey.of(RegistryKeys.BLOCK, new Identifier("c", "ores"));
			private static final TagKey<Block> COAL_ORES = TagKey.of(RegistryKeys.BLOCK, new Identifier("minecraft", "coal_ores"));
			private static final TagKey<Block> COPPER_ORES = TagKey.of(RegistryKeys.BLOCK, new Identifier("minecraft", "copper_ores"));
			private static final TagKey<Block> DIAMOND_ORES = TagKey.of(RegistryKeys.BLOCK, new Identifier("minecraft", "diamond_ores"));
			private static final TagKey<Block> EMERALD_ORES = TagKey.of(RegistryKeys.BLOCK, new Identifier("minecraft", "diamond_ores"));
			private static final TagKey<Block> GOLD_ORES = TagKey.of(RegistryKeys.BLOCK, new Identifier("minecraft", "gold_ores"));
			private static final TagKey<Block> IRON_ORES = TagKey.of(RegistryKeys.BLOCK, new Identifier("minecraft", "iron_ores"));
			private static final TagKey<Block> LAPIS_ORES = TagKey.of(RegistryKeys.BLOCK, new Identifier("minecraft", "lapis_ores"));
			private static final TagKey<Block> NETHERITE_ORES = TagKey.of(RegistryKeys.BLOCK, new Identifier("c", "ores/netherite_scrap"));
			private static final TagKey<Block> REDSTONE_ORES = TagKey.of(RegistryKeys.BLOCK, new Identifier("minecraft", "redstone_ores"));
			private static final TagKey<Block> QUARTZ_ORES = TagKey.of(RegistryKeys.BLOCK, new Identifier("c", "ores/quartz"));
		
		// no move
		private static final TagKey<Block> RELOCATION_NOT_SUPPORTED = TagKey.of(RegistryKeys.BLOCK, new Identifier("c", "relocation_not_supported"));
		
		// Ropes
		private static final TagKey<Block> ROPES = TagKey.of(RegistryKeys.BLOCK, new Identifier("c", "ropes"));
		
		// Skulls
		private static final TagKey<Block> SKULLS = TagKey.of(RegistryKeys.BLOCK, new Identifier("c", "skulls"));
		
		// Stones
		private static final TagKey<Block> STONES = TagKey.of(RegistryKeys.BLOCK, new Identifier("c", "stones"));
		
		// Storage blocks
		private static final TagKey<Block> STORAGE_BLOCKS = TagKey.of(RegistryKeys.BLOCK, new Identifier("c", "storage_blocks"));
		
		// Job sites
		private static final TagKey<Block> VILLAGER_JOB_SITES = TagKey.of(RegistryKeys.BLOCK, new Identifier("c", "villager_job_sites"));
		
		// Dyes
		private static final TagKey<Block> DYED_WHITE = TagKey.of(RegistryKeys.BLOCK, new Identifier("c", "dyed/white"));
		private static final TagKey<Block> DYED_ORANGE = TagKey.of(RegistryKeys.BLOCK, new Identifier("c", "dyed/orange"));
		private static final TagKey<Block> DYED_MAGENTA = TagKey.of(RegistryKeys.BLOCK, new Identifier("c", "dyed/magenta"));
		private static final TagKey<Block> DYED_LIGHT_BLUE = TagKey.of(RegistryKeys.BLOCK, new Identifier("c", "dyed/light_blue"));
		private static final TagKey<Block> DYED_YELLOW = TagKey.of(RegistryKeys.BLOCK, new Identifier("c", "dyed/yellow"));
		private static final TagKey<Block> DYED_LIME = TagKey.of(RegistryKeys.BLOCK, new Identifier("c", "dyed/lime"));
		private static final TagKey<Block> DYED_PINK = TagKey.of(RegistryKeys.BLOCK, new Identifier("c", "dyed/pink"));
		private static final TagKey<Block> DYED_GRAY = TagKey.of(RegistryKeys.BLOCK, new Identifier("c", "dyed/gray"));
		private static final TagKey<Block> DYED_LIGHT_GRAY = TagKey.of(RegistryKeys.BLOCK, new Identifier("c", "dyed/light_gray"));
		private static final TagKey<Block> DYED_CYAN = TagKey.of(RegistryKeys.BLOCK, new Identifier("c", "dyed/cyan"));
		private static final TagKey<Block> DYED_PURPLE = TagKey.of(RegistryKeys.BLOCK, new Identifier("c", "dyed/purple"));
		private static final TagKey<Block> DYED_BLUE = TagKey.of(RegistryKeys.BLOCK, new Identifier("c", "dyed/blue"));
		private static final TagKey<Block> DYED_BROWN = TagKey.of(RegistryKeys.BLOCK, new Identifier("c", "dyed/brown"));
		private static final TagKey<Block> DYED_GREEN = TagKey.of(RegistryKeys.BLOCK, new Identifier("c", "dyed/green"));
		private static final TagKey<Block> DYED_RED = TagKey.of(RegistryKeys.BLOCK, new Identifier("c", "dyed/red"));
		private static final TagKey<Block> DYED_BLACK = TagKey.of(RegistryKeys.BLOCK, new Identifier("c", "dyed/black"));

		@Override
		protected void configure(WrapperLookup arg) {
			getOrCreateTagBuilder(BOOKSHELVES)
				.add(Blocks.CHISELED_BOOKSHELF);
			getOrCreateTagBuilder(STONES)
				.add(ModBlocks.BURNT_STONE);
		}
	}
}