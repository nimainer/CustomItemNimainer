package Items;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class TeleportBowItem {

    public static ItemStack TeleportBow;

    public static void init() {
        createTpBow();
    }

    private static void createTpBow() {
        ItemStack tpBow = new ItemStack(Material.BOW, 1);
        ItemMeta tpBowItemMeta = tpBow.getItemMeta();
        tpBowItemMeta.setDisplayName("Teleport Bow");
        List<String> tpBowLore = new ArrayList<>();
        tpBowLore.add("This bow let's you");
        tpBowLore.add("Teleport around");
        tpBowItemMeta.setLore(tpBowLore);
        tpBow.setItemMeta(tpBowItemMeta);
        TeleportBow = tpBow;

        ShapedRecipe wand = new ShapedRecipe(NamespacedKey.minecraft("tpb"), tpBow);
        wand.shape("XBX", "XSX", "XVX");
        wand.setIngredient('X', Material.AIR);
        wand.setIngredient('B', Material.ENDER_PEARL);
        wand.setIngredient('S', Material.CHORUS_FRUIT);
        wand.setIngredient('V', Material.BOW);
        Bukkit.addRecipe(wand);

    }


}
