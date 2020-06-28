package fr.jiibay.islandwarsore.listeners;

import fr.jiibay.islandwarsore.managers.GiveItem;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import javax.swing.*;

public class onInteract implements Listener {

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {

        Player player = event.getPlayer();
        ItemStack itemStack = event.getItem();
        Action action = event.getAction();


        if (event.getClickedBlock().getType() == Material.CHEST){
            event.setCancelled(true);
        }

        if (itemStack != null) {

            if (event.getClickedBlock().getType() == Material.CHEST) {


                    Integer diamondInteger = 0;
                    Integer emeraldInteger = 0;
                    Integer ironInteger = 0;
                    Integer goldInteger = 0;

                    for (org.bukkit.inventory.ItemStack iStack : player.getInventory().getContents()) {

                        if (iStack.getType() == Material.DIAMOND || iStack.getType() == Material.EMERALD || iStack.getType() == Material.IRON_INGOT || iStack.getType() == Material.GOLD_INGOT) {

                            if (iStack.getType() == Material.DIAMOND)
                                diamondInteger = diamondInteger + iStack.getAmount();
                            else if (iStack.getType() == Material.EMERALD)
                                emeraldInteger = emeraldInteger + iStack.getAmount();
                            else if (iStack.getType() == Material.IRON_INGOT)
                                ironInteger = ironInteger + iStack.getAmount();
                            else if (iStack.getType() == Material.GOLD_INGOT)
                                goldInteger = goldInteger + iStack.getAmount();

                            iStack.setType(Material.AIR);

                            player.getInventory().remove(iStack);

                        }
                    }
            }
        }

        if (itemStack.getType() == Material.BANNER && itemStack.getItemMeta().getDisplayName().equals(ChatColor.AQUA + "Choisir une équipe") || itemStack.getItemMeta().getDisplayName().equals(ChatColor.RED + "Rouge") || itemStack.getItemMeta().getDisplayName().equals(ChatColor.BLUE + "Bleu")) {
            Inventory inventory = Bukkit.createInventory(null, 9, ChatColor.YELLOW + "Menu de sélection d'équipe");

            inventory.setItem(3, new GiveItem().setItemBanner(Material.BANNER, ChatColor.BLUE + "Equipe bleu", DyeColor.BLUE));
            inventory.setItem(4, new GiveItem().setItemBanner(Material.BANNER, ChatColor.WHITE + "Aucune equipe", DyeColor.WHITE));
            inventory.setItem(5, new GiveItem().setItemBanner(Material.BANNER, ChatColor.RED + "Equipe rouge", DyeColor.RED));

            player.openInventory(inventory);
        }
    }
}
