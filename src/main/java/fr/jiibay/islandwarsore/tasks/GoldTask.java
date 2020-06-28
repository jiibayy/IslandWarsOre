package fr.jiibay.islandwarsore.tasks;

import fr.jiibay.islandwarsore.managers.SpawnItem;
import org.bukkit.scheduler.BukkitRunnable;

public class GoldTask extends BukkitRunnable {
    @Override
    public void run() {
        new SpawnItem().gold();
    }
}
