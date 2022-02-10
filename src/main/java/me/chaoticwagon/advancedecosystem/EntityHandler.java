package me.chaoticwagon.advancedecosystem;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Pig;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;

import java.util.Date;
import java.util.HashMap;

public class EntityHandler implements Listener {

    public static HashMap<Entity,EntityInfo> entities = new HashMap<Entity,EntityInfo>();

    @EventHandler
    public void onSpawn(EntitySpawnEvent event) {
        Entity entity = event.getEntity();

        if (entity instanceof Pig) {
            Date date = new Date(Bukkit.getWorld("world").getFullTime());
            EntityInfo pig = new EntityInfo(date.getDay(),entity.getType());
            entities.put(entity,pig);
        }

    }

    @EventHandler
    public void onInteract(PlayerInteractEntityEvent event) {
        Player player = event.getPlayer();
        Entity entity = event.getRightClicked();

        if (!event.getPlayer().isSneaking()) return;

        if (entity instanceof Pig) {
            player.sendMessage("Pig");
        }

    }


}
