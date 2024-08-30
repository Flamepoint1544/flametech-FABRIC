package flamepoint1544.flametech;

import java.util.concurrent.CompletableFuture;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class FlameTechDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
 
        pack.addProvider(MyTagGenerator::new);
	}

	private static class MyTagGenerator extends FabricTagProvider.ItemTagProvider {
        public MyTagGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
            super(output, completableFuture);
        }

		private static final TagKey<Item> ITEMS_KEY = TagKey.of(RegistryKeys.ITEM, new Identifier(FlameTech.MOD_ID + "items"));
 
        @Override
        protected void configure(RegistryWrapper.WrapperLookup arg) {
			getOrCreateTagBuilder(ITEMS_KEY)
			.add(Items.SLIME_BALL)
			.addOptionalTag(ItemTags.DIRT);
        }
    }
}