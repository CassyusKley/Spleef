package etiocook.espleef.model;

import etiocook.espleef.Main;
import org.bukkit.Bukkit;

import java.util.LinkedHashMap;
import java.util.Map;

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

    public void check(){

        Bukkit.getScheduler().runTaskLaterAsynchronously(Main.getInstance(), () -> this.afkTimeMap.keySet().forEach(names -> {
            long time = System.currentTimeMillis() - this.afkTimeMap.get(names);

            if (time < 40) {
                Bukkit.broadcastMessage("§eVoce foi retirado do evento pro está afk");
                this.afkTimeMap.remove(names);
                return;
            }
            Bukkit.broadcastMessage("§7" + names + " §eestá afk por §f" + time + " §eafk");

        }), 20);

    }


}
