package flamepoint1544.flametech.items;

import net.minecraft.item.AxeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.ActionResult;

public class Saw extends AxeItem{
    public Saw(ToolMaterial material, float attackDamage, float attackSpeed, Item.Settings settings, int maxDamage) {
        super(material, attackDamage, attackDamage, settings.maxDamage(maxDamage));
    }
    
    @Override
    public ItemStack getRecipeRemainder(ItemStack stack) {
        ItemStack defStack = this.getDefaultStack();
        defStack.setDamage(stack.getDamage() + 1);
        return defStack;
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        return super.useOnBlock(context);
    }
}
