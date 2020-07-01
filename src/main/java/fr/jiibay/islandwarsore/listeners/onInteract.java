package fr.jiibay.islandwarsore.listeners;

import fr.jiibay.islandwarsore.MainIWO;
import fr.jiibay.islandwarsore.managers.GiveItem;
import fr.jiibay.islandwarsore.managers.PlayerProfile;
import fr.jiibay.islandwarsore.managers.Stat;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import sun.applet.Main;
import sun.awt.Mutex;

import javax.swing.*;

public class onInteract implements Listener {

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {

        Player player = event.getPlayer();
        ItemStack itemStack = event.getItem();
        Action action = event.getAction();

        if (MainIWO.getInstance().getStat() == Stat.LOBBY || MainIWO.getInstance().getStat() == Stat.START) {

            if (itemStack == null) {
                return;
            }
            if (action == Action.RIGHT_CLICK_AIR || action == Action.RIGHT_CLICK_BLOCK) {

                if (itemStack.getType() == Material.BANNER && itemStack.getItemMeta().getDisplayName().equals(ChatColor.AQUA + "Choisir une équipe") || itemStack.getItemMeta().getDisplayName().equals(ChatColor.RED + "Rouge") || itemStack.getItemMeta().getDisplayName().equals(ChatColor.BLUE + "Bleu")) {
                    Inventory inventory = Bukkit.createInventory(null, 9, ChatColor.YELLOW + "Menu de sélection d'équipe");

                    inventory.setItem(3, new GiveItem().setItemBanner(Material.BANNER, ChatColor.BLUE + "Equipe bleu", DyeColor.BLUE));
                    inventory.setItem(4, new GiveItem().setItemBanner(Material.BANNER, ChatColor.WHITE + "Aucune equipe", DyeColor.WHITE));
                    inventory.setItem(5, new GiveItem().setItemBanner(Material.BANNER, ChatColor.RED + "Equipe rouge", DyeColor.RED));

                    player.openInventory(inventory);
                }
            }
            return;
        }


        if (MainIWO.getInstance().getStat() == Stat.PLAYING) {
            int diamondPoints = 5;
            int emeraldPoints = 5;
            int goldPoints = 5;
            int ironPoints = 5;

            if (event.getClickedBlock().getType() == Material.CHEST) {
                event.setCancelled(true);
            }

            if (event.getClickedBlock().getType() == Material.CHEST) {
                if (itemStack != null) {

                    PlayerProfile playerProfile = MainIWO.getInstance().playerProfile.get(player.getUniqueId());

                    if (player.getInventory().getItemInHand().getType() == Material.IRON_INGOT || player.getInventory().getItemInHand().getType() == Material.EMERALD || player.getInventory().getItemInHand().getType() == Material.GOLD_INGOT || player.getInventory().getItemInHand().getType() == Material.DIAMOND) {
                        if (player.getInventory().getItemInHand().getType() == Material.DIAMOND){
                            diamondPoints = diamondPoints * itemStack.getAmount();

                            playerProfile.getTeam().addPoints(diamondPoints);
                            player.setItemInHand(new ItemStack(Material.AIR));
                            player.sendMessage(ChatColor.YELLOW + "Vous venez de mettre : " + ChatColor.LIGHT_PURPLE + itemStack.getAmount() + ChatColor.YELLOW + " diamand dans le coffre");
                        }
                        if (player.getInventory().getItemInHand().getType() == Material.IRON_INGOT){
                            ironPoints = ironPoints * itemStack.getAmount();

                            playerProfile.getTeam().addPoints(ironPoints);
                            player.setItemInHand(new ItemStack(Material.AIR));
                            player.sendMessage(ChatColor.YELLOW + "Vous venez de mettre : " + ChatColor.LIGHT_PURPLE + itemStack.getAmount() + ChatColor.YELLOW + " fer dans le coffre");
                        }
                        if (player.getInventory().getItemInHand().getType() == Material.GOLD_INGOT){
                            ironPoints = ironPoints * itemStack.getAmount();

                            playerProfile.getTeam().addPoints(ironPoints);
                            player.setItemInHand(new ItemStack(Material.AIR));
                            player.sendMessage(ChatColor.YELLOW + "Vous venez de mettre : " + ChatColor.LIGHT_PURPLE + itemStack.getAmount() + ChatColor.YELLOW + " or dans le coffre");
                        }
                        if (player.getInventory().getItemInHand().getType() == Material.EMERALD){
                            emeraldPoints = emeraldPoints * itemStack.getAmount();

                            playerProfile.getTeam().addPoints(emeraldPoints);
                            player.setItemInHand(new ItemStack(Material.AIR));
                            player.sendMessage(ChatColor.YELLOW + "Vous venez de mettre : " + ChatColor.LIGHT_PURPLE + itemStack.getAmount() + ChatColor.YELLOW + " emeraude dans le coffre");
                        }

                    }
                }
            }
        }
    }
}
