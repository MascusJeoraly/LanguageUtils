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
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.material.SpawnEgg;
import org.junit.BeforeClass;
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

    @BeforeClass
    public static void setup() throws IOException {
        //Init Lang(Only English and Chinese(for UTF-8 Test))
        for (EnumLang enumLang : new EnumLang[]{EnumLang.EN_US, EnumLang.ZH_CN}) {
            EnumLang.readFile(enumLang, new BufferedReader(new InputStreamReader(EnumLang.class.getResourceAsStream("/lang/" + enumLang.getLocale() + ".lang"), Charset.forName("UTF-8"))));
        }
    }

    @Test
    public void testItemDisplayName() throws Exception {
        ItemStack test = mock(ItemStack.class);

        when(test.hasItemMeta()).thenReturn(false);
        when(test.getType()).thenReturn(Material.STONE);

        assertEquals("Stone", LanguageHelper.getItemDisplayName(test, "en_US"));

        ItemStack damageTest = mock(ItemStack.class);

        when(damageTest.hasItemMeta()).thenReturn(false);
        when(damageTest.getType()).thenReturn(Material.STONE);
        when(damageTest.getDurability()).thenReturn((short) 2);

        assertEquals("Polished Granite", LanguageHelper.getItemDisplayName(damageTest, "en_US"));

        ItemStack UTF8Test = mock(ItemStack.class);

        when(UTF8Test.hasItemMeta()).thenReturn(false);
        when(UTF8Test.getType()).thenReturn(Material.STONE);
        when(UTF8Test.getDurability()).thenReturn((short) 1);

        assertEquals("\u82b1\u5c97\u5ca9", LanguageHelper.getItemDisplayName(UTF8Test, "zh_CN"));
    }

    @Test
    public void testPotionDisplayName() throws Exception {
        ItemStack waterBottle = mock(ItemStack.class);
        when(waterBottle.getType()).thenReturn(Material.POTION);
        when(waterBottle.getDurability()).thenReturn((short) 0);

        assertEquals("Water Bottle", LanguageHelper.getItemDisplayName(waterBottle, "en_US"));

        ItemStack awkwardPotion = mock(ItemStack.class);
        when(awkwardPotion.getType()).thenReturn(Material.POTION);
        when(awkwardPotion.getDurability()).thenReturn((short) 16);

        assertEquals("Awkward Potion", LanguageHelper.getItemDisplayName(awkwardPotion, "en_US"));

        ItemStack regenPotion = mock(ItemStack.class);
        when(regenPotion.getType()).thenReturn(Material.POTION);
        when(regenPotion.getDurability()).thenReturn((short) 8193);

        assertEquals("Potion of Regeneration", LanguageHelper.getItemDisplayName(regenPotion, "en_US"));

        ItemStack splashRegenPotion = mock(ItemStack.class);
        when(splashRegenPotion.getType()).thenReturn(Material.POTION);
        when(splashRegenPotion.getDurability()).thenReturn((short) 16385);

        assertEquals("Splash Potion of Regeneration", LanguageHelper.getItemDisplayName(splashRegenPotion, "en_US"));
    }

    @Test
    public void testMonsterEggDisplayName() throws Exception {
        ItemStack creeperEgg = mock(ItemStack.class);
        SpawnEgg egg = mock(SpawnEgg.class);
        when(egg.getSpawnedType()).thenReturn(EntityType.CREEPER);

        when(creeperEgg.getType()).thenReturn(Material.MONSTER_EGG);
        when(creeperEgg.getData()).thenReturn(egg);

        assertEquals("Spawn Creeper", LanguageHelper.getItemDisplayName(creeperEgg, "en_US"));
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

        assertEquals("test Name", LanguageHelper.getItemDisplayName(metaTest, "en_US"));
    }

    @Test
    public void testGetItemUnlocalizedName() throws Exception {
        ItemStack unlocalizedTest = mock(ItemStack.class);

        when(unlocalizedTest.getType()).thenReturn(Material.STONE);
        when(unlocalizedTest.getDurability()).thenReturn((short) 0);
        assertEquals("tile.stone.stone.name", LanguageHelper.getItemUnlocalizedName(unlocalizedTest));

        ItemStack unlocalizedMetaTest = mock(ItemStack.class);

        when(unlocalizedMetaTest.getType()).thenReturn(Material.STONE);
        when(unlocalizedMetaTest.getDurability()).thenReturn((short) 1);
        assertEquals("tile.stone.granite.name", LanguageHelper.getItemUnlocalizedName(unlocalizedMetaTest));
    }

    @Test
    public void testGetEntityUnlocalizedName() {
        Entity entity1 = mock(Entity.class);

        when(entity1.getType()).thenReturn(EntityType.CREEPER);
        assertEquals("entity.Creeper.name", LanguageHelper.getEntityUnlocalizedName(entity1));

        assertEquals("entity.Bat.name", LanguageHelper.getEntityUnlocalizedName(EntityType.BAT));
    }

    @Test
    public void testGetEntityName() throws IOException {
        Entity entity1 = mock(Entity.class);

        when(entity1.getType()).thenReturn(EntityType.CREEPER);
        assertEquals("Creeper", LanguageHelper.getEntityName(entity1, "en_US"));

        assertEquals("Arrow", LanguageHelper.getEntityName(EntityType.ARROW, "en_US"));
    }

    @Test
    public void testGetEntityDisplayName() throws IOException {
        LivingEntity entity1 = mock(LivingEntity.class);

        when(entity1.getType()).thenReturn(EntityType.CREEPER);
        when(entity1.getCustomName()).thenReturn("Ssssssssss");
        assertEquals("Ssssssssss", LanguageHelper.getEntityDisplayName(entity1, "en_US"));

        Entity entity2 = mock(Entity.class);

        when(entity2.getType()).thenReturn(EntityType.BOAT);
        assertEquals("Boat", LanguageHelper.getEntityDisplayName(entity2, "en_US"));
    }

    @Test
    public void testEnchantmentDisplayName() throws Exception {
        assertEquals("enchantment.protect.all", LanguageHelper.getEnchantmentUnlocalizedName(Enchantment.PROTECTION_ENVIRONMENTAL));
        assertEquals("X", LanguageHelper.getEnchantmentLevelName(10, "en_US"));
        assertEquals("Protection", LanguageHelper.getEnchantmentName(Enchantment.PROTECTION_ENVIRONMENTAL, "en_US"));
        assertEquals("Protection IV", LanguageHelper.getEnchantmentDisplayName(Enchantment.PROTECTION_ENVIRONMENTAL, 4, "en_US"));
        assertEquals("Protection 11", LanguageHelper.getEnchantmentDisplayName(Enchantment.PROTECTION_ENVIRONMENTAL, 11, "en_US"));
    }

    @Test
    public void testTranslateToLocale() throws IOException {
        assertEquals("Creeper", LanguageHelper.translateToLocal("entity.Creeper.name", "en_US"));
        assertEquals("Stone", LanguageHelper.translateToLocal("tile.stone.stone.name", "en_US"));
    }

}