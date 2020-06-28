package fr.jiibay.islandwarsore.listeners;

import fr.jiibay.islandwarsore.MainIWO;
import fr.jiibay.islandwarsore.managers.PlayerProfile;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class asyncChat implements Listener {

    @EventHandler
    public void onAsyncPlayerChat(AsyncPlayerChatEvent event){

        Player player = event.getPlayer();
        PlayerProfile playerProfile = MainIWO.getInstance().playerProfile.get(player.getUniqueId());

        event.setFormat(playerProfile.getTeam().getName() + " " + player.getName() + " >> " + ChatColor.GRAY  + event.getMessage().replace("%", "%%"));
    }

}
