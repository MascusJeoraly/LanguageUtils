/*
 *
 *  * Copyright (c) 2015 Jerrell Fang
 *  *
 *  * This project is Open Source and distributed under The MIT License (MIT)
 *  * (http://opensource.org/licenses/MIT)
 *  *
 *  * You should have received a copy of the The MIT License along with
 *  * this project.   If not, see <http://opensource.org/licenses/MIT>.
 *
 */

package com.meowj.langutils.locale;

import org.bukkit.entity.Player;

import java.lang.reflect.Field;

/**
 * Created by Meow J on 6/20/2015.
 * <p/>
 * Language helper
 *
 * @author Meow J
 */
public class LocaleHelper {

    /**
     * Return the language of the player
     *
     * @param player The player to be analyzed
     * @return the language of the player(in Java locale format)
     */
    public static String getPlayerLanguage(Player player) {
        try {
            Object handle = player.getClass().getDeclaredMethod("getHandle").invoke(player, (Object[]) null);
            Field f = handle.getClass().getDeclaredField("locale");
            f.setAccessible(true);
            return (String) f.get(handle);
        } catch (Exception e) {
            e.printStackTrace();
            return "en_US";
        }
    }
}
