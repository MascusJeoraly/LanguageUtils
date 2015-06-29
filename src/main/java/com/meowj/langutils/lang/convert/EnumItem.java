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


import org.bukkit.Material;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Meow J on 6/20/2015.
 * <p/>
 * Material -> Unlocalized Name
 *
 * @author Meow J
 */
public enum EnumItem {

    AIR(Material.AIR, "Air"),
    STONE(Material.STONE, "tile.stone.stone.name"),
    GRANITE(Material.STONE, 1, "tile.stone.granite.name"),
    POLISHED_GRANITE(Material.STONE, 2, "tile.stone.graniteSmooth.name"),
    DIORITE(Material.STONE, 3, "tile.stone.diorite.name"),
    POLISHED_DIORITE(Material.STONE, 4, "tile.stone.dioriteSmooth.name"),
    ANDESITE(Material.STONE, 5, "tile.stone.andesite.name"),
    POLISHED_ANDESITE(Material.STONE, 6, "tile.stone.andesiteSmooth.name"),
    BARRIER(Material.BARRIER, "tile.barrier.name"),
    HAY_BALE(Material.HAY_BLOCK, "tile.hayBlock.name"),
    GRASS_BLOCK(Material.GRASS, "tile.grass.name"),
    DIRT(Material.DIRT, 0, "tile.dirt.default.name"),
    COARSE_DIRT(Material.DIRT, 1, "tile.dirt.coarse.name"),
    PODZOL(Material.DIRT, 2, "tile.dirt.podzol.name"),
    COBBLESTONE(Material.COBBLESTONE, "tile.stonebrick.name"),
    OAK_WOOD_PLANKS(Material.WOOD, "tile.wood.oak.name"),
    SPRUCE_WOOD_PLANKS(Material.WOOD, 1, "tile.wood.spruce.name"),
    BIRCH_WOOD_PLANKS(Material.WOOD, 2, "tile.wood.birch.name"),
    JUNGLE_WOOD_PLANKS(Material.WOOD, 3, "tile.wood.jungle.name"),
    ACACIA_WOOD_PLANKS(Material.WOOD, 4, "tile.wood.acacia.name"),
    DARK_OAK_WOOD_PLANKS(Material.WOOD, 5, "tile.wood.big_oak.name"),
    OAK_SAPLING(Material.SAPLING, "tile.sapling.oak.name"),
    SPRUCE_SAPLING(Material.SAPLING, 1, "tile.sapling.spruce.name"),
    BIRCH_SAPLING(Material.SAPLING, 2, "tile.sapling.birch.name"),
    JUNGLE_SAPLING(Material.SAPLING, 3, "tile.sapling.jungle.name"),
    ACACIA_SAPLING(Material.SAPLING, 4, "tile.sapling.acacia.name"),
    DARK_OAK_SAPLING(Material.SAPLING, 5, "tile.sapling.big_oak.name");


    private Material material;
    private int metadata;
    private String unlocalizedName;

    public String getUnlocalizedName() {
        return unlocalizedName;
    }

    public int getMetadata() {
        return metadata;
    }

    public Material getMaterial() {
        return material;
    }

    EnumItem(Material material, int metadata, String unlocalizedName) {
        this.material = material;
        this.metadata = metadata;
        this.unlocalizedName = unlocalizedName;
    }

    EnumItem(Material material, String unlocalizedName) {
        this(material, 0, unlocalizedName);
    }


    private static final Map<ItemEntry, EnumItem> lookup = new HashMap<ItemEntry, EnumItem>();

    static {
        for (EnumItem item : EnumSet.allOf(EnumItem.class))
            lookup.put(new ItemEntry(item.material, item.getMetadata()), item);
    }

    public static EnumItem get(ItemEntry entry) {
        return lookup.containsKey(entry) ? lookup.get(entry) : null;
    }
}
