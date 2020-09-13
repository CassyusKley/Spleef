package etiocook.espleef.model;

import etiocook.espleef.enums.SpleefState;
import etiocook.espleef.utils.Messages;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class SpleefManager {

    private static SpleefManager instance;
    @Getter final Set<String> spleefList;
    @Getter private SpleefState spleefState;

    public static SpleefManager getInstance() {
        if (instance == null) instance = new SpleefManager();
        return instance;
    }

    public SpleefManager() {
        this.spleefList = new LinkedHashSet<>();
    }

    public boolean contains(String name) {
        return getSpleefList().contains(name);
    }

    public void remove(String name){
        getSpleefList().remove(name);
    }

    public void announcement(){
        AtomicInteger announceCount = new AtomicInteger();

        if (announceCount.getAndIncrement() <= 3) {

            return;
        }

        if (getSpleefList().size() <= 1) {
            getSpleefList().forEach(names -> {
                Player playersList = Bukkit.getPlayer(names);

                remove(playersList.getName());
                playersList.getInventory().clear();
                playersList.performCommand("spawn");
            });

            Bukkit.broadcastMessage(Messages.LACK_PLAYERS);
            return;
        }

    }

}

