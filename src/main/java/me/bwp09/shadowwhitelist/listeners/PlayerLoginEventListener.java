package me.bwp09.shadowwhitelist.listeners;

import net.kyori.adventure.text.Component;
import org.bukkit.OfflinePlayer;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;
import java.util.Random;

public class PlayerLoginEventListener implements Listener {

    private final JavaPlugin plugin;
    private final Random random;

    public PlayerLoginEventListener(JavaPlugin plugin) {
        this.plugin = plugin;
        this.random = new Random();
    }

    @EventHandler
    public void onPlayerLogin(PlayerLoginEvent e) {
        if (!plugin.getServer().hasWhitelist()) {
            plugin.getLogger().severe("Please enable the whitelist for this plugin to work!");
            return;
        }

        if (plugin.getServer().getWhitelistedPlayers().contains((OfflinePlayer) e.getPlayer())) { return; }

        List<String> kickMessages = plugin.getConfig().getStringList("kick-messages");
        String kickMessage = kickMessages.get(random.nextInt(kickMessages.size()));

        plugin.getLogger().info("Denied login for " + e.getPlayer().getName() + ". Reason: " + kickMessage);
        e.disallow(PlayerLoginEvent.Result.KICK_OTHER, Component.text(kickMessage));
    }
}
