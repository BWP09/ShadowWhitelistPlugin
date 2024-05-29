package me.bwp09.shadowwhitelist.listeners;

import com.destroystokyo.paper.event.server.PaperServerListPingEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class ServerListPingListener implements Listener {

    private final JavaPlugin plugin;

    public ServerListPingListener(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onServerListPing(PaperServerListPingEvent e) {
//        if (!plugin.getServer().hasWhitelist()) {
//            plugin.getLogger().severe("Please enable the whitelist for this plugin to work!");
//            return;
//        }

//        if (plugin.getServer().getWhitelistedPlayers().contains((OfflinePlayer) e.getPlayer())) { return; }
//
//        Set<OfflinePlayer> players = plugin.getServer().getWhitelistedPlayers();
//
//        plugin.getLogger().info(players.iterator().next().get);

        e.setCancelled(true);
    }
}
