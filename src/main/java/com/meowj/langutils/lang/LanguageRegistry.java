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

/**
 * Created by Meow J on 8/11/2015.
 * <p>
 * Customize the language entry
 *
 * @author Meow J
 */
public class LanguageRegistry {

    public static LanguageRegistry INSTANCE;

    /**
     * Add or replace a language entry
     *
     * @param lang            The language of the entry
     * @param unlocalizedName The unlocalized name of the entry
     * @param localizedName   The localized name of the entry
     * @return the previous value of the entry, or null if the entry is newly added.
     */
    public String registerEntry(EnumLang lang, String unlocalizedName, String localizedName) {
        return lang.getMap().put(unlocalizedName, localizedName);
    }

}
