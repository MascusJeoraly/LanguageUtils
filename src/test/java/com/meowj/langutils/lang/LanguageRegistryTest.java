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
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Meow J on 8/11/2015.
 *
 * @author Meow J
 */
public class LanguageRegistryTest {


    @BeforeClass
    public static void setup() throws IOException {
        //Init Lang(Only English and Chinese(for UTF-8 Test))
        for (EnumLang enumLang : new EnumLang[]{EnumLang.EN_US, EnumLang.ZH_CN}) {
            EnumLang.readFile(enumLang, new BufferedReader(new InputStreamReader(EnumLang.class.getResourceAsStream("/lang/" + enumLang.getLocale() + ".lang"), Charset.forName("UTF-8"))));
        }

        LanguageRegistry.INSTANCE = new LanguageRegistry();
    }

    @Test
    public void testRegisterEntry() throws Exception {
        ItemStack test = mock(ItemStack.class);

        when(test.hasItemMeta()).thenReturn(false);
        when(test.getType()).thenReturn(Material.CHEST);

        assertEquals("Chest", LanguageHelper.getItemDisplayName(test, "en_us"));
        LanguageRegistry.INSTANCE.registerEntry(EnumLang.EN_US, "tile.chest.name", "Diamond Chest");
        assertEquals("Diamond Chest", LanguageHelper.getItemDisplayName(test, "en_us"));
    }
}