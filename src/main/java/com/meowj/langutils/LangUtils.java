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
        try {
            EnumLang.init();
            info("Language Utils has been enabled.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onDisable() {
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
}
