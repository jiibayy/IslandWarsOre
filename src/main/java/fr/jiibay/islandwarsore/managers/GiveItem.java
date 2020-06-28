package fr.jiibay.islandwarsore.managers;

import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BannerMeta;
import org.bukkit.inventory.meta.ItemMeta;

public class GiveItem {

    public ItemStack setItem(Material material, String name){

        ItemStack itemStack = new ItemStack(material, 1);
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
}
