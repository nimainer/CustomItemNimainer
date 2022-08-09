package Items;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class Wand {

    public static ItemStack wand;

    public static void init() {
        createWand();
    }

    private static void createWand() {
        ItemStack item = new ItemStack(Material.STICK, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§6Stick of Truth");
        List<String> lore = new ArrayList<>();
        lore.add("§7This powerful artifact is a relic of");
        lore.add("§7    Minecraft's ancient history!    ");
        lore.add("§7         Right CLick To Use         ");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.LUCK, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        wand = item;

        ShapedRecipe wand = new ShapedRecipe(NamespacedKey.minecraft("wand"), item);
        wand.shape("XXB", "XSX", "SXX");
        wand.setIngredient('X', Material.AIR);
        wand.setIngredient('B', Material.TNT_MINECART);
        wand.setIngredient('S', Material.STICK);
        Bukkit.addRecipe(wand);
    }
}