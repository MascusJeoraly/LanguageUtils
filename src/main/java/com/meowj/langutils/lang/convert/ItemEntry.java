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
import org.bukkit.inventory.ItemStack;

/**
 * Created by Meow J on 6/20/2015.
 * <p>
 * Used for search
 *
 * @author Meow J
 */
public class ItemEntry {
    private Material material;
    private int metadata;
    private static ItemEntry inst = new ItemEntry();

    private ItemEntry() {
    }

    public ItemEntry(Material material, int meta) {
        this.material = material;
        this.metadata = meta;
    }

    public ItemEntry(Material material) {
        this(material, 0);
    }

    /**
     * Create an {@link ItemEntry} with {@link ItemStack}
     *
     * @param itemStack The ItemStack that is based on.
     */
    public ItemEntry(ItemStack itemStack) {
        this.material = itemStack.getType();
        this.metadata = itemStack.getDurability();
    }

    /**
     * Fast create an {@link ItemEntry} instance with {@link ItemStack}
     *
     * @param itemStack The ItemStack that is based on.
     * @return ItemEntry
     */
    public static ItemEntry from(ItemStack itemStack) {
        try {
            ItemEntry result = (ItemEntry) inst.clone();
            result.material = itemStack.getType();
            result.metadata = itemStack.getDurability();
            return result;
        } catch (CloneNotSupportedException e) {
            return new ItemEntry(itemStack);
        }
    }

    /**
     * Fast create an {@link ItemEntry}
     *
     * @param material The bukkit material
     * @param meta     The data value
     * @return ItemEntry
     */
    public static ItemEntry from(Material material, int meta) {
        try {
            ItemEntry result = (ItemEntry) inst.clone();
            result.material = material;
            result.metadata = meta;
            return result;
        } catch (CloneNotSupportedException e) {
            return new ItemEntry(material, meta);
        }
    }

    /**
     * Fast create an {@link ItemEntry}
     *
     * @param material The bukkit material
     * @return ItemEntry
     */
    public static ItemEntry from(Material material) {
        return ItemEntry.from(material, 0);
    }

    /**
     * @return The {@link Material} of the item.
     */
    public Material getMaterial() {
        return material;
    }

    /**
     * @return The metadata(damage value,durability) of the item.
     */
    public int getMetadata() {
        return metadata;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ItemEntry)) return false;

        ItemEntry itemEntry = (ItemEntry) o;

        return metadata == itemEntry.metadata && material == itemEntry.material;
    }

    @Override
    public int hashCode() {
        int result = material.hashCode();
        result = 31 * result + metadata;
        return result;
    }

    @Override
    public String toString() {
        return this.material.toString() + " " + this.metadata;
    }
}
