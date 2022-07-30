package com.github.sirokuri_.lifeSummerEvent;

import com.github.sirokuri_.lifeSummerEvent.commands.LifeSummerCommands;
import com.github.sirokuri_.lifeSummerEvent.listener.LifeSummerBreakEvent;
import com.github.sirokuri_.lifeSummerEvent.listener.LifeSummerFishingEvent;
import com.github.sirokuri_.lifeSummerEvent.listener.LifeSummerRequestEvent;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class LifeSummerEvent extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getPluginManager().registerEvents(new LifeSummerFishingEvent(), this);
        Bukkit.getPluginManager().registerEvents(new LifeSummerBreakEvent(), this);
        Bukkit.getPluginManager().registerEvents(new LifeSummerRequestEvent(), this);
        getCommand("lifeSummer").setExecutor(new LifeSummerCommands());
        Bukkit.getLogger().info("[LifeSummerEventPlugin] を読み込みました");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
