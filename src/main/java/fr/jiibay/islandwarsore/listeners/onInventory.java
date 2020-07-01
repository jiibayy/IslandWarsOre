package fr.jiibay.islandwarsore.listeners;

import fr.jiibay.islandwarsore.MainIWO;
import fr.jiibay.islandwarsore.managers.GiveItem;
import fr.jiibay.islandwarsore.managers.PlayerProfile;
import fr.jiibay.islandwarsore.managers.Stat;
import fr.jiibay.islandwarsore.managers.Team;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import javax.swing.*;

public class onInventory implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event){
        Player player = (Player) event.getWhoClicked();
        ItemStack itemStack = event.getCurrentItem();
        PlayerProfile playerProfile = MainIWO.getInstance().playerProfile.get(player.getUniqueId());
        InventoryAction action = event.getAction();


        if (MainIWO.getInstance().getStat() == Stat.LOBBY || MainIWO.getInstance().getStat() == Stat.START){

            if (itemStack != null) {
                if (itemStack.getType() == Material.BANNER && itemStack.getItemMeta().getDisplayName().equals(ChatColor.BLUE + "Equipe bleu")) {

                    if (Team.BLUE.getPlNumber() == Team.BLUE.getMaxSize()){
                        player.sendMessage(ChatColor.RED + "L'équipe " + ChatColor.BLUE + "Bleu" + ChatColor.RED + " est pleine !");
                        player.closeInventory();
                        return;
                    }
                    playerProfile.getTeam().removePlayer(player);
                    Team.BLUE.addPlayer(player, playerProfile);
                    player.sendMessage(ChatColor.GREEN + "Vous avez rejoins avec succès l'équipe : " + ChatColor.BLUE + "Bleu");

                    player.setPlayerListName(playerProfile.getTeam().getName() + " " + player.getName());
                    player.closeInventory();
                    player.getInventory().setItem(4,  new GiveItem().setItemBanner(Material.BANNER, ChatColor.BLUE + "Bleu", DyeColor.BLUE));
                }

                if (itemStack.getType() == Material.BANNER && itemStack.getItemMeta().getDisplayName().equals(ChatColor.WHITE + "Aucune equipe")) {
                    playerProfile.getTeam().removePlayer(player);
                    Team.NONE.addPlayer(player, playerProfile);
                    player.sendMessage(ChatColor.GREEN + "Vous êtes désormais sans équipe !");

                    player.setPlayerListName(playerProfile.getTeam().getName() + " " + player.getName());
                    player.closeInventory();
                    player.getInventory().setItem(4,  new GiveItem().setItemBanner(Material.BANNER, ChatColor.AQUA + "Choisir une équipe", DyeColor.WHITE));
                    player.closeInventory();
                }

                if (itemStack.getType() == Material.BANNER && itemStack.getItemMeta().getDisplayName().equals(ChatColor.RED + "Equipe rouge")) {
                    if (Team.RED.getPlNumber() == Team.RED.getMaxSize()){
                        player.sendMessage(ChatColor.RED + "L'équipe " + ChatColor.RED + "Rouge" + ChatColor.RED + " est pleine !");
                        player.closeInventory();
                        return;
                    }
                    playerProfile.getTeam().removePlayer(player);
                    Team.RED.addPlayer(player, playerProfile);
                    player.sendMessage(ChatColor.GREEN + "Vous avez rejoins avec succès l'équipe : " + ChatColor.RED + "Rouge");

                    player.setPlayerListName(playerProfile.getTeam().getName() + " " + player.getName());
                    player.closeInventory();
                    player.getInventory().setItem(4,  new GiveItem().setItemBanner(Material.BANNER, ChatColor.RED + "Rouge", DyeColor.RED));
                }
            }

        }
    }
}
