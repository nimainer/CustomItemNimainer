package Listeners;

import Items.TeleportBowItem;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;

public class TeleportBowListener implements Listener {

    @EventHandler
    public void OnBowShoot(ProjectileHitEvent event){
        if(event.getEntity().getType() == EntityType.ARROW){
            if(event.getEntity().getShooter() instanceof Player p){
                if(p.getInventory().getItemInMainHand().getItemMeta().getLore().equals(TeleportBowItem.TeleportBow.getItemMeta().getLore())){
                    Location lo = event.getEntity().getLocation();
                    p.teleport(lo);
                    event.getEntity().remove();

                }
            }
        }
    }
}
