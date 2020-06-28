package fr.jiibay.islandwarsore.listeners;

import fr.jiibay.islandwarsore.MainIWO;
import fr.jiibay.islandwarsore.managers.Stat;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class entityDamage implements Listener {

    @EventHandler
    public void onEntityDamage(EntityDamageEvent event){
        Entity entity =  event.getEntity();
        EntityType entityType = event.getEntityType();
        if (entityType == EntityType.VILLAGER){
            event.setCancelled(true);
        }

        if (MainIWO.getInstance().getStat() == Stat.LOBBY || MainIWO.getInstance().getStat() == Stat.START ){
            if (entity instanceof  Player){
                event.setCancelled(true);
            }
        }
    }
}
