package flamepoint1544.flametech.items;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolItem;
import net.minecraft.item.ToolMaterial;

public class File extends ToolItem{
    public File(Settings settings, ToolMaterial material, int maxDamage) {
        super(material, settings.maxDamage(maxDamage));
    }
    
    @Override
    public ItemStack getRecipeRemainder(ItemStack stack) {
        ItemStack defStack = this.getDefaultStack();
        defStack.setDamage(stack.getDamage() + 1);
        return defStack;
    }
}
