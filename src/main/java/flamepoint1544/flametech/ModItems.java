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
    
    // Screwdrivers
    public static final Item SCREWDRIVER_F = register(new Screwdriver(new Item.Settings(), 25), "screwdriver_flint");
    public static final Item SCREWDRIVER_I = register(new Screwdriver(new Item.Settings(), 50), "screwdriver_iron");
    public static final Item SCREWDRIVER_G = register(new Screwdriver(new Item.Settings(), 25), "screwdriver_gold");
    public static final Item SCREWDRIVER_D = register(new Screwdriver(new Item.Settings(), 75), "screwdriver_diamond");
    public static final Item SCREWDRIVER_N = register(new Screwdriver(new Item.Settings(), 100), "screwdriver_netherite");
    public static final Item SCREWDRIVER_U = register(new Screwdriver(new Item.Settings(), 200), "screwdriver_ultimatium");

    // Saws
    public static final Item SAW_F = register(new Saw(ToolMaterials.WOOD, 3.0f, -3.2f, new Item.Settings(), 25), "saw_flint");
    public static final Item SAW_I = register(new Saw(ToolMaterials.IRON, 3.0f, -3.2f, new Item.Settings(), 50), "saw_iron");
    public static final Item SAW_G = register(new Saw(ToolMaterials.GOLD, 3.0f, -3.2f, new Item.Settings(), 25), "saw_gold");
    public static final Item SAW_D = register(new Saw(ToolMaterials.DIAMOND, 3.0f, -3.2f, new Item.Settings(), 75), "saw_diamond");
    public static final Item SAW_N = register(new Saw(ToolMaterials.NETHERITE, 3.0f, -3.2f, new Item.Settings(), 100), "saw_netherite");
    public static final Item SAW_U = register(new Saw(ToolMaterials.WOOD, 3.0f, -3.2f, new Item.Settings(), 200), "saw_ultimatium");

    // Files
    public static final Item FILE_F = register(new File(new Item.Settings(), 25), "file_flint");
    public static final Item FILE_I = register(new File(new Item.Settings(), 50), "file_iron");
    public static final Item FILE_G = register(new File(new Item.Settings(), 25), "file_gold");
    public static final Item FILE_D = register(new File(new Item.Settings(), 75), "file_diamond");
    public static final Item FILE_N = register(new File(new Item.Settings(), 100), "file_netherite");
    public static final Item FILE_U = register(new File(new Item.Settings(), 200), "file_ultimatium");

    // Wrenches
    public static final Item WRENCH_F = register(new Wrench(new Item.Settings(), 25), "wrench_flint");
    public static final Item WRENCH_I = register(new Wrench(new Item.Settings(), 50), "wrench_iron");
    public static final Item WRENCH_G = register(new Wrench(new Item.Settings(), 25), "wrench_gold");
    public static final Item WRENCH_D = register(new Wrench(new Item.Settings(), 75), "wrench_diamond");
    public static final Item WRENCH_N = register(new Wrench(new Item.Settings(), 100), "wrench_netherite");
    public static final Item WRENCH_U = register(new Wrench(new Item.Settings(), 200), "wrench_ultimatium");

    // Hammer
    public static final Item HAMMER_F = register(new Hammer(new Item.Settings(), 25, ToolMaterials.WOOD, 1, 1), "hammer_flint");
    public static final Item HAMMER_I = register(new Hammer(new Item.Settings(), 50, ToolMaterials.WOOD, 1, 1), "hammer_iron");
    public static final Item HAMMER_G = register(new Hammer(new Item.Settings(), 25, ToolMaterials.WOOD, 1, 1), "hammer_gold");
    public static final Item HAMMER_D = register(new Hammer(new Item.Settings(), 25, ToolMaterials.WOOD, 1, 1), "hammer_diamond");
    public static final Item HAMMER_N = register(new Hammer(new Item.Settings(), 25, ToolMaterials.WOOD, 1, 1), "hammer_netherite");
    public static final Item HAMMER_U = register(new Hammer(new Item.Settings(), 25, ToolMaterials.WOOD, 1, 1), "hammer_ultimatium");

    // Registry keys
    public static final RegistryKey<ItemGroup> PRIMARY_GROUP_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), Identifier.of(FlameTech.MOD_ID, "primary_item_group"));

    // Item Groups
    public static final ItemGroup PRIMARY_ITEM_GROUP = FabricItemGroup.builder()
    .icon(() -> new ItemStack(TEST_ITEM))
    .displayName(Text.translatable("itemGroup.flametech.primary_item_group")).build();

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
