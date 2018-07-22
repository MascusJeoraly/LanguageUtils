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

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.meowj.langutils.LangUtils;

import java.io.*;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Created by Meow J on 6/20/2015.
 * <p>
 * Unlocalized Name to Localized Name
 *
 * @author Meow J
 */
public enum EnumLang {

    AF_ZA("af_za", new HashMap<>()),
    AR_SA("ar_sa", new HashMap<>()),
    AST_ES("ast_es", new HashMap<>()),
    AZ_AZ("az_az", new HashMap<>()),
    BE_BY("be_by", new HashMap<>()),
    BG_BG("bg_bg", new HashMap<>()),
    BR_FR("br_fr", new HashMap<>()),
    BS_BA("bs_ba", new HashMap<>()),
    CA_ES("ca_es", new HashMap<>()),
    CS_CZ("cs_cz", new HashMap<>()),
    CY_GB("cy_gb", new HashMap<>()),
    DA_DK("da_dk", new HashMap<>()),
    DE_AT("de_at", new HashMap<>()),
    DE_CH("de_ch", new HashMap<>()),
    DE_DE("de_de", new HashMap<>()),
    EL_GR("el_gr", new HashMap<>()),
    ENP("enp", new HashMap<>()),
    ENWS("enws", new HashMap<>()),
    EN_AU("en_au", new HashMap<>()),
    EN_CA("en_ca", new HashMap<>()),
    EN_GB("en_gb", new HashMap<>()),
    EN_NZ("en_nz", new HashMap<>()),
    EN_PT("en_pt", new HashMap<>()),
    EN_UD("en_ud", new HashMap<>()),
    EN_US("en_us", new HashMap<>()),
    EO_UY("eo_uy", new HashMap<>()),
    ES_AR("es_ar", new HashMap<>()),
    ES_CL("es_cl", new HashMap<>()),
    ES_ES("es_es", new HashMap<>()),
    ES_MX("es_mx", new HashMap<>()),
    ES_UY("es_uy", new HashMap<>()),
    ES_VE("es_ve", new HashMap<>()),
    ET_EE("et_ee", new HashMap<>()),
    EU_ES("eu_es", new HashMap<>()),
    FA_IR("fa_ir", new HashMap<>()),
    FIL_PH("fil_ph", new HashMap<>()),
    FI_FI("fi_fi", new HashMap<>()),
    FO_FO("fo_fo", new HashMap<>()),
    FR_CA("fr_ca", new HashMap<>()),
    FR_FR("fr_fr", new HashMap<>()),
    FY_NL("fy_nl", new HashMap<>()),
    GA_IE("ga_ie", new HashMap<>()),
    GD_GB("gd_gb", new HashMap<>()),
    GL_ES("gl_es", new HashMap<>()),
    GV_IM("gv_im", new HashMap<>()),
    HAW_US("haw_us", new HashMap<>()),
    HE_IL("he_il", new HashMap<>()),
    HI_IN("hi_in", new HashMap<>()),
    HR_HR("hr_hr", new HashMap<>()),
    HU_HU("hu_hu", new HashMap<>()),
    HY_AM("hy_am", new HashMap<>()),
    ID_ID("id_id", new HashMap<>()),
    IG_NG("ig_ng", new HashMap<>()),
    IO_EN("io_en", new HashMap<>()),
    IS_IS("is_is", new HashMap<>()),
    IT_IT("it_it", new HashMap<>()),
    JA_JP("ja_jp", new HashMap<>()),
    JBO_EN("jbo_en", new HashMap<>()),
    KAB_KAB("kab_kab", new HashMap<>()),
    KA_GE("ka_ge", new HashMap<>()),
    KN_IN("kn_in", new HashMap<>()),
    KO_KR("ko_kr", new HashMap<>()),
    KSH("ksh", new HashMap<>()),
    KW_GB("kw_gb", new HashMap<>()),
    LA_LA("la_la", new HashMap<>()),
    LB_LU("lb_lu", new HashMap<>()),
    LI_LI("li_li", new HashMap<>()),
    LOL_US("lol_us", new HashMap<>()),
    LT_LT("lt_lt", new HashMap<>()),
    LV_LV("lv_lv", new HashMap<>()),
    MI_NZ("mi_nz", new HashMap<>()),
    MK_MK("mk_mk", new HashMap<>()),
    MN_MN("mn_mn", new HashMap<>()),
    MS_MY("ms_my", new HashMap<>()),
    MT_MT("mt_mt", new HashMap<>()),
    NDS_DE("nds_de", new HashMap<>()),
    NL_BE("nl_be", new HashMap<>()),
    NL_NL("nl_nl", new HashMap<>()),
    NN_NO("nn_no", new HashMap<>()),
    NO_NO("no_no", new HashMap<>()),
    OC_FR("oc_fr", new HashMap<>()),
    OJ_CA("oj_ca", new HashMap<>()),
    OVD("ovd", new HashMap<>()),
    PL_PL("pl_pl", new HashMap<>()),
    PT_BR("pt_br", new HashMap<>()),
    PT_PT("pt_pt", new HashMap<>()),
    QYA_AA("qya_aa", new HashMap<>()),
    RO_RO("ro_ro", new HashMap<>()),
    RU_RU("ru_ru", new HashMap<>()),
    SE_NO("se_no", new HashMap<>()),
    SK_SK("sk_sk", new HashMap<>()),
    SL_SI("sl_si", new HashMap<>()),
    SO_SO("so_so", new HashMap<>()),
    SQ_AL("sq_al", new HashMap<>()),
    SR_SP("sr_sp", new HashMap<>()),
    SV_SE("sv_se", new HashMap<>()),
    SWG("swg", new HashMap<>()),
    SXU("sxu", new HashMap<>()),
    SZL("szl", new HashMap<>()),
    TA_IN("ta_in", new HashMap<>()),
    TH_TH("th_th", new HashMap<>()),
    TLH_AA("tlh_aa", new HashMap<>()),
    TR_TR("tr_tr", new HashMap<>()),
    TZL_TZL("tzl_tzl", new HashMap<>()),
    UK_UA("uk_ua", new HashMap<>()),
    VAL_ES("val_es", new HashMap<>()),
    VEC_IT("vec_it", new HashMap<>()),
    VI_VN("vi_vn", new HashMap<>()),
    YO_NG("yo_ng", new HashMap<>()),
    ZH_CN("zh_cn", new HashMap<>()),
    ZH_TW("zh_tw", new HashMap<>());


