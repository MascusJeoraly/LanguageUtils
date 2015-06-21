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

import com.meowj.langutils.LangUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Meow J on 6/20/2015.
 * <p/>
 * Unlocalized Name -> Localized Name
 *
 * @author Meow J
 */
public enum EnumLang {

    EN_US("en_US", new HashMap<String, String>()),
    AF_ZA("af_ZA", new HashMap<String, String>()),
    ZH_CN("zh_CN", new HashMap<String, String>());
	//WIP Lazy, who can help me (;´Д`)

    public String getLocale() {
        return locale;
    }

    public Map<String, String> getMap() {
        return map;
    }

    private final String locale;
    private final Map<String, String> map;

    EnumLang(String locale, Map<String, String> map) {
        this.locale = locale;
        this.map = map;
    }


    private static final Map<String, EnumLang> lookup = new HashMap<String, EnumLang>();

    static {
        for (EnumLang lang : EnumSet.allOf(EnumLang.class))
            lookup.put(lang.getLocale(), lang);
    }

    public static EnumLang get(String locale) {
        return lookup.containsKey(locale) ? lookup.get(locale) : null;
    }

    public static void init() throws IOException {
        String temp;
        String[] tempStringArr;
        for (EnumLang enumLang : EnumLang.values()) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(EnumLang.class.getResourceAsStream("/lang/" + enumLang.locale + ".lang")));
            try {
                temp = reader.readLine();
                while (temp != null) {
                    if (temp.contains("=")) {
                        LangUtils.plugin.info(temp);
                        tempStringArr = temp.split("=");
                        enumLang.map.put(tempStringArr[0], tempStringArr.length > 1 ? temp.split("=")[1] : "");
                    }
                    temp = reader.readLine();
                }
            } finally {
                reader.close();
            }
            LangUtils.plugin.info(enumLang.getLocale() + " has been loaded.");
        }
    }
}
