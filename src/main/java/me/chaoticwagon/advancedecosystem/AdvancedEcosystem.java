package me.chaoticwagon.advancedecosystem;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.UUID;

public final class AdvancedEcosystem extends JavaPlugin {

    DataManager data;

    @Override
    public void onEnable() {
        data = new DataManager(this);
        data.saveDefaultConfig();
        if (data.getConfig().contains("entities")) {
            data.load(EntityHandler.entities);
        }

        Bukkit.getPluginManager().registerEvents(new EntityHandler(data), this);
    }

    @Override
    public void onDisable() {
        if (!EntityHandler.entities.isEmpty()) {
            data.save(EntityHandler.entities);
        }
    }


    public Entity getEntityByUUID(UUID uuid) {
        for (World world : Bukkit.getWorlds()) {
            for (Entity entity : world.getEntities()) {
                if (entity.getUniqueId().equals(uuid)) {
                    return entity;
                }
            }
        }
        return null;
    }
}
