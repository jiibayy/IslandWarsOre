package fr.jiibay.islandwarsore.tasks;

import fr.jiibay.islandwarsore.managers.SpawnItem;
import org.bukkit.scheduler.BukkitRunnable;

public class DiamondTask extends BukkitRunnable {
    @Override
    public void run() {
        new SpawnItem().diamond();
        cancel();
    }
}
