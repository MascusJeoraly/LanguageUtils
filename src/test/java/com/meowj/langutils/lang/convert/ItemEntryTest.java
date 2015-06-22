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
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class ItemEntryTest {

    @Test
    public void testEquals() throws Exception {
        //Same Material
        ItemEntry equalEntry1 = new ItemEntry(Material.STONE);
        ItemEntry equalEntry2 = new ItemEntry(Material.STONE);

        assertEquals(equalEntry1, equalEntry2);
        assertEquals(equalEntry1.hashCode(), equalEntry2.hashCode());

        //Same Material + metadata
        ItemEntry equalEntry3 = new ItemEntry(Material.STONE, 2);
        ItemEntry equalEntry4 = new ItemEntry(Material.STONE, 2);

        assertEquals(equalEntry3, equalEntry4);
        assertEquals(equalEntry3.hashCode(), equalEntry4.hashCode());

        //Different Material
        ItemEntry diffEntry1 = new ItemEntry(Material.STONE);
        ItemEntry diffEntry2 = new ItemEntry(Material.ANVIL);

        assertNotEquals(diffEntry1, diffEntry2);
        assertNotEquals(diffEntry1.hashCode(), diffEntry2.hashCode());

        //Different metadata
        ItemEntry diffEntry3 = new ItemEntry(Material.STONE, 4);
        ItemEntry diffEntry4 = new ItemEntry(Material.STONE, 7);

        assertNotEquals(diffEntry3, diffEntry4);
        assertNotEquals(diffEntry3.hashCode(), diffEntry4.hashCode());

        //Different Material + metadata
        ItemEntry diffEntry5 = new ItemEntry(Material.STONE, 4);
        ItemEntry diffEntry6 = new ItemEntry(Material.SAND, 2);

        assertNotEquals(diffEntry5, diffEntry6);
        assertNotEquals(diffEntry5.hashCode(), diffEntry6.hashCode());


        //HashMap Test
        Map<ItemEntry, EnumItem> testMap = new HashMap<ItemEntry, EnumItem>();

        testMap.put(equalEntry1, EnumItem.STONE);
        assertTrue(testMap.containsKey(equalEntry1));

        testMap.put(equalEntry3, EnumItem.POLISHED_GRANITE);
        assertTrue(testMap.containsKey(equalEntry4));

        assertFalse(testMap.containsKey(diffEntry2));
        assertFalse(testMap.containsKey(diffEntry3));
        assertFalse(testMap.containsKey(diffEntry6));
    }
}