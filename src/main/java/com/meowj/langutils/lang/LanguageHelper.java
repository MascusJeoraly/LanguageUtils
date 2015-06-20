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

package com.meowj.langutils.lang;

import com.meowj.langutils.lang.convert.EnumItem;
import com.meowj.langutils.lang.convert.EnumLang;
import com.meowj.langutils.lang.convert.ItemEntry;
import org.bukkit.inventory.ItemStack;

/**
 * Created by Meow J on 6/20/2015.
 * <p/>
 * Some methods to get the name of a item.
 *
 * @author Meow J
 */
public class LanguageHelper {

    /**
     * Return the display name of the item.
     *
     * @param item   The item
     * @param locale The language of the item(if the item doesn't have a customized name)
     * @return The name of the item
     */
    public static String getItemDisplayName(ItemStack item, String locale) {
        if (item.hasItemMeta() && item.getItemMeta().hasDisplayName())
            return item.getItemMeta().getDisplayName();
        else
            return LanguageHelper.getItemName(item, locale);
    }

    /**
     * Return the localized name of the item.
     *
     * @param item   The item
     * @param locale The language of the item
     * @return The localized name
     */
    public static String getItemName(ItemStack item, String locale) {
        return EnumLang.get(locale).getMap().get(getItemUnlocalizedName(item));
    }

    /**
     * Return the unlocalized name of the item(Minecraft convention)
     *
     * @param item The item
     * @return The unlocalized name
     */
    public static String getItemUnlocalizedName(ItemStack item) {
        return EnumItem.get(new ItemEntry(item.getType(), item.getDurability())).getUnlocalizedName();
    }
}
