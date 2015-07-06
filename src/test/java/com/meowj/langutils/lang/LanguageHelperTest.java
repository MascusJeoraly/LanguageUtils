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

import com.meowj.langutils.lang.convert.EnumLang;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.modules.junit4.PowerMockRunner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(PowerMockRunner.class)
public class LanguageHelperTest {

    @Test
    public void testItemDisplayName() throws Exception {
        initLangs(); // Only load en_US and zh_CN(Encoding test)

        ItemStack test = mock(ItemStack.class);

        when(test.hasItemMeta()).thenReturn(false);
        when(test.getType()).thenReturn(Material.STONE);

        assertEquals(LanguageHelper.getItemDisplayName(test, "en_US"), "Stone");

        ItemStack damageTest = mock(ItemStack.class);

        when(damageTest.hasItemMeta()).thenReturn(false);
        when(damageTest.getType()).thenReturn(Material.STONE);
        when(damageTest.getDurability()).thenReturn((short) 2);

        assertEquals(LanguageHelper.getItemDisplayName(damageTest, "en_US"), "Polished Granite");

        ItemStack UTF8Test = mock(ItemStack.class);

        when(UTF8Test.hasItemMeta()).thenReturn(false);
        when(UTF8Test.getType()).thenReturn(Material.STONE);
        when(UTF8Test.getDurability()).thenReturn((short) 1);

        assertEquals(LanguageHelper.getItemDisplayName(UTF8Test, "zh_CN"), "\u82b1\u5c97\u5ca9");


        //Potion Test
        ItemStack waterBottle = mock(ItemStack.class);
        when(waterBottle.getType()).thenReturn(Material.POTION);
        when(waterBottle.getDurability()).thenReturn((short) 0);

        assertEquals(LanguageHelper.getItemDisplayName(waterBottle, "en_US"), "Water Bottle");

        ItemStack awkwardPotion = mock(ItemStack.class);
        when(awkwardPotion.getType()).thenReturn(Material.POTION);
        when(awkwardPotion.getDurability()).thenReturn((short) 16);

        assertEquals(LanguageHelper.getItemDisplayName(awkwardPotion, "en_US"), "Awkward Potion");

        ItemStack regenPotion = mock(ItemStack.class);
        when(regenPotion.getType()).thenReturn(Material.POTION);
        when(regenPotion.getDurability()).thenReturn((short) 8193);

        assertEquals(LanguageHelper.getItemDisplayName(regenPotion, "en_US"), "Potion of Regeneration");

        ItemStack splashRegenPotion = mock(ItemStack.class);
        when(splashRegenPotion.getType()).thenReturn(Material.POTION);
        when(splashRegenPotion.getDurability()).thenReturn((short) 16385);

        assertEquals(LanguageHelper.getItemDisplayName(splashRegenPotion, "en_US"), "Splash Potion of Regeneration");
    }

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

    private void initLangs() throws IOException {
        String temp;
        String[] tempStringArr;
        for (EnumLang enumLang : new EnumLang[]{EnumLang.EN_US, EnumLang.ZH_CN}) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("/lang/" + enumLang.getLocale() + ".lang"), Charset.forName("UTF-8")));
            try {
                temp = reader.readLine();
                while (temp != null) {
                    if (temp.contains("=")) {
                        tempStringArr = temp.split("=");
                        enumLang.getMap().put(tempStringArr[0], tempStringArr.length > 1 ? tempStringArr[1] : "");
                    }
                    temp = reader.readLine();
                }
            } finally {
                reader.close();
            }
        }
    }
}