    private static final Map<String, EnumLang> lookup = new HashMap<>();

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
        EnumLang result = lookup.get(locale);
        return result == null ? EN_US : result;
    }

    /**
     * Initialize this class, load all the languages to the corresponding HashMap.
     */
    public static void init() {
        for (EnumLang enumLang : EnumLang.values()) {
            if (!LangUtils.plugin.config.getStringList("LoadLanguage").contains("all") && !LangUtils.plugin.config.getStringList("LoadLanguage").contains(enumLang.getLocale())) {
                LangUtils.plugin.info("Skipped " + enumLang.getLocale());
                continue;
            }
            try {
                readFile(enumLang, new BufferedReader(new InputStreamReader(EnumLang.class.getResourceAsStream("/lang/" + enumLang.locale + ".json"), Charset.forName("UTF-8"))));
                LangUtils.plugin.info(enumLang.getLocale() + " has been loaded.");
            } catch (Exception e) {
                LangUtils.plugin.warn("Fail to load language file " + enumLang.getLocale());
                e.printStackTrace();
            }
        }
        File customizedLangDir = new File(LangUtils.plugin.getDataFolder(), "lang");
        if (!customizedLangDir.exists()) customizedLangDir.mkdirs();

        for (File file : Objects.requireNonNull(customizedLangDir.listFiles((dir, name) -> name.toLowerCase().endsWith(".json")))) {
            EnumLang enumLang = get(file.getName()); // Returns EN_US when language not found.
            if (enumLang.getLocale().equals(EN_US.locale) && !file.getName().contains(EN_US.locale)) {
                LangUtils.plugin.warn("Failed to load customized language file " + file.getName()); // Language not present
            } else {
                try (FileInputStream fs = new FileInputStream(file)) {
                    readFile(enumLang, new BufferedReader(new InputStreamReader(fs, Charset.forName("UTF-8"))));
                    LangUtils.plugin.warn("Failed to load customized language file " + file.getName()); // Error loading language files
                } catch (Exception e) {
                    e.printStackTrace();
                }
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
        try {
            Gson gson = new Gson();
            Type type = new TypeToken<Map<String, String>>() {
            }.getType();
            Map<String, String> map = gson.fromJson(reader, type);
            enumLang.map.putAll(map);
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
