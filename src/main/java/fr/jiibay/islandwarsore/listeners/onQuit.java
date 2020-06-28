package fr.jiibay.islandwarsore.listeners;

import fr.jiibay.islandwarsore.MainIWO;
import fr.jiibay.islandwarsore.managers.PlayerProfile;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class onQuit implements Listener {

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event){
        Player player = event.getPlayer();

        PlayerProfile playerProfile = MainIWO.getInstance().playerProfile.get(player.getUniqueId());


        playerProfile.getTeam().removePlayer(player);
        event.setQuitMessage(ChatColor.RED + player.getName() + ChatColor.YELLOW + " a quitté la partie !");
    }
}
