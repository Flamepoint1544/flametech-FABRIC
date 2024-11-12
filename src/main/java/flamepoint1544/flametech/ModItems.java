package flamepoint1544.flametech;

import flamepoint1544.flametech.items.*;
import flamepoint1544.beyond_bedrock.BBToolMaterials;
import net.minecraft.item.ToolMaterials;
import net.fabricmc.fabric.api.itemgroup.v1.*;
import net.minecraft.item.*;
import net.minecraft.registry.*;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItems {
    // Items
    public static final Item TEST_ITEM = register(new Item(new Item.Settings()), "test_item");
    public static final Item FIRE_STICK = register(new FireStick(new Item.Settings()), "fire_stick");

    // Flint
    public static final Item SCREWDRIVER_FLINT = register(new Screwdriver(new Item.Settings(), 25), "screwdriver_flint");
    public static final Item SAW_FLINT = register(new Saw(BBToolMaterials.FLINT, 3.0f, -3.2f, new Item.Settings(), 25), "saw_flint");
    public static final Item FILE_FLINT = register(new File(new Item.Settings(), 25), "file_flint");
    public static final Item WRENCH_FLINT = register(new Wrench(new Item.Settings(), 25), "wrench_flint");
    public static final Item HAMMER_FLINT = register(new Hammer(new Item.Settings(), 25, ToolMaterials.WOOD, 1, 1), "hammer_flint");

    // Copper
    public static final Item SCREWDRIVER_COPPER = register(new Screwdriver(new Item.Settings(), 25), "screwdriver_copper");
    public static final Item SAW_COPPER = register(new Saw(BBToolMaterials.COPPER, 3.0f, -3.2f, new Item.Settings(), 25), "saw_copper");
    public static final Item FILE_COPPER = register(new File(new Item.Settings(), 25), "file_copper");
    public static final Item WRENCH_COPPER = register(new Wrench(new Item.Settings(), 25), "wrench_copper");
    public static final Item HAMMER_COPPER = register(new Hammer(new Item.Settings(), 25, BBToolMaterials.COPPER, 1, 1), "hammer_copper");
    public static final Item ROD_COPPER = register(new Item(new Item.Settings()), "copper_rod");

    // Iron
    public static final Item SCREWDRIVER_IRON = register(new Screwdriver(new Item.Settings(), 50), "screwdriver_iron");
    public static final Item SAW_IRON = register(new Saw(ToolMaterials.IRON, 3.0f, -3.2f, new Item.Settings(), 50), "saw_iron");
    public static final Item FILE_IRON = register(new File(new Item.Settings(), 50), "file_iron");
    public static final Item WRENCH_IRON = register(new Wrench(new Item.Settings(), 50), "wrench_iron");
    public static final Item HAMMER_IRON = register(new Hammer(new Item.Settings(), 50, ToolMaterials.IRON, 1, 1), "hammer_iron");
    public static final Item ROD_IRON = register(new Item(new Item.Settings()), "iron_rod");

    // Gold
    public static final Item SCREWDRIVER_GOLD = register(new Screwdriver(new Item.Settings(), 25), "screwdriver_gold");
    public static final Item SAW_GOLD = register(new Saw(ToolMaterials.GOLD, 3.0f, -3.2f, new Item.Settings(), 25), "saw_gold");
    public static final Item FILE_GOLD = register(new File(new Item.Settings(), 25), "file_gold");
    public static final Item WRENCH_GOLD = register(new Wrench(new Item.Settings(), 25), "wrench_gold");
    public static final Item HAMMER_GOLD = register(new Hammer(new Item.Settings(), 25, ToolMaterials.GOLD, 1, 1), "hammer_gold");
    public static final Item ROD_GOLD = register(new Item(new Item.Settings()), "gold_rod");

    // Steel

    // Diamond
    public static final Item SCREWDRIVER_DIAMOND = register(new Screwdriver(new Item.Settings(), 75), "screwdriver_diamond");
    public static final Item SAW_DIAMOND = register(new Saw(ToolMaterials.DIAMOND, 3.0f, -3.2f, new Item.Settings(), 75), "saw_diamond");
    public static final Item FILE_DIAMOND = register(new File(new Item.Settings(), 75), "file_diamond");
    public static final Item WRENCH_DIAMOND = register(new Wrench(new Item.Settings(), 75), "wrench_diamond");
    public static final Item HAMMER_DIAMOND = register(new Hammer(new Item.Settings(), 25, ToolMaterials.DIAMOND, 1, 1), "hammer_diamond");
    public static final Item ROD_DIAMOND = register(new Item(new Item.Settings()), "diamond_rod");

    // Netherite
    public static final Item SCREWDRIVER_NETHERITE = register(new Screwdriver(new Item.Settings(), 100), "screwdriver_netherite");
    public static final Item SAW_NETHERITE = register(new Saw(ToolMaterials.NETHERITE, 3.0f, -3.2f, new Item.Settings(), 100), "saw_netherite");
    public static final Item FILE_NETHERITE = register(new File(new Item.Settings(), 100), "file_netherite");
    public static final Item WRENCH_NETHERITE = register(new Wrench(new Item.Settings(), 100), "wrench_netherite");
    public static final Item HAMMER_NETHERITE = register(new Hammer(new Item.Settings(), 25, ToolMaterials.NETHERITE, 1, 1), "hammer_netherite");
    public static final Item ROD_NETHERITE = register(new Item(new Item.Settings()), "netherite_rod");

    // Ultimatium
    public static final Item SCREWDRIVER_ULTIMATIUM = register(new Screwdriver(new Item.Settings(), 200), "screwdriver_ultimatium");
    public static final Item SAW_ULTIMATIUM = register(new Saw(BBToolMaterials.ULTIMATIUM, 3.0f, -3.2f, new Item.Settings(), 200), "saw_ultimatium");
    public static final Item FILE_ULTIMATIUM = register(new File(new Item.Settings(), 200), "file_ultimatium");
    public static final Item WRENCH_ULTIMATIUM = register(new Wrench(new Item.Settings(), 200), "wrench_ultimatium");
    public static final Item HAMMER_ULTIMATIUM = register(new Hammer(new Item.Settings(), 25, BBToolMaterials.ULTIMATIUM, 1, 1), "hammer_ultimatium");
    public static final Item ROD_ULTIMATIUM = register(new Item(new Item.Settings()), "ultimatium_rod");

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
            itemGroup.add(ModBlocks.CRUSHED_BURNT_STONE);
            itemGroup.add(ModBlocks.LOG_PILE.asItem());

            // Tools
            itemGroup.add(SCREWDRIVER_FLINT);
            itemGroup.add(SAW_FLINT);
            itemGroup.add(FILE_FLINT);
            itemGroup.add(WRENCH_FLINT);
            itemGroup.add(HAMMER_FLINT);

            itemGroup.add(SCREWDRIVER_GOLD);
            itemGroup.add(SAW_GOLD);
            itemGroup.add(FILE_GOLD);
            itemGroup.add(WRENCH_GOLD);
            itemGroup.add(HAMMER_GOLD);
            itemGroup.add(ROD_GOLD);

            itemGroup.add(SCREWDRIVER_COPPER);
            itemGroup.add(SAW_COPPER);
            itemGroup.add(FILE_COPPER);
            itemGroup.add(WRENCH_COPPER);
            itemGroup.add(HAMMER_COPPER);
            itemGroup.add(ROD_COPPER);
            
            itemGroup.add(SCREWDRIVER_IRON);
            itemGroup.add(SAW_IRON);
            itemGroup.add(FILE_IRON);
            itemGroup.add(WRENCH_IRON);
            itemGroup.add(HAMMER_IRON);
            itemGroup.add(ROD_IRON);

            itemGroup.add(SCREWDRIVER_DIAMOND);
            itemGroup.add(SAW_DIAMOND);
            itemGroup.add(FILE_DIAMOND);
            itemGroup.add(WRENCH_DIAMOND);
            itemGroup.add(HAMMER_DIAMOND);
            itemGroup.add(ROD_DIAMOND);

            itemGroup.add(SCREWDRIVER_NETHERITE);
            itemGroup.add(SAW_NETHERITE);
            itemGroup.add(FILE_NETHERITE);
            itemGroup.add(WRENCH_NETHERITE);
            itemGroup.add(HAMMER_NETHERITE);
            itemGroup.add(ROD_NETHERITE);
            
            itemGroup.add(SCREWDRIVER_ULTIMATIUM);
            itemGroup.add(SAW_ULTIMATIUM);
            itemGroup.add(FILE_ULTIMATIUM);
            itemGroup.add(WRENCH_ULTIMATIUM);
            itemGroup.add(HAMMER_ULTIMATIUM);
            itemGroup.add(ROD_ULTIMATIUM);

            itemGroup.add(ModBlocks.TEST_BLOCK.asItem());
            itemGroup.add(TEST_ITEM);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(itemGroup ->{
            itemGroup.add(ModBlocks.BURNT_STONE.asItem());
        });
    }
}
