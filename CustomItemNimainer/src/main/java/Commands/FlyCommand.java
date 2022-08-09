package Commands;

import com.nima.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class FlyCommand implements CommandExecutor {


    private Main plugin;
    private ArrayList<Player> list_of_flying_players = new ArrayList<>();


    public FlyCommand(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(!(sender instanceof Player p)){
            sender.sendMessage("Only a player can use this command");
            return true;
        }else if(sender instanceof Player){
            if(args.length == 0){
                if(p.hasPermission("CustomItemNimainer.fly")){
                    flymethod(p);
                }else{
                    p.sendMessage(ChatColor.RED+plugin.getConfig().getString("CustomItemNimainer-1-error-message-fly"));
                }
            }else if(args.length == 1){
                if(p.hasPermission("CustomItemNimainer.flyOthers")){
                    Player p_target = Bukkit.getPlayerExact(args[0]);
                    if(p_target == null){
                        p.sendMessage(ChatColor.RED+""+ ChatColor.BOLD+"this player does not exist");
                    }else{
                        flymethod(p_target);
                    }

                }else{
                    p.sendMessage(ChatColor.RED+plugin.getConfig().getString("CustomItemNimainer-1-error-message-otherfly"));
                }
            }

        }


        return true;
    }
    private void flymethod(Player p){
                if(list_of_flying_players.contains(p)){
                    list_of_flying_players.remove(p);
                    p.setAllowFlight(false);
                    p.sendMessage(ChatColor.YELLOW +plugin.getConfig().getString("fly-of-message"));
                }else if(!(list_of_flying_players.contains(p))){
                    list_of_flying_players.add(p);
                    p.setAllowFlight(true);
                    p.sendMessage(ChatColor.YELLOW +plugin.getConfig().getString("fly-on-message"));
                }
            }
}
