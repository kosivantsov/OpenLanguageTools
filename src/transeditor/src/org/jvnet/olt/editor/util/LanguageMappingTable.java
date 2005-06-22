/*
 * Copyright  2005 Sun Microsystems, Inc.
 * All rights reserved Use is subject to license terms.
 *
 */
package org.jvnet.olt.editor.util;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/*
 * LanguageMappingTable.java
 *
 * Created on 11 June 2003, 14:34
 */
import java.util.StringTokenizer;


/**
 * This class is a kludge to translate <language>-<territory> codes to the
 * Editor internal codes. It is a stopgap class to fix bug . It will no
 * longer be needed once bug 4866728 is fixed.
 * It uses the Singleton and Factory Method patterns to ensure that there is
 * only one instance of this class in existence.
 * @author  jc73554
 */
public class LanguageMappingTable {
    private static LanguageMappingTable instance = null;
    private java.util.HashMap mappingTable;

    LanguageMappingTable() {
        //  Create and initialize the table
        mappingTable = new java.util.HashMap();
        mappingTable.put("en-gb", "EN");
        mappingTable.put("en-us", "US");
        mappingTable.put("en", "US");
        mappingTable.put("fr-fr", "FR");
        mappingTable.put("fr", "FR");
        mappingTable.put("de-de", "DE");
        mappingTable.put("de", "DE");
        mappingTable.put("it-it", "IT");
        mappingTable.put("it", "IT");
        mappingTable.put("sv-se", "SV");
        mappingTable.put("sv", "SV");
        mappingTable.put("es-es", "ES");
        mappingTable.put("es", "ES");
        mappingTable.put("zh-cn", "ZH");
        mappingTable.put("zh", "ZH");
        mappingTable.put("zh-tw", "ZT");
        mappingTable.put("ja-jp", "JA");
        mappingTable.put("ja", "JA");
        mappingTable.put("ko-kr", "KO");
        mappingTable.put("ko", "KO");
        mappingTable.put("cs-cz", "CS");
        mappingTable.put("cs", "CS");
        mappingTable.put("ru-ru", "RU");
        mappingTable.put("ru", "RU");
        mappingTable.put("pl-pl", "PL");
        mappingTable.put("pl", "PL");
        mappingTable.put("pt-br", "PB");
        mappingTable.put("pt-pt", "PT");
        mappingTable.put("pt", "PT");
        mappingTable.put("hi-in", "HI");
        mappingTable.put("ar-sa", "AR"); //  Arabic
        mappingTable.put("he-il", "HE"); //  Hebrew
        mappingTable.put("tr-TR", "TR"); //  Turkish
        mappingTable.put("es-amer", "EA"); //  Latin American Spanish
        mappingTable.put("uk-ua", "UK"); //  Ukranian
        mappingTable.put("da-dk", "DA"); //  Danish
        mappingTable.put("el-gr", "EL"); //  Greek
        mappingTable.put("sk-sk", "SK");

        //GNOME supported langs
        mappingTable.put("af_af", "AF"); //Afrikaans
        mappingTable.put("am_am", "AM"); //Amharic
        mappingTable.put("ang_ang", "AE"); //Old English

        mappingTable.put("as_as", "AS"); //Assamese
        mappingTable.put("az_az", "AZ"); //Azerbaijani
        mappingTable.put("az_ir", "AI"); //Iranian Azerbaijani
        mappingTable.put("be_be", "BE"); //Belarusian
        mappingTable.put("bg_bg", "BG"); //Bulgarian
        mappingTable.put("bn_bn", "BN"); //Bengali
        mappingTable.put("br_br", "BR"); //Breton
        mappingTable.put("bs_bs", "BS"); //Bosnian

        mappingTable.put("cy_cy", "CY"); //Welsh

        mappingTable.put("en_au", "AU"); //Australian English
        mappingTable.put("en_ca", "CD"); //Canadian English
        mappingTable.put("en_gb", "GB"); //British English
        mappingTable.put("eo_eo", "EO"); //Esperanto

        mappingTable.put("et_et", "ET"); //Estonian
        mappingTable.put("eu_eu", "EU"); //Basque
        mappingTable.put("fa_fa", "FA"); //Persian
        mappingTable.put("fi_fi", "FI"); //Finnish

        mappingTable.put("ga_ga", "GA"); //Irish Gaelic
        mappingTable.put("gl_gl", "GL"); //Galician
        mappingTable.put("gu_gu", "GU"); //Gujarati

        mappingTable.put("hr_hr", "HR"); //Croatian

        mappingTable.put("hy_hy", "HY"); //Armenian
        mappingTable.put("ia_ia", "IA"); //Interlingua
        mappingTable.put("id_id", "ID"); //Indonesian
        mappingTable.put("is_is", "IS"); //Icelandic

        mappingTable.put("ka_ka", "KA"); //Georgian
        mappingTable.put("kn_kn", "KN"); //Kannada

        mappingTable.put("ku_ku", "KU"); //Kurdish
        mappingTable.put("li_li", "LI"); //Limburgish
        mappingTable.put("lt_lt", "LT"); //Lithuanian
        mappingTable.put("lv_lv", "LV"); //Latvian
        mappingTable.put("mi_mi", "MI"); //Maori
        mappingTable.put("mk_mk", "MK"); //Macedonian
        mappingTable.put("ml_ml", "ML"); //Malayalam
        mappingTable.put("mn_mn", "MN"); //Mongolian
        mappingTable.put("mr_mr", "MR"); //Marathi
        mappingTable.put("ms_ms", "MS"); //Malay
        mappingTable.put("nb_nb", "NB"); //Norwegian Bookmal
        mappingTable.put("ne_ne", "NE"); //Nepali

        mappingTable.put("nn_nn", "NN"); //Norwegian Nynorsk
        mappingTable.put("nso_nso", "NS"); //Northern Sotho
        mappingTable.put("or_or", "OR"); //Oriya
        mappingTable.put("pa_pa", "PA"); //Punjabi

        mappingTable.put("ro_ro", "RO"); //Romanian

        mappingTable.put("rw_rw", "RW"); //Kinyarwanda

        mappingTable.put("sl_sl", "SL"); //Slovenian
        mappingTable.put("sq_sq", "SQ"); //Albanian
        mappingTable.put("sr_sr", "SR"); //Serbian
        mappingTable.put("sr_cs", "SJ"); //Serbian Jekavian

        mappingTable.put("ta_ta", "TA"); //Tamil
        mappingTable.put("te_te", "TE"); //Telugu
        mappingTable.put("tg_tg", "TG"); //Tajik

        mappingTable.put("tk_tk", "TK"); //Turkmen
        mappingTable.put("tl_tl", "TL"); //Tagalog

        mappingTable.put("ug_ug", "UG"); //Uighur

        mappingTable.put("uz_uz", "UZ"); //Uzbek
        mappingTable.put("uz_latn", "UL"); //Uzbek Latin Script
        mappingTable.put("vi_vi", "VI"); //Vietnamese
        mappingTable.put("wa_wa", "WA"); //Wallon
        mappingTable.put("xh_xh", "XH"); //Xhosa
        mappingTable.put("yi_yi", "YI"); //Yiddish
        mappingTable.put("yo_yo", "YO"); //Yoruba

        mappingTable.put("zu_zu", "ZU"); //Zulu
    }

