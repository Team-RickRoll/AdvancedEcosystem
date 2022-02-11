package me.chaoticwagon.advancedecosystem;

import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Pig;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class EntityHandler implements Listener {
    public DataManager data;

    public EntityHandler(DataManager data) {
        this.data = data;
    }

    public static HashMap<String,EntityInfo> entities = new HashMap<String,EntityInfo>();

    @EventHandler
    public void onSpawn(EntitySpawnEvent event) {
        String entity = event.getEntity().getUniqueId().toString();
        Entity type = event.getEntity();

        if (type instanceof Pig) {
            Date date = new Date(Bukkit.getWorld("world").getFullTime());
            EntityInfo pig = new EntityInfo(date.getDay(),event.getEntity().getType());
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

    public void save(){
        for (Map.Entry<String,EntityInfo> entry : entities.entrySet()) {
            this.data.getConfig().set("entities." + entry.getKey(),entry.getValue());
        }
        this.data.saveConfig();
    }

    public void load(){
        this.data.getConfig().getConfigurationSection("entities").getKeys(false).forEach(key -> {
            EntityInfo info = (EntityInfo) this.data.getConfig().get("entities." + key,EntityInfo.class);
            entities.put(key, info);
        });
    }





}
