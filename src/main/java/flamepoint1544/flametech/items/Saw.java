package flamepoint1544.flametech.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class Saw extends Item{
    public Saw(Settings settings, int maxDamage) {
        super(settings.maxDamage(maxDamage));
    }
    
    @Override
    public ItemStack getRecipeRemainder(ItemStack stack) {
        ItemStack defStack = this.getDefaultStack();
        defStack.setDamage(stack.getDamage() + 1);
        return defStack;
    }
}