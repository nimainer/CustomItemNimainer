package Commands;


import Items.SwordKbItem;
import Items.TeleportBowItem;
import Items.Wand;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class CScommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Only players can use that command!");
            return true;
        }
        Player p = (Player) sender;
        if(p.hasPermission("CustomItemNimainer.give")){
            if (command.getName().equalsIgnoreCase("givewand")) {
                p.getInventory().addItem(Wand.wand);
            }else if(command.getName().equalsIgnoreCase("GiveRabbitFoot")){
                p.getInventory().addItem(SwordKbItem.KbSword);
            }else if(command.getName().equalsIgnoreCase("giveTpBow")){
                p.getInventory().addItem(TeleportBowItem.TeleportBow);
            }
        }
        return true;
    }
}

