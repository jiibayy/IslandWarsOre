package fr.jiibay.islandwarsore.listeners;

import fr.jiibay.islandwarsore.MainIWO;
import fr.jiibay.islandwarsore.managers.PlayerProfile;
import fr.jiibay.islandwarsore.managers.Stat;
import fr.jiibay.islandwarsore.managers.Team;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class playerRespawn implements Listener {

    @EventHandler
    public void onPlayerRespawn(PlayerRespawnEvent event){

        System.out.println("test");

        Player player = event.getPlayer();
        if (MainIWO.getInstance().getStat().equals(Stat.PLAYING)){

            PlayerProfile plPr = MainIWO.getInstance().playerProfile.get(player.getUniqueId());
            player.getInventory().clear();

            if (plPr.getTeam() == Team.RED) {
                player.getInventory().setHelmet(MainIWO.getInstance().giveItem.metaLeather(Material.LEATHER_HELMET, null, 1, Color.RED, null));
                player.getInventory().setChestplate(MainIWO.getInstance().giveItem.metaLeather(Material.LEATHER_CHESTPLATE, null, 1, Color.RED, null));
                player.getInventory().setLeggings(MainIWO.getInstance().giveItem.metaLeather(Material.LEATHER_LEGGINGS, null, 1, Color.RED, null));
                player.getInventory().setBoots(MainIWO.getInstance().giveItem.metaLeather(Material.LEATHER_BOOTS, null, 1, Color.RED, null));
                player.getInventory().setItem(0, MainIWO.getInstance().giveItem.setItem(Material.IRON_SWORD, null, 1));
                player.getInventory().setItem(1, MainIWO.getInstance().giveItem.setItem(Material.COOKED_BEEF, null, 64));
            } else if (plPr.getTeam() == Team.BLUE) {
                player.getInventory().setHelmet(MainIWO.getInstance().giveItem.metaLeather(Material.LEATHER_HELMET, null, 1, Color.BLUE, null));
                player.getInventory().setChestplate(MainIWO.getInstance().giveItem.metaLeather(Material.LEATHER_CHESTPLATE, null, 1, Color.BLUE, null));
                player.getInventory().setLeggings(MainIWO.getInstance().giveItem.metaLeather(Material.LEATHER_LEGGINGS, null, 1, Color.BLUE, null));
                player.getInventory().setBoots(MainIWO.getInstance().giveItem.metaLeather(Material.LEATHER_BOOTS, null, 1, Color.BLUE, null));
                player.getInventory().setItem(0, MainIWO.getInstance().giveItem.setItem(Material.IRON_SWORD, null, 1));
                player.getInventory().setItem(1, MainIWO.getInstance().giveItem.setItem(Material.COOKED_BEEF, null, 64));
            }
        }

    }
}
