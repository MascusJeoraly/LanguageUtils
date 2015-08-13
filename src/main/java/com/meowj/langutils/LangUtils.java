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
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;
import java.util.logging.Level;

/**
 * Created by Meow J on 6/20/2015.
 *
 * @author Meow J
 */
public class LangUtils extends JavaPlugin {

    public static LangUtils plugin;

    @Override
    public void onEnable() {
        plugin = this;
        if (getServer().getName().contains("Cauldron") || getServer().getName().contains("MCPC"))
            warn("Unsupported environment! Currently, Language Utils does NOT support Cauldron/KCauldron environment!");

        saveResource("lang/README.txt", false);

        // Init default lang
        try {
            final long startTime = System.currentTimeMillis();
            EnumLang.init();
            info("Language Utils has been enabled." + "(" + (System.currentTimeMillis() - startTime) + "ms)");
        } catch (IOException e) {
            e.printStackTrace();
        }

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
}
