package etiocook.espleef.model;

import com.google.common.base.Strings;
import etiocook.espleef.Main;
import etiocook.espleef.utils.ActionBar;
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
        this.afkTimeMap.put(name, System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(15));
    }

    public void check() {

        Bukkit.getScheduler().runTaskTimerAsynchronously(Main.getInstance(), () -> this.afkTimeMap.keySet().forEach(names -> {

            Player target = Bukkit.getPlayer(names);
            if (!hasAfk(target.getName())) {
               ActionBar actionBar = new ActionBar("§cMove, or the block below you will be removed in §e" + getTime(target.getName()) + " seconds");
               actionBar.show(target);
                return;
            }

            Block block = target.getLocation().getBlock().getRelative(BlockFace.DOWN);
            BlockState blockState = block.getState();

            this.afkTimeMap.remove(target.getName());
            Bukkit.broadcastMessage("AWDAWD");
            block.setType(Material.AIR);
            blockState.update(true);

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

    private Integer getTime(String names) {
        long time = this.afkTimeMap.get(names) - System.currentTimeMillis();
       return (int) TimeUnit.MILLISECONDS.toSeconds(time) % 60;
    }

    public boolean hasAfk(String playerName) {
        return this.afkTimeMap.get(playerName) >= System.currentTimeMillis();
    }

}
