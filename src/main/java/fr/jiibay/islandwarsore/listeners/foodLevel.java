package fr.jiibay.islandwarsore.listeners;

import fr.jiibay.islandwarsore.MainIWO;
import fr.jiibay.islandwarsore.managers.Stat;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class foodLevel implements Listener {

    @EventHandler
    public void onPlayerFoodLevel(FoodLevelChangeEvent event){

        if (MainIWO.getInstance().getStat() == Stat.LOBBY || MainIWO.getInstance().getStat() == Stat.START){
            event.setCancelled(true);
        }
    }
}
