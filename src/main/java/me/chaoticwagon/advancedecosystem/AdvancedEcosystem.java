package me.chaoticwagon.advancedecosystem;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class AdvancedEcosystem extends JavaPlugin {

    DataManager data;

    @Override
    public void onEnable() {
        data = new DataManager(this);
        data.saveDefaultConfig();

        Bukkit.getPluginManager().registerEvents(new EntityHandler(data), this);
    }

    @Override
    public void onDisable() {
        if (!EntityHandler.entities.isEmpty()) {
            data.save(EntityHandler.entities);
        }
    }
}
