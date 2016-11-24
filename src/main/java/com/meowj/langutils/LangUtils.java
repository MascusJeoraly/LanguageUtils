/*
 * Copyright (c) 2015 Jerrell Fang
 *
 * This project is Open Source and distributed under The MIT License (MIT)
 * (http://opensource.org/licenses/MIT)
 *
 * You should have received a copy of the The MIT License along with
 * this project.   If not, see <http://opensource.org/licenses/MIT>.
 */
package com.meowj.langutils;

import com.meowj.langutils.lang.LanguageRegistry;
import com.meowj.langutils.lang.convert.EnumLang;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

/**
 * Created by Meow J on 6/20/2015.
 *
 * @author Meow J
 */
public class LangUtils extends JavaPlugin {

    public static LangUtils plugin;
    private static boolean isCauldron = false;
    public FileConfiguration config;

    @Override
    public void onEnable() {
        plugin = this;
        this.config = getConfig();
        if (getServer().getName().contains("Cauldron") || getServer().getName().contains("MCPC")) {
            isCauldron = true;
            warn("This API is not designed for Cauldron/KCauldron server, but it should work without problems for VANILLA items/entities. Again, you cannot use this API with items/entities in mods.");
        }

        File readme = new File(this.getDataFolder(), "lang/README.txt");
        if (!readme.exists())
            saveResource("lang/README.txt", false);

        config.addDefault("FallbackLanguage", "en_us");
        List<String> defaultLang = new ArrayList<String>();
        defaultLang.add("en_us");
        config.addDefault("LoadLanguage", defaultLang);
        config.options().copyDefaults(true);
        saveConfig();

        // Init default lang
        final long startTime = System.currentTimeMillis();
        EnumLang.init();
        info("Language Utils has been enabled." + "(" + (System.currentTimeMillis() - startTime) + "ms)");


        LanguageRegistry.INSTANCE = new LanguageRegistry();
    }

    @Override
    public void onDisable() {
        EnumLang.clean();
        info("Language Utils has been disabled.");
    }

    /**
     * Display a info message
     *
     * @param msg message to be sent
     */
    public void info(String msg) {
        getLogger().log(Level.INFO, msg);
    }

    /**
     * Display a warning message
     *
     * @param msg message to be sent
     */
    public void warn(String msg) {
        getLogger().log(Level.WARNING, msg);
    }

    /**
     * Return true if Cauldron environment is detected
     *
     * @return true if Cauldron environment is detected
     */
    public boolean isCauldron() {
        return isCauldron;
    }
}
