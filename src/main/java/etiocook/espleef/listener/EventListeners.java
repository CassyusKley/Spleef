package etiocook.espleef.listener;

import etiocook.espleef.model.SpleefManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class EventListeners implements Listener {

    final SpleefManager spleefManager = SpleefManager.getInstance();

    @EventHandler
    public void onBreak(BlockBreakEvent event) {

        Player player = event.getPlayer();
        spleefManager.getSpleefList().forEach(names -> {
            if (names.contains(player.getName())) {

            }

        });

    }

}
