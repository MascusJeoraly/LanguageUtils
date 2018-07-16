/*
 * Copyright (c) 2015 Hexosse
 *
 * This project is Open Source and distributed under The MIT License (MIT)
 * (http://opensource.org/licenses/MIT)
 *
 * You should have received a copy of the The MIT License along with
 * this project.   If not, see <http://opensource.org/licenses/MIT>.
 */

package com.meowj.langutils.lang.convert;

import org.bukkit.enchantments.Enchantment;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 * This file is part of LanguageUtils
 * <p>
 * A list of enchantments.
 *
 * @author <b>hexosse</b> (<a href="https://github.com/hexosse">hexosse on GitHub</a>).
 */
public enum EnumEnchantment {

    ARROW_DAMAGE(Enchantment.ARROW_DAMAGE, "enchantment.minecraft.power"),
    ARROW_FIRE(Enchantment.ARROW_FIRE, "enchantment.minecraft.flame"),
    ARROW_INFINITE(Enchantment.ARROW_INFINITE, "enchantment.minecraft.infinity"),
    ARROW_KNOCKBACK(Enchantment.ARROW_KNOCKBACK, "enchantment.minecraft.knockback"),
    BINDING_CURSE(Enchantment.BINDING_CURSE, "enchantment.minecraft.binding_curse"),
    CHANNELING(Enchantment.CHANNELING, "enchantment.minecraft.channeling"),
    DAMAGE_ALL(Enchantment.DAMAGE_ALL, "enchantment.minecraft.sharpness"),
    DAMAGE_ARTHROPODS(Enchantment.DAMAGE_ARTHROPODS, "enchantment.minecraft.bane_of_arthropods"),
    DAMAGE_UNDEAD(Enchantment.DAMAGE_UNDEAD, "enchantment.minecraft.smite"),
    DEPTH_STRIDER(Enchantment.DEPTH_STRIDER, "enchantment.minecraft.depth_strider"),
    DIG_SPEED(Enchantment.DIG_SPEED, "enchantment.minecraft.efficiency"),
    DURABILITY(Enchantment.DURABILITY, "enchantment.minecraft.unbreaking"),
    FIRE_ASPECT(Enchantment.FIRE_ASPECT, "enchantment.minecraft.fire_aspect"),
    FROST_WALKER(Enchantment.FROST_WALKER, "enchantment.minecraft.frost_walker"),
    IMPALING(Enchantment.IMPALING, "enchantment.minecraft.impaling"),
    KNOCKBACK(Enchantment.KNOCKBACK, "enchantment.minecraft.knockback"),
    LOOT_BONUS_BLOCKS(Enchantment.LOOT_BONUS_BLOCKS, "enchantment.minecraft.fortune"),
    LOOT_BONUS_MOBS(Enchantment.LOOT_BONUS_MOBS, "enchantment.minecraft.looting"),
    LOYALTY(Enchantment.LOYALTY, "enchantment.minecraft.loyalty"),
    LUCK(Enchantment.LUCK, "enchantment.minecraft.luck_of_the_sea"),
    LURE(Enchantment.LURE, "enchantment.minecraft.lure"),
    MENDING(Enchantment.MENDING, "enchantment.minecraft.mending"),
    OXYGEN(Enchantment.OXYGEN, "enchantment.minecraft.respiration"),
    PROTECTION_ENVIRONMENTAL(Enchantment.PROTECTION_ENVIRONMENTAL, "enchantment.minecraft.protection"),
    PROTECTION_EXPLOSIONS(Enchantment.PROTECTION_EXPLOSIONS, "enchantment.minecraft.blast_protection"),
    PROTECTION_FALL(Enchantment.PROTECTION_FALL, "enchantment.minecraft.feather_falling"),
    PROTECTION_FIRE(Enchantment.PROTECTION_FIRE, "enchantment.minecraft.fire_protection"),
    PROTECTION_PROJECTILE(Enchantment.PROTECTION_PROJECTILE, "enchantment.minecraft.projectile_protection"),
    RIPTIDE(Enchantment.RIPTIDE, "enchantment.minecraft.riptide"),
    SILK_TOUCH(Enchantment.SILK_TOUCH, "enchantment.minecraft.sweeping"),
    SWEEPING_EDGE(Enchantment.SWEEPING_EDGE, "enchantment.minecraft.sweeping"),
    THORNS(Enchantment.THORNS, "enchantment.minecraft.thorns"),
    VANISHING_CURSE(Enchantment.VANISHING_CURSE, "enchantment.minecraft.vanishing_curse"),
    WATER_WORKER(Enchantment.WATER_WORKER, "enchantment.minecraft.aqua_affinity");

    private static final Map<Enchantment, EnumEnchantment> lookup = new HashMap<>();

    static {
        for (EnumEnchantment enchantment : EnumSet.allOf(EnumEnchantment.class))
            lookup.put(enchantment.enchantment, enchantment);
    }

    private Enchantment enchantment;
    private String unlocalizedName;

    /**
     * Create an index of enchantments.
     */
    EnumEnchantment(Enchantment enchantment, String unlocalizedName) {
        this.enchantment = enchantment;
        this.unlocalizedName = unlocalizedName;
    }

    /**
     * Get the index of an enchantment based on {@link EnumEnchantment}.
     *
     * @param enchantment The enchantment.
     * @return The index of the item.
     */
    public static EnumEnchantment get(Enchantment enchantment) {
        return lookup.get(enchantment);
    }

    /**
     * @return The {@link Enchantment} of the enchantment.
     */
    public Enchantment getEnchantment() {
        return enchantment;
    }

    /**
     * @return The unlocalized name of the enchantment.
     */
    public String getUnlocalizedName() {
        return unlocalizedName;
    }
}
