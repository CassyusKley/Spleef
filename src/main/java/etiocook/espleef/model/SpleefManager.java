package etiocook.espleef.model;

import etiocook.espleef.enums.SpleefState;
import lombok.Getter;

import java.util.LinkedHashSet;
import java.util.Set;

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

}

