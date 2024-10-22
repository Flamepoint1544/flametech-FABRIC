package flamepoint1544.flametech;

import flamepoint1544.flametech.items.*;
import net.fabricmc.fabric.api.itemgroup.v1.*;
import net.minecraft.item.*;
import net.minecraft.registry.*;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItems {
    // Items
    public static final Item TEST_ITEM = register(new Item(new Item.Settings()), "test_item");
    public static final Item FIRE_STICK = register(new FireStick(new Item.Settings()), "fire_stick");
    public static final Item SCREWDRIVER_F = register(new Screwdriver(new Item.Settings(), 25), "screwdriver_flint");
    public static final Item SCREWDRIVER_I = register(new Screwdriver(new Item.Settings(), 50), "screwdriver_iron");
    public static final Item SCREWDRIVER_G = register(new Screwdriver(new Item.Settings(), 25), "screwdriver_gold");
    public static final Item SCREWDRIVER_D = register(new Screwdriver(new Item.Settings(), 75), "screwdriver_diamond");
    public static final Item SCREWDRIVER_N = register(new Screwdriver(new Item.Settings(), 100), "screwdriver_netherite");
    public static final Item SCREWDRIVER_U = register(new Screwdriver(new Item.Settings(), 200), "screwdriver_ultimatium");
    public static final Item SAW_F = register(new Screwdriver(new Item.Settings(), 25), "screwdriver_flint");
    public static final Item SAW_I = register(new Screwdriver(new Item.Settings(), 50), "screwdriver_iron");
    public static final Item SAW_G = register(new Screwdriver(new Item.Settings(), 25), "screwdriver_gold");
    public static final Item SAW_D = register(new Screwdriver(new Item.Settings(), 75), "screwdriver_diamond");
    public static final Item SAW_N = register(new Screwdriver(new Item.Settings(), 100), "screwdriver_netherite");
    public static final Item SAW_U = register(new Screwdriver(new Item.Settings(), 200), "screwdriver_ultimatium");

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
            itemGroup.add(FIRE_STICK);
            itemGroup.add(ModBlocks.BURNT_STONE.asItem());
            itemGroup.add(ModBlocks.LOG_PILE.asItem());
            itemGroup.add(SCREWDRIVER_F);
            itemGroup.add(SCREWDRIVER_G);
            itemGroup.add(SCREWDRIVER_I);
            itemGroup.add(SCREWDRIVER_D);
            itemGroup.add(SCREWDRIVER_N);
            itemGroup.add(SCREWDRIVER_U);
            itemGroup.add(ModBlocks.TEST_BLOCK.asItem());
            itemGroup.add(TEST_ITEM);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(itemGroup ->{
            itemGroup.add(ModBlocks.BURNT_STONE.asItem());
        });
    }
}
