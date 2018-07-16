/*
 * Copyright (c) 2015 Jerrell Fang
 *
 * This project is Open Source and distributed under The MIT License (MIT)
 * (http://opensource.org/licenses/MIT)
 *
 * You should have received a copy of the The MIT License along with
 * this project.   If not, see <http://opensource.org/licenses/MIT>.
 */

package com.meowj.langutils.lang.convert;

import com.meowj.langutils.lang.LanguageHelper;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionType;

import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Meow J on 7/6/2015.
 * <p>
 * A list of potion effects.
 *
 * @author Meow J
 */
public enum EnumPotionEffect {
    AWKWARD(PotionType.AWKWARD, "item.minecraft.potion.effect.awkward", "item.minecraft.splash_potion.effect.awkward", "item.minecraft.lingering_potion.effect.awkward", "item.minecraft.tipped_arrow.effect.awkward"),
    FIRE_RESISTANCE(PotionType.FIRE_RESISTANCE, "item.minecraft.potion.effect.fire_resistance", "item.minecraft.splash_potion.effect.fire_resistance", "item.minecraft.lingering_potion.effect.fire_resistance", "item.minecraft.tipped_arrow.effect.fire_resistance"),
    HARM(PotionType.INSTANT_DAMAGE, "item.minecraft.potion.effect.harming", "item.minecraft.splash_potion.effect.harming", "item.minecraft.lingering_potion.effect.harming", "item.minecraft.tipped_arrow.effect.harming"),
    HEAL(PotionType.INSTANT_HEAL, "item.minecraft.potion.effect.healing", "item.minecraft.splash_potion.effect.healing", "item.minecraft.lingering_potion.effect.healing", "item.minecraft.tipped_arrow.effect.healing"),
    INCREASE_DAMAGE(PotionType.STRENGTH, "item.minecraft.potion.effect.strength", "item.minecraft.splash_potion.effect.strength", "item.minecraft.lingering_potion.effect.strength", "item.minecraft.tipped_arrow.effect.strength"),
    INVISIBILITY(PotionType.INVISIBILITY, "item.minecraft.potion.effect.invisibility", "item.minecraft.splash_potion.effect.invisibility", "item.minecraft.lingering_potion.effect.invisibility", "item.minecraft.tipped_arrow.effect.invisibility"),
    JUMP(PotionType.JUMP, "item.minecraft.potion.effect.leaping", "item.minecraft.splash_potion.effect.leaping", "item.minecraft.lingering_potion.effect.leaping", "item.minecraft.tipped_arrow.effect.leaping"),
    LUCK(PotionType.LUCK, "item.minecraft.potion.effect.luck", "item.minecraft.splash_potion.effect.luck", "item.minecraft.lingering_potion.effect.luck", "item.minecraft.tipped_arrow.effect.luck"),
    MUNDANE(PotionType.MUNDANE, "item.minecraft.potion.effect.mundane", "item.minecraft.splash_potion.effect.mundane", "item.minecraft.lingering_potion.effect.mundane", "item.minecraft.tipped_arrow.effect.mundane"),
    NIGHT_VISION(PotionType.NIGHT_VISION, "item.minecraft.potion.effect.night_vision", "item.minecraft.splash_potion.effect.night_vision", "item.minecraft.lingering_potion.effect.night_vision", "item.minecraft.tipped_arrow.effect.night_vision"),
    POISON(PotionType.POISON, "item.minecraft.potion.effect.poison", "item.minecraft.splash_potion.effect.poison", "item.minecraft.lingering_potion.effect.poison", "item.minecraft.tipped_arrow.effect.poison"),
    REGENERATION(PotionType.REGEN, "item.minecraft.potion.effect.regeneration", "item.minecraft.splash_potion.effect.regeneration", "item.minecraft.lingering_potion.effect.regeneration", "item.minecraft.tipped_arrow.effect.regeneration"),
    SLOW(PotionType.SLOWNESS, "item.minecraft.potion.effect.slowness", "item.minecraft.splash_potion.effect.slowness", "item.minecraft.lingering_potion.effect.slowness", "item.minecraft.tipped_arrow.effect.slowness"),
    SLOW_FALLING(PotionType.SLOW_FALLING, "item.minecraft.potion.effect.slow_falling", "item.minecraft.splash_potion.effect.slow_falling", "item.minecraft.lingering_potion.effect.slow_falling", "item.minecraft.tipped_arrow.effect.slow_falling"),
    SPEED(PotionType.SPEED, "item.minecraft.potion.effect.swiftness", "item.minecraft.splash_potion.effect.swiftness", "item.minecraft.lingering_potion.effect.swiftness", "item.minecraft.tipped_arrow.effect.swiftness"),
    THICK(PotionType.THICK, "item.minecraft.potion.effect.thick", "item.minecraft.splash_potion.effect.thick", "item.minecraft.lingering_potion.effect.thick", "item.minecraft.tipped_arrow.effect.thick"),
    TURTLE_MASTER(PotionType.TURTLE_MASTER, "item.minecraft.potion.effect.turtle_master", "item.minecraft.splash_potion.effect.turtle_master", "item.minecraft.lingering_potion.effect.turtle_master", "item.minecraft.tipped_arrow.effect.turtle_master"),
    UNCRAFTABLE(PotionType.UNCRAFTABLE, "item.minecraft.potion.effect.empty", "item.minecraft.splash_potion.effect.empty", "item.minecraft.lingering_potion.effect.empty", "item.minecraft.tipped_arrow.effect.empty"),
    WATER(PotionType.WATER, "item.minecraft.potion.effect.water", "item.minecraft.splash_potion.effect.water", "item.minecraft.lingering_potion.effect.water", "item.minecraft.tipped_arrow.effect.water"),
    WATER_BREATHING(PotionType.WATER_BREATHING, "item.minecraft.potion.effect.water_breathing", "item.minecraft.splash_potion.effect.water_breathing", "item.minecraft.lingering_potion.effect.water_breathing", "item.minecraft.tipped_arrow.effect.water_breathing"),
    WEAKNESS(PotionType.WEAKNESS, "item.minecraft.potion.effect.weakness", "item.minecraft.splash_potion.effect.weakness", "item.minecraft.lingering_potion.effect.weakness", "item.minecraft.tipped_arrow.effect.weakness");

