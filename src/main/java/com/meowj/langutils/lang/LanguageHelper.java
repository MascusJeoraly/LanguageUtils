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
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
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
     * @param locale The language of the item(if the item doesn't have a customized name, the method will return the name of the item in this language)
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

        // Potion & SpawnEgg & Player Skull
        if (item.getType() == Material.POTION && item.getDurability() != 0)
            return EnumPotionEffect.getLocalizedName(item, locale);
        else if (item.getType() == Material.MONSTER_EGG)
            return EnumEntity.getSpawnEggName(item, locale);
        else if (item.getType() == Material.SKULL_ITEM && item.getDurability() == 3) // is player's skull
            return EnumItem.getPlayerSkullName(item, locale);

        return translateToLocal(getItemUnlocalizedName(item), locale);
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
     * Return the unlocalized name of the entity(Minecraft convention)
     *
     * @param entity The entity
     * @return The unlocalized name. If the entity doesn't have a unlocalized name, this method will return the EntityType of it.
     */
    public static String getEntityUnlocalizedName(Entity entity) {
        EnumEntity enumEntity = EnumEntity.get(entity.getType());
        return enumEntity != null ? enumEntity.getUnlocalizedName() : entity.getType().toString();
    }

    /**
     * Return the unlocalized name of the entity(Minecraft convention)
     *
     * @param entityType The EntityType of the entity
     * @return The unlocalized name. If the entity doesn't have a unlocalized name, this method will return the name of the EntityType.
     */
    public static String getEntityUnlocalizedName(EntityType entityType) {
        EnumEntity enumEntity = EnumEntity.get(entityType);
        return enumEntity != null ? enumEntity.getUnlocalizedName() : entityType.toString();
    }

    /**
     * Return the display name of the entity.
     *
     * @param entity The entity
     * @param locale The language of the entity(if the entity doesn't have a customized name, the method will return the name of the entity in this language)
     * @return The name of the entity
     */
    public static String getEntityDisplayName(Entity entity, String locale) {
        return entity.getCustomName() != null ? entity.getCustomName() :
                getEntityName(entity, locale);
    }

    /**
     * Return the display name of the entity.
     *
     * @param entity The entity
     * @param player The receiver of the name
     * @return The name of the entity
     */
    public static String getEntityDisplayName(Entity entity, Player player) {
        return getEntityDisplayName(entity, LocaleHelper.getPlayerLanguage(player));
    }

    /**
     * Return the localized name of the entity.
     *
     * @param entity The entity
     * @param locale The language of the item
     * @return The localized name. if the entity doesn't have a localized name, this method will return the unlocalized name of it.
     */
    public static String getEntityName(Entity entity, String locale) {
        return translateToLocal(getEntityUnlocalizedName(entity), locale);
    }

    /**
     * Return the localized name of the entity.
     *
     * @param entity The entity
     * @param player The receiver of the entity
     * @return The localized name. if the entity doesn't have a localized name, this method will return the unlocalized name of it.
     */
    public static String getEntityName(Entity entity, Player player) {
        return getEntityName(entity, LocaleHelper.getPlayerLanguage(player));
    }

    /**
     * Return the localized name of the entity.
     *
     * @param entityType The EntityType of the entity
     * @param locale     The language of the item
     * @return The localized name. if the entity doesn't have a localized name, this method will return the unlocalized name of it.
     */
    public static String getEntityName(EntityType entityType, String locale) {
        return translateToLocal(getEntityUnlocalizedName(entityType), locale);
    }

    /**
     * Return the localized name of the entity.
     *
     * @param entityType The EntityType of the entity
     * @param player     The receiver of the entity
     * @return The localized name. if the entity doesn't have a localized name, this method will return the unlocalized name of it.
     */
    public static String getEntityName(EntityType entityType, Player player) {
        return getEntityName(entityType, LocaleHelper.getPlayerLanguage(player));
    }


    /**
     * Return the unlocalized name of the enchantment level(Minecraft convention)
     *
     * @param level The enchantment level
     * @return The unlocalized name.
     */
    public static String getEnchantmentLevelUnlocalizedName(int level) {
        EnumEnchantementLevel enumEnchLevel = EnumEnchantementLevel.get(level);
        return (enumEnchLevel != null ? enumEnchLevel.getUnlocalizedName() : Integer.toString(level));
    }

    /**
     * Return the unlocalized name of the enchantment level(Minecraft convention)
     *
     * @param level The enchantment level
     * @param player The language of the level
     * @return The unlocalized name.
     */
    public static String getEnchantmentLevelName(int level, Player player) {
        return translateToLocal(getEnchantmentLevelUnlocalizedName(level), LocaleHelper.getPlayerLanguage(player));
    }

    /**
     * Return the unlocalized name of the enchantment level(Minecraft convention)
     *
     * @param level The enchantment level
     * @param locale The language of the level
     * @return The unlocalized name.
     */
    public static String getEnchantmentLevelName(int level, String locale) {
        return translateToLocal(getEnchantmentLevelUnlocalizedName(level), locale);
    }

    /**
     * Return the unlocalized name of the enchantment(Minecraft convention)
     *
     * @param ench The enchantment
     * @return The unlocalized name.
     */
    public static String getEnchantmentUnlocalizedName(Enchantment ench) {
        EnumEnchantement enumEnch = EnumEnchantement.get(ench);
        return (enumEnch != null ? enumEnch.getUnlocalizedName() : ench.getName());
    }

    /**
     * Return the display name of the enchantement.
     *
     * @param ench   The enchantment
     * @param player The receiver of the name
     * @return The name of the item
     */
    public static String getEnchantmentName(Enchantment ench, Player player) {
        return getEnchantmentName(ench, LocaleHelper.getPlayerLanguage(player));
    }

    /**
     * Return the display name of the item.
     *
     * @param ench   The enchantment
     * @param locale The language of the item(if the item doesn't have a customized name, the method will return the name of the item in this language)
     * @return The name of the item
     */
    public static String getEnchantmentName(Enchantment ench, String locale) {
        return translateToLocal(getEnchantmentUnlocalizedName(ench), locale);
    }

    /**
     * Return the display name of the enchantement.
     *
     * @param ench   The enchantment
     * @param level The enchantment level
     * @param player The receiver of the name
     * @return The name of the item
     */
    public static String getEnchantmentName(Enchantment ench, int level, Player player) {
        return getEnchantmentName(ench, level, LocaleHelper.getPlayerLanguage(player));
    }

    /**
     * Return the display name of the item.
     *
     * @param ench   The enchantment
     * @param level The enchantment level
     * @param locale The language of the item(if the item doesn't have a customized name, the method will return the name of the item in this language)
     * @return The name of the item
     */
    public static String getEnchantmentName(Enchantment ench, int level, String locale) {
        String enchantment = getEnchantmentName(ench, locale);
        String enchLevel = getEnchantmentLevelName(level, locale);
        return enchantment + (enchLevel.length()>0 ? " " + enchLevel : "");
    }


    /**
     * Translate unlocalized field to localized field.
     *
     * @param unlocalizedName The unlocalized field.
     * @param locale          The language to be translated to.
     * @return The localized field. If the localized field doesn't exist, it will return the unlocalized name.
     */
    public static String translateToLocal(String unlocalizedName, String locale) {
        Map<String, String> map = EnumLang.get(locale).getMap();
        return map.containsKey(unlocalizedName) ? map.get(unlocalizedName) : unlocalizedName;
    }
}
