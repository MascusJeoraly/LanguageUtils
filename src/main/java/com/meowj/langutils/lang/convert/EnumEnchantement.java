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
 * <p/>
 * A list of enchantements.
 *
 * @author <b>hexosse</b> (<a href="https://github.com/hexosse">hexosse on GitHub</a>).
 */
public enum EnumEnchantement
{
    PROTECTION_ENVIRONMENTAL(Enchantment.PROTECTION_ENVIRONMENTAL, "enchantment.protect.all"),    // Protection
    PROTECTION_FIRE(Enchantment.PROTECTION_FIRE, "enchantment.protect.fire"),                     // Protection contre le feu
    PROTECTION_FALL(Enchantment.PROTECTION_FALL, "enchantment.protect.fall"),                     // Chute amortie
    PROTECTION_EXPLOSIONS(Enchantment.PROTECTION_EXPLOSIONS, "enchantment.protect.explosion"),    // Protection contre les explosions
    PROTECTION_PROJECTILE(Enchantment.PROTECTION_PROJECTILE, "enchantment.protect.projectile"),   // Protection contre les projectiles
    OXYGEN(Enchantment.OXYGEN, "enchantment.oxygen"),                                             // Apnée
    WATER_WORKER(Enchantment.WATER_WORKER, "enchantment.waterWorker"),                            // Affinité aquatique
    THORNS(Enchantment.THORNS, "enchantment.thorns"),                                             // Épines
    DEPTH_STRIDER(Enchantment.DEPTH_STRIDER, "enchantment.waterWalker"),                          // Agilité aquatique
    DAMAGE_ALL(Enchantment.DAMAGE_ALL, "enchantment.damage.all"),                                 // Tranchant
    DAMAGE_UNDEAD(Enchantment.DAMAGE_UNDEAD, "enchantment.damage.undead"),                        // Châtiment
    DAMAGE_ARTHROPODS(Enchantment.DAMAGE_ARTHROPODS, "enchantment.damage.arthropods"),            // Fléau des arthropodes
    KNOCKBACK(Enchantment.KNOCKBACK, "enchantment.knockback"),                                    // Recul
    FIRE_ASPECT(Enchantment.FIRE_ASPECT, "enchantment.fire"),                                     // Aura de feu
    LOOT_BONUS_MOBS(Enchantment.LOOT_BONUS_MOBS, "enchantment.lootBonusDigger"),                  // Fortune
    DIG_SPEED(Enchantment.DIG_SPEED, "enchantment.digging"),                                      // Efficacité
    SILK_TOUCH(Enchantment.SILK_TOUCH, "enchantment.untouching"),                                 // Toucher de soie
    DURABILITY(Enchantment.DURABILITY, "enchantment.durability"),                                 // Solidité
    LOOT_BONUS_BLOCKS(Enchantment.LOOT_BONUS_BLOCKS, "enchantment.lootBonus"),                    // Butin
    ARROW_DAMAGE(Enchantment.ARROW_DAMAGE, "enchantment.arrowDamage"),                            // Puissance
    ARROW_KNOCKBACK(Enchantment.ARROW_KNOCKBACK, "enchantment.arrowKnockback"),                   // Frappe
    ARROW_FIRE(Enchantment.ARROW_FIRE, "enchantment.arrowFire"),                                  // Flamme
    ARROW_INFINITE(Enchantment.ARROW_INFINITE, "enchantment.arrowInfinite"),                      // Infinité
    LUCK(Enchantment.LUCK, "enchantment.lootBonusFishing"),                                       // Chance de la mer
    LURE(Enchantment.LURE, "enchantment.fishingSpeed");                                           // Appât



    /**
     * @return The {@link Enchantment} of the enchantement.
     */
    public Enchantment getEnchantement() {
        return enchantement;
    }

    /**
     * @return The unlocalized name of the enchantement.
     */
    public String getUnlocalizedName() {
        return unlocalizedName;
    }


    /**
     * Create an index of enchantements.
     */
    EnumEnchantement(Enchantment enchantement, String unlocalizedName) {
        this(enchantement,0,unlocalizedName);
    }

    /**
     * Create an index of enchantements.
     */
    EnumEnchantement(Enchantment enchantement, int level, String unlocalizedName) {
        this.enchantement = enchantement;
        this.unlocalizedName = unlocalizedName;
    }


    private static final Map<Enchantment, EnumEnchantement> lookup = new HashMap<Enchantment, EnumEnchantement>();

    static {
        for (EnumEnchantement enchantement : EnumSet.allOf(EnumEnchantement.class))
            lookup.put(enchantement.enchantement, enchantement);
    }

    /**
     * Get the index of an enchantement based on {@Link EnumEnchantement}.
     *
     * @param enchantement The enchantement.
     * @return The index of the item.
     */
    public static EnumEnchantement get(Enchantment enchantement) {
        return lookup.containsKey(enchantement) ? lookup.get(enchantement) : null;
    }


    private Enchantment enchantement;
    private String unlocalizedName;
}
