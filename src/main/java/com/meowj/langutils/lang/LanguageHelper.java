/*
 * Copyright (c) 2015 Jerrell Fang
 *
 * This project is Open Source and distributed under The MIT License (MIT)
 * (http://opensource.org/licenses/MIT)
 *
 * You should have received a copy of the The MIT License along with
 * this project.   If not, see <http://opensource.org/licenses/MIT>.
 */

package com.meowj.langutils.lang;

import com.meowj.langutils.lang.convert.*;
import com.meowj.langutils.locale.LocaleHelper;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.Map;

/**
 * Created by Meow J on 6/20/2015.
 * <p>
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
     * Return the display name of the item.
     *
     * @param item   The item
     * @param player The receiver of the name
     * @return The name of the item
     */
    public static String getItemDisplayName(ItemStack item, Player player) {
        return getItemDisplayName(item, LocaleHelper.getPlayerLanguage(player));
    }

    /**
     * Return the localized name of the item.
     *
     * @param item   The item
     * @param locale The language of the item
     * @return The localized name. if the item doesn't have a localized name, this method will return the unlocalized name of it.
     */
    public static String getItemName(ItemStack item, String locale) {
        Map<String, String> map = EnumLang.get(locale).getMap();
        // Potion & SpawnEgg
        if (item.getType() == Material.POTION && item.getDurability() != 0)
            return EnumPotionEffect.getLocalizedName(item, locale);
        else if (item.getType() == Material.MONSTER_EGG)
            return EnumEntity.getSpawnEggName(item, locale);

        String unlocalizedName = getItemUnlocalizedName(item);

        return map.containsKey(unlocalizedName) ? map.get(unlocalizedName) : unlocalizedName;
    }

    /**
     * Return the localized name of the item.
     *
     * @param item   The item
     * @param player The receiver of the name
     * @return The localized name. if the item doesn't have a localized name, this method will return the unlocalized name of it.
     */
    public static String getItemName(ItemStack item, Player player) {
        return getItemName(item, LocaleHelper.getPlayerLanguage(player));
    }

    /**
     * Return the unlocalized name of the item(Minecraft convention)
     *
     * @param item The item
     * @return The unlocalized name. If the item doesn't have a unlocalized name, this method will return the Material of it.
     */
    public static String getItemUnlocalizedName(ItemStack item) {
        EnumItem enumItem = EnumItem.get(new ItemEntry(item));
        return enumItem != null ? enumItem.getUnlocalizedName() : item.getType().toString();
    }

    /**
     * Translate unlocalized field to localized field.
     *
     * @param unlocalizedName The unlocalized field.
     * @param locale          The language to be translated to.
     * @return The localized field.
     */
    public static String translateToLocal(String unlocalizedName, String locale) {
        Map<String, String> map = EnumLang.get(locale).getMap();
        return map.containsKey(unlocalizedName) ? map.get(unlocalizedName) : unlocalizedName;
    }
}
