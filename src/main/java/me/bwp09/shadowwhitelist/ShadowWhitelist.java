package me.bwp09.shadowwhitelist;

import me.bwp09.shadowwhitelist.listeners.PlayerLoginEventListener;
import me.bwp09.shadowwhitelist.listeners.ServerListPingListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class ShadowWhitelist extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("Started!");

        saveDefaultConfig();

        getServer().getPluginManager().registerEvents(new PlayerLoginEventListener(this), this);
        getServer().getPluginManager().registerEvents(new ServerListPingListener(this), this);
    }

    @Override
    public void onDisable() {
        getLogger().info("Shutting down");
    }
}
