package etiocook.espleef.command;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commands implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) return true;

        Player player = (Player) sender;

        if (args.length <= 3) {
            for (int x = 509; x < 527; x++) {
                System.out.println("X: " + x);

                for (int z = 508; z < 527; z++) {
                    System.out.println("z: " + z);

                        World w = player.getWorld();

                        Location locBlock = new Location(w, x, 63,z);
                            locBlock.getBlock().setType(Material.DIAMOND_ORE);

                }
            }


        }
        return false;
    }
}
