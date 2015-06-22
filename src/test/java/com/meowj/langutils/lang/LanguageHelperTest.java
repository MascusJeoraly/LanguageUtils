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

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(PowerMockRunner.class)
public class LanguageHelperTest {

    @Test
    public void testItemMetaDisplayName() throws Exception {
        ItemStack metaTest = mock(ItemStack.class);
        ItemMeta meta = mock(ItemMeta.class);

        when(meta.hasDisplayName()).thenReturn(true);
        when(meta.getDisplayName()).thenReturn("test Name");
        when(metaTest.hasItemMeta()).thenReturn(true);
        when(metaTest.getType()).thenReturn(Material.STONE);
        when(metaTest.getItemMeta()).thenReturn(meta);

        assertEquals(LanguageHelper.getItemDisplayName(metaTest, "en_US"), "test Name");
    }

    @Test
    public void testGetItemUnlocalizedName() throws Exception {
        ItemStack unlocalizedTest = mock(ItemStack.class);

        when(unlocalizedTest.getType()).thenReturn(Material.STONE);
        when(unlocalizedTest.getDurability()).thenReturn((short) 0);
        assertEquals(LanguageHelper.getItemUnlocalizedName(unlocalizedTest), "tile.stone.stone.name");

        ItemStack unlocalizedMetaTest = mock(ItemStack.class);

        when(unlocalizedMetaTest.getType()).thenReturn(Material.STONE);
        when(unlocalizedMetaTest.getDurability()).thenReturn((short) 1);
        assertEquals(LanguageHelper.getItemUnlocalizedName(unlocalizedMetaTest), "tile.stone.granite.name");

    }
}