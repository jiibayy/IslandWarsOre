package fr.jiibay.islandwarsore.listeners;

import fr.jiibay.islandwarsore.MainIWO;
import fr.jiibay.islandwarsore.managers.PlayerProfile;
import fr.jiibay.islandwarsore.managers.Stat;
import fr.jiibay.islandwarsore.managers.Team;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;

public class entityDamage implements Listener {

    @EventHandler
    public void onEntityDamaged(EntityDamageEvent event) {
        Entity entity = event.getEntity();
        if(entity.getType() == EntityType.VILLAGER) {
            event.setCancelled(true);
        }
            if(MainIWO.getInstance().getStat() == Stat.LOBBY || MainIWO.getInstance().getStat() == Stat.END || MainIWO.getInstance().getStat() == Stat.START){
                event.setCancelled(true);
        }
    }

    @EventHandler
    public void onPlayerDamageByPlayer(EntityDamageByEntityEvent event) {
        Entity entity = event.getEntity();
        Entity damager = event.getDamager();

        if(!(entity instanceof Player) || !(damager instanceof Player)) {
            return;
        }

        Player player = (Player)entity;
        Player playerDamager = (Player)damager;

        PlayerProfile playerProfile = MainIWO.getInstance().playerProfile.get(player.getUniqueId());
        PlayerProfile playerProfiledamager = MainIWO.getInstance().playerProfile.get(playerDamager.getUniqueId());


        if (playerProfile.getTeam() == playerProfiledamager.getTeam()){
            event.setCancelled(true);
        }

    }
}
