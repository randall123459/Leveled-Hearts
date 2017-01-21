package uk.ItsRandall.LeveledHearts;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import uk.ItsRandall.LeveledHearts.LeveledHeartsCommand;

public class Main extends JavaPlugin implements Listener{

    @Override
    public void onEnable() {
        getCommand("leveledhearts").setExecutor(new LeveledHeartsCommand());
        this.getServer().getPluginManager().registerEvents((Listener)(new ExpListener(this)), this);
    }
}
