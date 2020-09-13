package etiocook.espleef.model;

import com.google.common.base.Strings;
import etiocook.espleef.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.BlockState;
import org.bukkit.entity.Player;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class AfkManager {

    private static AfkManager instance;
    final Map<String, Long> afkTimeMap = new LinkedHashMap<>();

    public static AfkManager getInstance() {
        if (instance == null) instance = new AfkManager();
        return instance;
    }

    public void setAfkTime(String name) {
        this.afkTimeMap.put(name, System.currentTimeMillis());
    }

    public void check() {

        Bukkit.getScheduler().runTaskTimerAsynchronously(Main.getInstance(), () -> this.afkTimeMap.keySet().forEach(names -> {
            long time = System.currentTimeMillis() - this.afkTimeMap.get(names);
            int seconds = (int) TimeUnit.MILLISECONDS.toSeconds(time) % 60;

            if (seconds >= 1 && seconds < 11) {
                Bukkit.broadcastMessage(" §e§lAFK TIME: " + getProgressBar(seconds, 10, 20, '▋', ChatColor.GREEN, ChatColor.RED) + " " + seconds + "/10");
                return;
            }

            Player target = Bukkit.getPlayer(names);
            Block block = target.getLocation().getBlock().getRelative(BlockFace.DOWN);
            BlockState blockState = block.getState();

            block.setType(Material.AIR);
            blockState.update(true);
         //   Bukkit.broadcastMessage("§eVoce foi retirado do evento pro está afk");
            this.afkTimeMap.remove(names);

        }), 20, 20);

    }

    public String getProgressBar(int current, int max, int totalBars, char symbol, ChatColor completedColor, ChatColor notCompletedColor) {

        float percent = (float) current / max;
        int progressBars = (int) (totalBars * percent);
        int count = totalBars - progressBars;

        if (count < 0) {
            count = max;
        }
        return Strings.repeat("" + completedColor + symbol, progressBars) + Strings.repeat("" + notCompletedColor + symbol, count);
    }


}
