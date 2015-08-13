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

import java.io.*;
import java.nio.charset.Charset;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Meow J on 6/20/2015.
 * <p>
 * Unlocalized Name to Localized Name
 *
 * @author Meow J
 */
public enum EnumLang {

    AF_ZA("af_ZA", new HashMap<String, String>()),
    AR_SA("ar_SA", new HashMap<String, String>()),
    AST_ES("ast_ES", new HashMap<String, String>()),
    AZ_AZ("az_AZ", new HashMap<String, String>()),
    BG_BG("bg_BG", new HashMap<String, String>()),
    CA_ES("ca_ES", new HashMap<String, String>()),
    CS_CZ("cs_CZ", new HashMap<String, String>()),
    CY_GB("cy_GB", new HashMap<String, String>()),
    DA_DK("da_DK", new HashMap<String, String>()),
    DE_DE("de_DE", new HashMap<String, String>()),
    EL_GR("el_GR", new HashMap<String, String>()),
    EN_AU("en_AU", new HashMap<String, String>()),
    EN_CA("en_CA", new HashMap<String, String>()),
    EN_GB("en_GB", new HashMap<String, String>()),
    EN_PT("en_PT", new HashMap<String, String>()),
    EN_US("en_US", new HashMap<String, String>()),
    EO_UY("eo_UY", new HashMap<String, String>()),
    ES_AR("es_AR", new HashMap<String, String>()),
    ES_ES("es_ES", new HashMap<String, String>()),
    ES_MX("es_MX", new HashMap<String, String>()),
    ES_UY("es_UY", new HashMap<String, String>()),
    ES_VE("es_VE", new HashMap<String, String>()),
    ET_EE("et_EE", new HashMap<String, String>()),
    EU_ES("eu_ES", new HashMap<String, String>()),
    FA_IR("fa_IR", new HashMap<String, String>()),
    FIL_PH("fil_PH", new HashMap<String, String>()),
    FI_FI("fi_FI", new HashMap<String, String>()),
    FR_CA("fr_CA", new HashMap<String, String>()),
    FR_FR("fr_FR", new HashMap<String, String>()),
    GA_IE("ga_IE", new HashMap<String, String>()),
    GL_ES("gl_ES", new HashMap<String, String>()),
    GV_IM("gv_IM", new HashMap<String, String>()),
    HE_IL("he_IL", new HashMap<String, String>()),
    HI_IN("hi_IN", new HashMap<String, String>()),
    HR_HR("hr_HR", new HashMap<String, String>()),
    HU_HU("hu_HU", new HashMap<String, String>()),
    HY_AM("hy_AM", new HashMap<String, String>()),
    ID_ID("id_ID", new HashMap<String, String>()),
    IS_IS("is_IS", new HashMap<String, String>()),
    IT_IT("it_IT", new HashMap<String, String>()),
    JA_JP("ja_JP", new HashMap<String, String>()),
    KA_GE("ka_GE", new HashMap<String, String>()),
    KO_KR("ko_KR", new HashMap<String, String>()),
    KW_GB("kw_GB", new HashMap<String, String>()),
    LA_LA("la_LA", new HashMap<String, String>()),
    LB_LU("lb_LU", new HashMap<String, String>()),
    LT_LT("lt_LT", new HashMap<String, String>()),
    LV_LV("lv_LV", new HashMap<String, String>()),
    MI_NZ("mi_NZ", new HashMap<String, String>()),
    MS_MY("ms_MY", new HashMap<String, String>()),
    MT_MT("mt_MT", new HashMap<String, String>()),
    NDS_DE("nds_DE", new HashMap<String, String>()),
    NL_NL("nl_NL", new HashMap<String, String>()),
    NN_NO("nn_NO", new HashMap<String, String>()),
    NO_NO("no_NO", new HashMap<String, String>()),
    OC_FR("oc_FR", new HashMap<String, String>()),
    PL_PL("pl_PL", new HashMap<String, String>()),
    PT_BR("pt_BR", new HashMap<String, String>()),
    PT_PT("pt_PT", new HashMap<String, String>()),
    QYA_AA("qya_AA", new HashMap<String, String>()),
    RO_RO("ro_RO", new HashMap<String, String>()),
    RU_RU("ru_RU", new HashMap<String, String>()),
    SE_NO("se_NO", new HashMap<String, String>()),
    SK_SK("sk_SK", new HashMap<String, String>()),
    SL_SI("sl_SI", new HashMap<String, String>()),
    SR_SP("sr_SP", new HashMap<String, String>()),
    SV_SE("sv_SE", new HashMap<String, String>()),
    TH_TH("th_TH", new HashMap<String, String>()),
    TLH_AA("tlh_AA", new HashMap<String, String>()),
    TR_TR("tr_TR", new HashMap<String, String>()),
    UK_UA("uk_UA", new HashMap<String, String>()),
    VAL_ES("val_ES", new HashMap<String, String>()),
    VI_VN("vi_VN", new HashMap<String, String>()),
    ZH_CN("zh_CN", new HashMap<String, String>()),
    ZH_TW("zh_TW", new HashMap<String, String>());

