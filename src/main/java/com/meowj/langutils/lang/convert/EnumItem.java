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
    //Stone
    STONE(Material.STONE, "tile.stone.stone.name"),
    GRANITE(Material.STONE, 1, "tile.stone.granite.name"),
    POLISHED_GRANITE(Material.STONE, 2, "tile.stone.graniteSmooth.name"),
    DIORITE(Material.STONE, 3, "tile.stone.diorite.name"),
    POLISHED_DIORITE(Material.STONE, 4, "tile.stone.dioriteSmooth.name"),
    ANDESITE(Material.STONE, 5, "tile.stone.andesite.name"),
    POLISHED_ANDESITE(Material.STONE, 6, "tile.stone.andesiteSmooth.name");


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
