package etiocook.espleef.model;

import lombok.Getter;

import java.util.LinkedHashSet;
import java.util.Set;

public class SpleefManager {

    private static SpleefManager instance;
    @Getter final Set<String> spleefList;

    public static SpleefManager getInstance() {
        if (instance == null) instance = new SpleefManager();
        return instance;
    }

    public SpleefManager() {
        this.spleefList = new LinkedHashSet<>();
    }

}

