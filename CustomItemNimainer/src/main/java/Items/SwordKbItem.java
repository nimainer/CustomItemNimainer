package Items;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import java.util.ArrayList;
import java.util.List;

public class SwordKbItem {

    public static ItemStack KbSword;
    public static ItemStack KbsRecipe;


    public static void init(){
        createKB();
    }
    private static void createKB(){
        ItemStack Ksword = new ItemStack(Material.POTION, 1);
        ItemMeta kSwordMeta = Ksword.getItemMeta();
        kSwordMeta.setDisplayName(" Magic Item ' Rabbit's Jump ' ");
        List<String> Kswordlore = new ArrayList<>();
        Kswordlore.add(" Gives you're jump a boost ");
        Kswordlore.add("  Right click to use  ");
        kSwordMeta.setLore(Kswordlore);
        Ksword.setItemMeta(kSwordMeta);
        KbSword = Ksword;

        ItemStack kswordRecipe = new ItemStack(Material.RABBIT_FOOT, 1);
        ItemMeta kswordRecipeMeta = kswordRecipe.getItemMeta();
        kswordRecipeMeta.setDisplayName("Super Rabbit Foot");
        List<String> kSwordRecipeLore = new ArrayList<>();
        kSwordRecipeLore.add("§7 Used to craft the ");
        kSwordRecipeLore.add("§7 'Rabbit's Jump' magic item ");
        kswordRecipeMeta.setLore(kSwordRecipeLore);
        kswordRecipe.setItemMeta(kswordRecipeMeta);
        KbsRecipe = kswordRecipe;

        ShapedRecipe kkbp = new ShapedRecipe(NamespacedKey.minecraft("s"), kswordRecipe);
        kkbp.shape("BAB", "BAB", "BAB");
        kkbp.setIngredient('A', Material.RABBIT_HIDE);
        kkbp.setIngredient('B', Material.RABBIT_FOOT);


        ShapedRecipe kbp = new ShapedRecipe(NamespacedKey.minecraft("k"), Ksword);
        kbp.shape("XAX", "XBX", "XCX");
        kbp.setIngredient('X', Material.AIR);
        kbp.setIngredient('A', new RecipeChoice.ExactChoice(kswordRecipe));
        kbp.setIngredient('B', Material.GLASS_BOTTLE);
        kbp.setIngredient('C', Material.WATER_BUCKET);

        Bukkit.addRecipe(kkbp);
        Bukkit.addRecipe(kbp);
    }
}
