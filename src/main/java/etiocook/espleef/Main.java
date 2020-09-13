package etiocook.espleef;

import etiocook.espleef.command.Commands;
import etiocook.espleef.listener.EventListeners;
import etiocook.espleef.model.AfkManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin implements Listener {

    public static Main getInstance(){
        return getPlugin(Main.class);
    }

    @Override
    public void onEnable() {
        // Plugin startup logic

        Bukkit.getPluginManager().registerEvents(new EventListeners(), this);
        getCommand("a").setExecutor(new Commands());
        AfkManager.getInstance().check();

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }


}
