package fr.jiibay.islandwarsore.listeners;

import fr.jiibay.islandwarsore.MainIWO;
import fr.jiibay.islandwarsore.managers.Stat;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.ItemStack;

public class onDrop implements Listener {

    @EventHandler
    public void onPlayerDropItem(PlayerDropItemEvent event){

        if (MainIWO.getInstance().getStat() == Stat.LOBBY || MainIWO.getInstance().getStat() == Stat.START){
            event.setCancelled(true);
        }
    }
}
