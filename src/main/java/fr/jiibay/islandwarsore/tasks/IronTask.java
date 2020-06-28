package fr.jiibay.islandwarsore.tasks;

import fr.jiibay.islandwarsore.managers.SpawnItem;
import org.bukkit.scheduler.BukkitRunnable;

public class IronTask extends BukkitRunnable {
    @Override
    public void run() {
        new SpawnItem().iron();
    }
}
