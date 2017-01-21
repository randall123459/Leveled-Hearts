package uk.ItsRandall.LeveledHearts;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;

public class LeveledHeartsCommand implements CommandExecutor {
    public static boolean leveledheartsvar = false;

    public static boolean getleveledheartsvar() {
        return leveledheartsvar;
    }

    private Plugin plugin;

    public boolean onCommand(CommandSender sender, Command cmd, String cmdlabel, String[] args) {
        Player p = (Player) sender;
        if (args.length == 1) {
            if (args[0].equalsIgnoreCase("enable")) {
                p.sendMessage(ReferenceManager.prefix + ChatColor.GRAY + " Leveled Hearts Has Been Enabled!");
                leveledheartsvar = true;
                for (Player online : Bukkit.getOnlinePlayers()) {
                    new LeveledHeartsTask(online).run();
                }
            } else if (args[0].equalsIgnoreCase("disable")) {
                p.sendMessage(ReferenceManager.prefix + ChatColor.GRAY + " Leveled Hearts Has Been Disabled!");
                leveledheartsvar = false;
            }
        }
        return true;
    }
}