    /**
     *  This method translates <language>-<territory> codes to the
     *  Editor internal codes. It returns null if no mapping exists between the
     *  provided code and any of the internal Editor ones.
     *  like this
     */
    public String translateLangCode(String langCode) {
        String key = langCode.toLowerCase();
        String internalCode = (String)mappingTable.get(key);

        if (internalCode == null) {
            //  No direct match found: see if we can find a match based on
            //  the first bit.
            StringTokenizer tokenizer = new StringTokenizer(key, "-");
            key = tokenizer.nextToken();
            internalCode = (String)mappingTable.get(key);
        }

        return internalCode;
    }

    public static synchronized LanguageMappingTable getInstance() {
        if (instance == null) {
            instance = new LanguageMappingTable();
        }

        return instance;
    }

    /** do a reverse lookup from internal (short) code to xlz long code.
     *
     * This method lookus up short encoding equivalent of long code supplied
     * by xlz file.
     * The attempt to find the best coding is done by looking up the longest code
     * mapped to the short code   <br>
     * Example:<br>
     * <pre>
     * for EN return en_GB<b>
     * for US return en_US<br>
     * </pre>
     *
     * <p>
     * All return codes are correctly capitalized (xx-XX)
     * </p>
     * @param shortEvilLangCode
     * @return equivalent encoding
     */
    public String reverseTranslateLangCode(String shortEvilLangCode) {
        Set s = mappingTable.entrySet();

        //Iterate thru the map entries and find the longest long code you can
        String theCode = null;

        for (Iterator i = s.iterator(); i.hasNext();) {
            Map.Entry entry = (Map.Entry)i.next();

            String shortie = (String)entry.getValue();
            String longCode = (String)entry.getKey();

            if (shortEvilLangCode.equals(shortie) && ((theCode == null) || (longCode.length() > theCode.length()))) {
                theCode = longCode;
            }
        }

        //Found something ? Capitalize!
        if (theCode != null) {
            String[] pieces = theCode.split("-");

            if ((pieces == null) || (pieces.length != 2)) {
                return null;
            }

            return pieces[0] + "-" + pieces[1].toUpperCase();
        }

        return theCode;
    }
}