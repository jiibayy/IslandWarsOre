package fr.jiibay.islandwarsore.managers;

import net.minecraft.server.v1_8_R3.NBTTagCompound;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftVillager;
import org.bukkit.entity.Blaze;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Villager;
import org.bukkit.entity.Zombie;

public class ArmorStand {

    public void createArmorStand(Location location){

        System.out.println("test");
        org.bukkit.entity.ArmorStand armorStand = (org.bukkit.entity.ArmorStand) location.getWorld().spawnEntity(location, EntityType.ARMOR_STAND);
        Villager villager = (Villager) location.getWorld().spawnEntity(location, EntityType.VILLAGER);
        net.minecraft.server.v1_8_R3.EntityVillager nmsVillager = ((CraftVillager) villager).getHandle();
        NBTTagCompound tag = nmsVillager.getNBTTag();
        if (tag == null) {
            tag = new NBTTagCompound();
        }

        armorStand.setCustomName("test");
        armorStand.setCustomNameVisible(true);
    }
}
