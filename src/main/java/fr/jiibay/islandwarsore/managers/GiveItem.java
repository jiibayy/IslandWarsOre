package fr.jiibay.islandwarsore.managers;

import org.bukkit.Color;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BannerMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import java.util.Arrays;

public class GiveItem {

    public ItemStack setItem(Material material, String name, int amount){

        ItemStack itemStack = new ItemStack(material, amount);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(name);

        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

    public ItemStack setItemBanner(Material material, String name, DyeColor dyeColor){
        ItemStack itemStack = new ItemStack(material, 1);
        BannerMeta bannerMeta = (BannerMeta) itemStack.getItemMeta();
        bannerMeta.setDisplayName(name);

        bannerMeta.setBaseColor(dyeColor);
        itemStack.setItemMeta(bannerMeta);
        return itemStack;
    }

    public ItemStack metaLeather(Material m, String ItemName, int Amount, Color color, String[] lore) {
        ItemStack item = new ItemStack(m, Amount);
        LeatherArmorMeta im = (LeatherArmorMeta)item.getItemMeta();
        im.setDisplayName(ItemName);
        im.setColor(color);
        if(lore != null)
            im.setLore(Arrays.asList(lore));
        item.setItemMeta((ItemMeta)im);
        return item;
    }

}