    private static final Map<PotionType, EnumPotionEffect> lookup = new EnumMap<>(PotionType.class);

    static {
        for (EnumPotionEffect effect : EnumSet.allOf(EnumPotionEffect.class))
            lookup.put(effect.getPotionType(), effect);
    }

    private PotionType potionType;
    private String unlocalizedName;
    private String unlocalizedSplashName;
    private String unlocalizedLingeringName;
    private String unlocalizedArrowName;

    /**
     * Create an index of potion effects.
     */
    EnumPotionEffect(PotionType potionType, String unlocalizedName, String unlocalizedSplashName, String unlocalizedLingeringName, String unlocalizedArrowName) {
        this.potionType = potionType;
        this.unlocalizedName = unlocalizedName;
        this.unlocalizedSplashName = unlocalizedSplashName;
        this.unlocalizedLingeringName = unlocalizedLingeringName;
        this.unlocalizedArrowName = unlocalizedArrowName;
    }

    /**
     * @param effectType The effect type.
     * @return The index of a potion based on effect.
     */
    public static EnumPotionEffect get(PotionType effectType) {
        return lookup.get(effectType);
    }

    /**
     * @param potion The potion to be processed.
     * @return the unlocalized name of the potion.
     */
    public static String getUnlocalizedName(ItemStack potion) {
        PotionMeta meta = (PotionMeta) potion.getItemMeta();
        PotionType type = meta.getBasePotionData().getType();
        EnumPotionEffect effect = get(type);
        return effect != null ? effect.unlocalizedName : type.name();
    }

    /**
     * @param potion The potion to be processed.
     * @return the unlocalized name of the potion.
     */
    public static String getUnlocalizedSplashName(ItemStack potion) {
        PotionMeta meta = (PotionMeta) potion.getItemMeta();
        PotionType type = meta.getBasePotionData().getType();
        EnumPotionEffect effect = get(type);
        return effect != null ? effect.unlocalizedSplashName : "SPLASH_" + type.name();
    }

    /**
     * @param potion The potion to be processed.
     * @return the unlocalized name of the potion.
     */
    public static String getUnlocalizedLingeringName(ItemStack potion) {
        PotionMeta meta = (PotionMeta) potion.getItemMeta();
        PotionType type = meta.getBasePotionData().getType();
        EnumPotionEffect effect = get(type);
        return effect != null ? effect.unlocalizedLingeringName : "LINGERING_" + type.name();
    }

    /**
     * @param arrow The tipped arrow to be processed.
     * @return the unlocalized name of the arrow.
     */
    public static String getUnlocalizedArrowName(ItemStack arrow) {
        PotionMeta meta = (PotionMeta) arrow.getItemMeta();
        PotionType type = meta.getBasePotionData().getType();
        EnumPotionEffect effect = get(type);
        return effect != null ? effect.unlocalizedArrowName : "TIPPED_ARROW_" + type.name();
    }

    /**
     * @param itemStack The potion.
     * @param locale    The language of the name.
     * @return The localized name of an potion.
     */
    public static String getLocalizedName(ItemStack itemStack, String locale) {
        if (itemStack.getType() == Material.SPLASH_POTION)
            return LanguageHelper.translateToLocal(getUnlocalizedSplashName(itemStack), locale);
        else if (itemStack.getType() == Material.LINGERING_POTION)
            return LanguageHelper.translateToLocal(getUnlocalizedLingeringName(itemStack), locale);
        else if (itemStack.getType() == Material.TIPPED_ARROW)
            return LanguageHelper.translateToLocal(getUnlocalizedArrowName(itemStack), locale);
        else
            return LanguageHelper.translateToLocal(getUnlocalizedName(itemStack), locale);
    }

    /**
     * @return The type of the potion
     */
    public PotionType getPotionType() {
        return potionType;
    }

    /**
     * @return The unlocalized name of the potion
     */
    public String getUnlocalizedName() {
        return unlocalizedName;
    }

    /**
     * @return The unlocalized name of the splash potion
     */
    public String getUnlocalizedSplashName() {
        return unlocalizedSplashName;
    }

    /**
     * @return The unlocalized name of the lingering potion
     */
    public String getUnlocalizedLingeringName() {
        return unlocalizedLingeringName;
    }

    /**
     * @return The unlocalized name of the tipped arrow
     */
    public String getUnlocalizedArrowName() {
        return unlocalizedArrowName;
    }
}