    private static final Map<String, EnumLang> lookup = new HashMap<String, EnumLang>();

    static {
        for (EnumLang lang : EnumSet.allOf(EnumLang.class))
            lookup.put(lang.getLocale(), lang);
    }

    private final String locale;
    private final Map<String, String> map;

    /**
     * Create an index of lang file.
     */
    EnumLang(String locale, Map<String, String> map) {
        this.locale = locale;
        this.map = map;
    }

    /**
     * @param locale The locale of the language
     * @return The index of a lang file based on locale.
     */
    public static EnumLang get(String locale) {
        return lookup.containsKey(locale) ? lookup.get(locale) : EN_US;
    }

    /**
     * Initialize this class, load all the languages to the corresponding HashMap.
     *
     * @throws IOException if lang files do not exist.
     */
    public static void init() throws IOException {
        for (EnumLang enumLang : EnumLang.values()) {
            readFile(enumLang, new BufferedReader(new InputStreamReader(EnumLang.class.getResourceAsStream("/lang/" + enumLang.locale + ".lang"), Charset.forName("UTF-8"))));
            LangUtils.plugin.info(enumLang.getLocale() + " has been loaded.");
        }
        File customizedLangDir = new File(LangUtils.plugin.getDataFolder(), "lang");
        if (!customizedLangDir.exists()) customizedLangDir.mkdirs();

        for (File file : customizedLangDir.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.toLowerCase().endsWith(".lang");
            }
        })) {
            EnumLang enumLang = get(file.getName().replace(".lang", ""));
            if (enumLang.getLocale().equals("en_US") && !file.getName().contains("en_US")) {
                LangUtils.plugin.warn("Failed to load file " + file.getName());
            } else {
                readFile(enumLang, new BufferedReader(new InputStreamReader(new FileInputStream(file), Charset.forName("UTF-8"))));
            }
        }
    }

    /**
     * Clean all the HashMap
     */
    public static void clean() {
        for (EnumLang enumLang : EnumLang.values()) {
            enumLang.getMap().clear();
        }
    }

    public static void readFile(EnumLang enumLang, BufferedReader reader) throws IOException {
        String temp;
        String[] tempStringArr;
        try {
            temp = reader.readLine();
            while (temp != null) {
                if (temp.startsWith("#")) continue;
                if (temp.contains("=")) {
                    tempStringArr = temp.split("=");
                    enumLang.map.put(tempStringArr[0], tempStringArr.length > 1 ? tempStringArr[1] : "");
                }
                temp = reader.readLine();
            }
        } finally {
            reader.close();
        }
    }

    /**
     * @return The locale of the language
     */
    public String getLocale() {
        return locale;
    }

    /**
     * @return The HashMap of the language.
     */
    public Map<String, String> getMap() {
        return map;
    }
}
