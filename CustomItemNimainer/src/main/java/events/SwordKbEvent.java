package events;

import Items.SwordKbItem;
import Items.Wand;
import org.bukkit.Effect;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class SwordKbEvent implements Listener {
    @EventHandler
    public static void onclickaawdaw(PlayerInteractEvent event){
        if(event.getAction() == Action.RIGHT_CLICK_BLOCK){
            if(event.getItem() != null){
                if (event.getItem().getItemMeta().getLore().equals(SwordKbItem.KbSword.getItemMeta().getLore())){
                    Player p = event.getPlayer();
                    p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 200, 2));
                }
            }
        }
        if(event.getAction() == Action.RIGHT_CLICK_AIR){
            if(event.getItem() != null){
                if (event.getItem().getItemMeta().getLore().equals(SwordKbItem.KbSword.getItemMeta().getLore())){
                    Player p = event.getPlayer();
                    p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 200, 2));
                }
            }
        }
    }
}

