package com.king.name.plugin;

import com.destroystokyo.paper.profile.PlayerProfile;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class KinName extends JavaPlugin implements Listener {
    private final FileConfiguration config = getConfig();

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void PlayerJoinEvent(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        PlayerProfile profile = player.getPlayerProfile();

        config.set(player.getName(), "USER");
        saveConfig();
        if (config.get(player.getName()).equals("USER")) {
            profile.setName("[유져] " + player.getName());
            player.setPlayerProfile(profile);
        }
    }
}
