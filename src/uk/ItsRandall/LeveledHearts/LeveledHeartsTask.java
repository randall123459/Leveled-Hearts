package uk.ItsRandall.LeveledHearts;

import com.google.common.collect.ImmutableMap;
import org.bukkit.entity.Player;

import java.lang.ref.WeakReference;
import java.util.TreeMap;

public final class LeveledHeartsTask implements Runnable {
    private static final TreeMap<Integer, Double> LEVEL_TO_HEALTH = new TreeMap<>(
            ImmutableMap.<Integer, Double>builder()
                    .put(0, 20D)
                    .put(5, 22D)
                    .put(10, 24D)
                    .put(15, 26D)
                    .put(20, 28D)
                    .put(25, 30D)
                    .build()
    );

    protected final WeakReference<Player> player;

    public LeveledHeartsTask(Player player) {
        this.player = new WeakReference<>(player);
    }

    @Override
    public void run() {
        final Player p = this.player.get();

        if (p == null) return;

        p.setMaxHealth(LEVEL_TO_HEALTH.floorEntry(p.getLevel()).getValue());
    }
}