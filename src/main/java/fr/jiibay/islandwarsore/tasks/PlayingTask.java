package fr.jiibay.islandwarsore.tasks;

import fr.jiibay.islandwarsore.MainIWO;
import fr.jiibay.islandwarsore.managers.GiveItem;
import fr.jiibay.islandwarsore.managers.PlayerProfile;
import fr.jiibay.islandwarsore.managers.Stat;
import fr.jiibay.islandwarsore.managers.Team;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class PlayingTask extends BukkitRunnable {
    public static int timer = 100;
    @Override
    public void run() {

        if (timer == 100){
            List<UUID> players = new ArrayList<>(MainIWO.getInstance().playerProfile.keySet());

            for (Integer ind = 0; ind < players.size(); ind++) {
                PlayerProfile plPr = MainIWO.getInstance().playerProfile.get(players.get(ind));
                Player player = Bukkit.getPlayer(players.get(ind));

                if(plPr.getTeam() == Team.RED) {
                    player.getInventory().setHelmet(MainIWO.getInstance().giveItem.metaLeather(Material.LEATHER_HELMET, null, 1, Color.RED, null));
                    player.getInventory().setChestplate(MainIWO.getInstance().giveItem.metaLeather(Material.LEATHER_CHESTPLATE, null, 1, Color.RED, null));
                    player.getInventory().setLeggings(MainIWO.getInstance().giveItem.metaLeather(Material.LEATHER_LEGGINGS, null, 1, Color.RED, null));
                    player.getInventory().setBoots(MainIWO.getInstance().giveItem.metaLeather(Material.LEATHER_BOOTS, null, 1, Color.RED, null));
                    player.getInventory().setItem(0, MainIWO.getInstance().giveItem.setItem(Material.IRON_SWORD, null, 1));
                    player.getInventory().setItem(1, MainIWO.getInstance().giveItem.setItem(Material.COOKED_BEEF,null, 64));
                    player.teleport(new Location(Bukkit.getWorld("world"), 1122, 6, 182));
                } else if(plPr.getTeam() == Team.BLUE) {
                    player.getInventory().setHelmet(MainIWO.getInstance().giveItem.metaLeather(Material.LEATHER_HELMET, null, 1, Color.BLUE, null));
                    player.getInventory().setChestplate(MainIWO.getInstance().giveItem.metaLeather(Material.LEATHER_CHESTPLATE, null, 1, Color.BLUE, null));
                    player.getInventory().setLeggings(MainIWO.getInstance().giveItem.metaLeather(Material.LEATHER_LEGGINGS, null, 1, Color.BLUE, null));
                    player.getInventory().setBoots(MainIWO.getInstance().giveItem.metaLeather(Material.LEATHER_BOOTS, null, 1, Color.BLUE, null));
                    player.getInventory().setItem(0, MainIWO.getInstance().giveItem.setItem(Material.IRON_SWORD, null, 1));
                    player.getInventory().setItem(1, MainIWO.getInstance().giveItem.setItem(Material.COOKED_BEEF,null, 64));
                    player.teleport(new Location(Bukkit.getWorld("world"), 1049, 6, 182));
                }
            }
        }


        if (timer == 0) {
            MainIWO.getInstance().setStat(Stat.END);
            EndTask endTask = new EndTask();
            endTask.runTaskTimer(MainIWO.getInstance(), 10L, 20L);
            cancel();
            if (Team.RED.getPoints() > Team.BLUE.getPoints()) {
                Bukkit.broadcastMessage(ChatColor.YELLOW + "La team rouge gagne ! " + ChatColor.RED + "Points : " + Team.RED.getPoints());
            }
            if (Team.BLUE.getPoints() > Team.RED.getPoints()) {
                Bukkit.broadcastMessage(ChatColor.YELLOW + "La team bleu gagne ! " + ChatColor.BLUE + "Points : " + Team.BLUE.getPoints());
            }
            if (Team.BLUE.getPoints() == Team.BLUE.getPoints())
            {
                Bukkit.broadcastMessage(ChatColor.YELLOW + "Aucune équipe gagne égalité ! ");
            }
        }
        timer--;
    }
}
