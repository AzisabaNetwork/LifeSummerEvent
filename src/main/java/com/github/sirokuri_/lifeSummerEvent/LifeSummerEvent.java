package com.github.sirokuri_.lifeSummerEvent;

import com.github.sirokuri_.lifeSummerEvent.listener.LifeSummerFishingEvent;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class LifeSummerEvent extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getPluginManager().registerEvents(new LifeSummerFishingEvent(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
