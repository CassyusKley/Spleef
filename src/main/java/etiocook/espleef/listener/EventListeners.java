package etiocook.espleef.listener;

import etiocook.espleef.enums.SpleefState;
import etiocook.espleef.model.SpleefManager;
import etiocook.espleef.utils.Messages;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class EventListeners implements Listener {

    final SpleefManager spleefManager = SpleefManager.getInstance();

    @EventHandler
    public void onBreak(BlockBreakEvent event) {

        Player player = event.getPlayer();
        Block block = event.getBlock();

        if (block.getType() == Material.SNOW_BLOCK) {
            spleefManager.getSpleefList().forEach(names -> {
                if (names.contains(player.getName())) {

                    if (spleefManager.getSpleefState() == SpleefState.WAITING) {
                        player.sendMessage(Messages.NOT_STARTED);
                        event.setCancelled(true);
                        return;
                    }
                    block.setType(Material.AIR);
                }
            });
        }

    }

    @EventHandler
    public void onEntityDamage(EntityDamageByEntityEvent event) {
        if (event.getEntity() instanceof Player && event.getDamager() instanceof Player) {

            Player player = (Player) event.getEntity(), damager = (Player) event.getDamager();
            spleefManager.getSpleefList().forEach(names -> {
                if (names.contains(player.getName()) && names.contains(damager.getName())) {

                    damager.sendMessage(Messages.PVP_DISABLED);
                    event.setCancelled(true);
                }
            });
        }

    }


}
