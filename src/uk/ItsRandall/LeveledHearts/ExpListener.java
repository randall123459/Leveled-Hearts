package uk.ItsRandall.LeveledHearts;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerExpChangeEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLevelChangeEvent;
import org.bukkit.plugin.Plugin;

public class ExpListener implements Listener {
    private Plugin plugin;

    public ExpListener(Plugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onPlayerLevelChangeEvent(PlayerLevelChangeEvent event) {
        if (LeveledHeartsCommand.getleveledheartsvar()) {
            new LeveledHeartsTask(event.getPlayer()).run();
        }
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        Bukkit.getScheduler().runTaskLater(plugin, new LeveledHeartsTask(e.getPlayer()), 1);

    }
}

