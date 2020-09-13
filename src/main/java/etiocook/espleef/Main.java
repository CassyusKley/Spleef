package etiocook.espleef;

import etiocook.espleef.command.Commands;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getCommand("a").setExecutor(new Commands());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
