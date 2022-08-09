package events;

import Items.Wand;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class ExplosiveWandEvent implements Listener {
    @EventHandler
    public static void OnRightClick(PlayerInteractEvent event){
        if(event.getAction() == Action.RIGHT_CLICK_BLOCK){
            if(event.getItem() != null){
                if (event.getItem().getItemMeta().getLore().equals(Wand.wand.getItemMeta().getLore())){
                    Player p = event.getPlayer();
                    p.setInvulnerable(true);
                    p.getWorld().createExplosion(p.getLocation(), 1.0f, false, false);
                    p.setInvulnerable(false);
                }
            }
        }
    }
}
