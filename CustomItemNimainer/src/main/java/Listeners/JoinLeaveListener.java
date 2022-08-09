package Listeners;

import com.nima.main.Main;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.Plugin;

public class JoinLeaveListener implements Listener {

    private Main plugin;

    public JoinLeaveListener(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        Player p = event.getPlayer();
        if(p.hasPlayedBefore()){
            event.setJoinMessage(ChatColor.YELLOW+plugin.getConfig().getString("PlayerJoinMessage_beforePlayerName")+p.getDisplayName()+plugin.getConfig().getString("PlayerJoinMessage_afterPlayerName"));
        }else{
            event.setJoinMessage(ChatColor.GREEN+plugin.getConfig().getString("PlayerJoinMessage_firsttime_beforePlayerName")+p.getDisplayName()+plugin.getConfig().getString("PlayerJoinMessage_firsttime_afterPlayerName"));
        }
    }
    @EventHandler
    public void onLeave(PlayerQuitEvent event){
        Player p = event.getPlayer();
        event.setQuitMessage(ChatColor.YELLOW+plugin.getConfig().getString("PlayerLeaveMessage_beforePlayerName")+p.getDisplayName()+plugin.getConfig().getString("PlayerLeaveMessage_afterPlayerName"));
    }
}




