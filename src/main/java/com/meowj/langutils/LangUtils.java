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

import com.meowj.langutils.lang.LanguageHelper;
import com.meowj.langutils.lang.LanguageRegistry;
import com.meowj.langutils.lang.convert.EnumLang;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionType;

import java.io.IOException;
import java.util.logging.Level;

import static com.meowj.langutils.lang.LanguageHelper.getItemDisplayName;

/**
 * Created by Meow J on 6/20/2015.
 *
 * @author Meow J
 */
public class LangUtils extends JavaPlugin {

    public static LangUtils plugin;
    private static boolean isCauldron = false;

    @Override
    public void onEnable() {
        plugin = this;
        if (getServer().getName().contains("Cauldron") || getServer().getName().contains("MCPC")) {
            isCauldron = true;
            warn("This API is not designed for Cauldron/KCauldron server, but it should work without problems for VANILLA items/entities. Again, you cannot use this API with items/entities in mods.");
        }

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

        /*      Test        */
        ItemStack waterBottle = new Potion(PotionType.WATER).toItemStack(1);
        String sWaterBottle = LanguageHelper.getItemDisplayName(waterBottle,  "en_US");

        ItemStack awkwardPotion = new Potion(PotionType.AWKWARD).toItemStack(1);
        String sawkwardPotion = LanguageHelper.getItemDisplayName(awkwardPotion,  "en_US");

        ItemStack nightVisionPotion = new Potion(PotionType.NIGHT_VISION).toItemStack(1);;
        String sNightVisionPotion = LanguageHelper.getItemDisplayName(nightVisionPotion,  "en_US");

        Potion nightVisionPotionSplashP = new Potion(PotionType.NIGHT_VISION);
        nightVisionPotionSplashP.setSplash(true);
        ItemStack nightVisionPotionSplash = nightVisionPotionSplashP.toItemStack(1);;
        String sNightVisionPotionSplash = LanguageHelper.getItemDisplayName(nightVisionPotionSplash,  "en_US");

        int toto=0;
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
