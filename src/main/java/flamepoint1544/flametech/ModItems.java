package flamepoint1544.flametech;

import net.fabricmc.fabric.api.itemgroup.v1.*;
import net.minecraft.item.*;
import net.minecraft.registry.*;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItems {
    // Items
    public static final Item TEST_ITEM = register(new Item(new Item.Settings()), "test_item");

    // Registry keys
    public static final RegistryKey<ItemGroup> PRIMARY_GROUP_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), Identifier.of(FlameTech.MOD_ID, "primary_item_group"));

    // Item Groups
    public static final ItemGroup PRIMARY_ITEM_GROUP = FabricItemGroup.builder()
    .icon(() -> new ItemStack(TEST_ITEM))
    .displayName(Text.translatable("itemGroup.primary_item_group")).build();

    public static Item register(Item item, String id){
        // Create Identifier
        Identifier itemID = Identifier.of(FlameTech.MOD_ID, id);

        // Register the item
        Item registeredItem = Registry.register(Registries.ITEM, itemID, item);

        // Return
        return registeredItem;
    }

    public static void initialize(){
        Registry.register(Registries.ITEM_GROUP, PRIMARY_GROUP_KEY, PRIMARY_ITEM_GROUP);

        ItemGroupEvents.modifyEntriesEvent(PRIMARY_GROUP_KEY).register(itemGroup ->{
            itemGroup.add(TEST_ITEM);
            itemGroup.add(ModBlocks.TEST_BLOCK.asItem());
            itemGroup.add(ModBlocks.BURNT_STONE.asItem());
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(itemGroup ->{
            itemGroup.add(ModBlocks.BURNT_STONE.asItem());
        });
    }
}
