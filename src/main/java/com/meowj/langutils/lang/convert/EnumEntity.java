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
import org.bukkit.Bukkit;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ItemStack;

import java.lang.reflect.InvocationTargetException;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Meow J on 7/7/2015.
 * <p>
 * A list of {@link org.bukkit.entity.EntityType}
 *
 * @author Meow J
 */
public enum EnumEntity {

    AREA_EFFECT_CLOUD(EntityType.AREA_EFFECT_CLOUD, "entity.minecraft.area_effect_cloud"),
    ARMOR_STAND(EntityType.ARMOR_STAND, "entity.minecraft.armor_stand"),
    ARROW(EntityType.ARROW, "entity.minecraft.arrow"),
    BAT(EntityType.BAT, "entity.minecraft.bat"),
    BLAZE(EntityType.BLAZE, "entity.minecraft.blaze"),
    BOAT(EntityType.BOAT, "entity.minecraft.boat"),
    //CAT(EntityType. , "entity.minecraft.cat"), //WHAT
    CAVE_SPIDER(EntityType.CAVE_SPIDER, "entity.minecraft.cave_spider"),
    MINECART_WITH_CHEST(EntityType.MINECART_CHEST, "entity.minecraft.chest_minecart"),
    CHICKEN(EntityType.CHICKEN, "entity.minecraft.chicken"),
    MINECART_WITH_COMMAND_BLOCK(EntityType.MINECART_COMMAND, "entity.minecraft.command_block_minecart"),
    COD(EntityType.COD, "entity.minecraft.cod"),
    COW(EntityType.COW, "entity.minecraft.cow"),
    CREEPER(EntityType.CREEPER, "entity.minecraft.creeper"),
    DOLPHIN(EntityType.DOLPHIN, "entity.minecraft.dolphin"),
    DONKEY(EntityType.DONKEY, "entity.minecraft.donkey"),
    DROWNED(EntityType.DROWNED, "entity.minecraft.drowned"),
    DRAGON_FIREBALL(EntityType.DRAGON_FIREBALL, "entity.minecraft.dragon_fireball"),
    //THROWN_EGG(EntityType. , "entity.minecraft.egg"),
    ELDER_GUARDIAN(EntityType.ELDER_GUARDIAN, "entity.minecraft.elder_guardian"),
    END_CRYSTAL(EntityType.ENDER_CRYSTAL, "entity.minecraft.end_crystal"),
    ENDER_DRAGON(EntityType.ENDER_DRAGON, "entity.minecraft.ender_dragon"),
    //THROWN_ENDER_PEARL(EntityType. , "entity.minecraft.ender_pearl"),
    ENDERMAN(EntityType.ENDERMAN, "entity.minecraft.enderman"),
    ENDERMITE(EntityType.ENDERMITE, "entity.minecraft.endermite"),
    EVOKER_FANGS(EntityType.EVOKER_FANGS, "entity.minecraft.evoker_fangs"),
    EVOKER(EntityType.EVOKER, "entity.minecraft.evoker"),
    EYE_OF_ENDER(EntityType.ENDER_SIGNAL, "entity.minecraft.eye_of_ender"),
    FALLING_BLOCK(EntityType.FALLING_BLOCK, "entity.minecraft.falling_block"),
    FIREBALL(EntityType.FIREBALL, "entity.minecraft.fireball"),
    FIREWORK_ROCKET(EntityType.FIREWORK, "entity.minecraft.firework_rocket"),
    FISHING_BOBBER(EntityType.FISHING_HOOK, "entity.minecraft.fishing_bobber"),
    MINECART_WITH_FURNACE(EntityType.MINECART_FURNACE, "entity.minecraft.furnace_minecart"),
    GHAST(EntityType.GHAST, "entity.minecraft.ghast"),
    GIANT(EntityType.GIANT, "entity.minecraft.giant"),
    GUARDIAN(EntityType.GUARDIAN, "entity.minecraft.guardian"),
    MINECART_WITH_HOPPER(EntityType.MINECART_HOPPER, "entity.minecraft.hopper_minecart"),
    HORSE(EntityType.HORSE, "entity.minecraft.horse"),
    HUSK(EntityType.HUSK, "entity.minecraft.husk"),
    ILLUSIONER(EntityType.ILLUSIONER, "entity.minecraft.illusioner"),
    ITEM(EntityType.DROPPED_ITEM, "entity.minecraft.item"),
    ITEM_FRAME(EntityType.ITEM_FRAME, "entity.minecraft.item_frame"),
    THE_KILLER_BUNNY(EntityType.RABBIT, "entity.minecraft.killer_bunny"),
    LEASH_KNOT(EntityType.LEASH_HITCH, "entity.minecraft.leash_knot"),
    LIGHTNING_BOLT(EntityType.LIGHTNING, "entity.minecraft.lightning_bolt"),
    LLAMA(EntityType.LLAMA, "entity.minecraft.llama"),
    LLAMA_SPIT(EntityType.LLAMA_SPIT, "entity.minecraft.llama_spit"),
    MAGMA_CUBE(EntityType.MAGMA_CUBE, "entity.minecraft.magma_cube"),
    MINECART(EntityType.MINECART, "entity.minecraft.minecart"),
    MOOSHROOM(EntityType.MUSHROOM_COW, "entity.minecraft.mooshroom"),
    MULE(EntityType.MULE, "entity.minecraft.mule"),
    OCELOT(EntityType.OCELOT, "entity.minecraft.ocelot"),
    PAINTING(EntityType.PAINTING, "entity.minecraft.painting"),
    PARROT(EntityType.PARROT, "entity.minecraft.parrot"),
    PHANTOM(EntityType.PHANTOM, "entity.minecraft.phantom"),
    PIG(EntityType.PIG, "entity.minecraft.pig"),
    PLAYER(EntityType.PLAYER, "entity.minecraft.player"),
    POLAR_BEAR(EntityType.POLAR_BEAR, "entity.minecraft.polar_bear"),
    POTION(EntityType.SPLASH_POTION, "entity.minecraft.potion"),
    PUFFERFISH(EntityType.PUFFERFISH, "entity.minecraft.pufferfish"),
    RABBIT(EntityType.RABBIT, "entity.minecraft.rabbit"),
    SALMON(EntityType.SALMON, "entity.minecraft.salmon"),
    SHEEP(EntityType.SHEEP, "entity.minecraft.sheep"),
    SHULKER(EntityType.SHULKER, "entity.minecraft.shulker"),
    SHULKER_BULLET(EntityType.SHULKER_BULLET, "entity.minecraft.shulker_bullet"),
    SILVERFISH(EntityType.SILVERFISH, "entity.minecraft.silverfish"),
    SKELETON(EntityType.SKELETON, "entity.minecraft.skeleton"),
    SKELETON_HORSE(EntityType.SKELETON_HORSE, "entity.minecraft.skeleton_horse"),
    SLIME(EntityType.SLIME, "entity.minecraft.slime"),
    SMALL_FIREBALL(EntityType.SMALL_FIREBALL, "entity.minecraft.small_fireball"),
    SNOWBALL(EntityType.SNOWBALL, "entity.minecraft.snowball"),
    SNOW_GOLEM(EntityType.SNOWMAN, "entity.minecraft.snow_golem"),
    MINECART_WITH_SPAWNER(EntityType.MINECART_MOB_SPAWNER, "entity.minecraft.spawner_minecart"),
    SPECTRAL_ARROW(EntityType.SPECTRAL_ARROW, "entity.minecraft.spectral_arrow"),
    SPIDER(EntityType.SPIDER, "entity.minecraft.spider"),
    SQUID(EntityType.SQUID, "entity.minecraft.squid"),
    STRAY(EntityType.STRAY, "entity.minecraft.stray"),
    PRIMED_TNT(EntityType.PRIMED_TNT, "entity.minecraft.tnt"),
    MINECART_WITH_TNT(EntityType.MINECART_TNT, "entity.minecraft.tnt_minecart"),
    TRIDENT(EntityType.TRIDENT, "entity.minecraft.trident"),
    TROPICAL_FISH(EntityType.TROPICAL_FISH, "entity.minecraft.tropical_fish"),
    TURTLE(EntityType.TURTLE, "entity.minecraft.turtle"),
    VEX(EntityType.VEX, "entity.minecraft.vex"),
    VILLAGER(EntityType.VILLAGER, "entity.minecraft.villager"),
    IRON_GOLEM(EntityType.IRON_GOLEM, "entity.minecraft.iron_golem"),
    VINDICATOR(EntityType.VINDICATOR, "entity.minecraft.vindicator"),
    WITCH(EntityType.WITCH, "entity.minecraft.witch"),
    WITHER(EntityType.WITHER, "entity.minecraft.wither"),
    WITHER_SKELETON(EntityType.WITHER_SKELETON, "entity.minecraft.wither_skeleton"),
    WITHER_SKULL(EntityType.WITHER_SKULL, "entity.minecraft.wither_skull"),
    WOLF(EntityType.WOLF, "entity.minecraft.wolf"),
    THROWN_BOTTLE(EntityType.THROWN_EXP_BOTTLE, "entity.minecraft.experience_bottle"),
    EXPERIENCE_ORB(EntityType.EXPERIENCE_ORB, "entity.minecraft.experience_orb"),
    ZOMBIE(EntityType.ZOMBIE, "entity.minecraft.zombie"),
    ZOMBIE_HORSE(EntityType.ZOMBIE_HORSE, "entity.minecraft.zombie_horse"),
    ZOMBIE_PIGMAN(EntityType.PIG_ZOMBIE, "entity.minecraft.zombie_pigman"),
    ZOMBIE_VILLAGER(EntityType.ZOMBIE_VILLAGER, "entity.minecraft.zombie_villager");
    // Some entity subtypes are not included

    private static final Map<EntityType, EnumEntity> lookup = new HashMap<EntityType, EnumEntity>();

    static {
        for (EnumEntity entity : EnumSet.allOf(EnumEntity.class))
            lookup.put(entity.getType(), entity);
    }

    private EntityType type;
    private String unlocalizedName;

    EnumEntity(EntityType type, String unlocalizedName) {
        this.type = type;
        this.unlocalizedName = unlocalizedName;
    }

    /**
     * @param entityType The Entity type.
     * @return The index of an entity based on entity type
     */
    public static EnumEntity get(EntityType entityType) {
        return lookup.get(entityType);
    }

    public String getUnlocalizedName() {
        return unlocalizedName;
    }

    public EntityType getType() {
        return type;
    }

}
