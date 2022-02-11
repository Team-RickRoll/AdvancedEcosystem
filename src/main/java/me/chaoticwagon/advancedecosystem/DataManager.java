package me.chaoticwagon.advancedecosystem;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;

public class DataManager {

    private AdvancedEcosystem plugin;
    private FileConfiguration dataConfig = null;
    private File configFile = null;

    public DataManager(AdvancedEcosystem plugin) {
        this.plugin = plugin;
        //saves/initializes the config
        saveDefaultConfig();
    }

    public void reloadConfig() {
        if (this.configFile == null)
            this.configFile = new File(this.plugin.getDataFolder(), "data.yml");

        this.dataConfig = YamlConfiguration.loadConfiguration(this.configFile);

        InputStream defaultStream = this.plugin.getResource("data.yml");
        if (defaultStream != null){
            YamlConfiguration defaultConfig = YamlConfiguration.loadConfiguration(new InputStreamReader(defaultStream));
            this.dataConfig.setDefaults(defaultConfig);
        }
    }

    public FileConfiguration getConfig() {
        if (this.dataConfig == null)
            reloadConfig();
        return this.dataConfig;
    }

    public void saveConfig() {
        if (this.dataConfig == null || this.configFile == null)
            return;

        try {
            this.getConfig().save(this.configFile);
        }catch (IOException e) {
            plugin.getLogger().log(Level.SEVERE, "Could not save config to " + this.configFile, e);
        }
    }

    public void saveDefaultConfig() {
        if (this.configFile == null)
            this.configFile = new File(this.plugin.getDataFolder(), "data.yml");

        if (this.configFile.exists()) {
            this.plugin.saveResource("data.yml", false);
        }
    }

    public void save(HashMap<String, EntityInfo> entities){
        for (Map.Entry<String,EntityInfo> entry : entities.entrySet()) {
            this.getConfig().set("entities." + entry.getKey(),entry.getValue());
        }
        this.saveConfig();
    }

    public HashMap load(HashMap<String, EntityInfo> entities){
        this.getConfig().getConfigurationSection("entities").getKeys(false).forEach(key -> {
            @SuppressWarnings("unchecked")
            EntityInfo info = (EntityInfo) this.getConfig().get("entities." + key,EntityInfo.class);
            entities.put(key, info);
        });
        return entities;
    }


}