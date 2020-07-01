package fr.jiibay.islandwarsore.listeners;

import fr.jiibay.islandwarsore.MainIWO;
import fr.jiibay.islandwarsore.managers.PlayerProfile;
import fr.jiibay.islandwarsore.managers.Stat;
import fr.jiibay.islandwarsore.managers.Team;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class playerDeath implements Listener {


    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event){

        Player killer = event.getEntity().getKiller();
        Player victim = event.getEntity();

        PlayerProfile playerProfile = MainIWO.getInstance().playerProfile.get(killer.getUniqueId());
        playerProfile.addKill(1);
        event.setDeathMessage(ChatColor.GRAY + victim.getName() + ChatColor.YELLOW +  " a été tuer par "+ ChatColor.GRAY + killer.getName());
        victim.spigot().respawn();
    }
}
