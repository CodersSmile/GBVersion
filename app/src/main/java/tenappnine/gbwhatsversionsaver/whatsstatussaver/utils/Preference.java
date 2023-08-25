package tenappnine.gbwhatsversionsaver.whatsstatussaver.utils;

import android.content.SharedPreferences;

import tenappnine.gbwhatsversionsaver.whatsstatussaver.DataMyApps;

public class Preference {
    private static final String CityNameVPN = "CityNameVPN";
    private static final String CountryNmeVPN = "CountryNmeVPN";
    private static final String StateNameVPN = "StateNameVPN";
    private static final String VPNTime_date = "VPNTime_date";
    private static final String VPN_Show = "VPN_Show";
    private static final String Whatsapp_URI = "Whatsapp_URI";
    private static final String accessToken = "accessToken";
    private static final String add_open_interstitial = "add_open_interstitial";
    private static final String admbo_banner = "admbo_banner";
    private static final String admob_interstitial = "admob_interstitial";
    private static final String admob_interstitial_splash = "admob_interstitial_splash";
    private static final String admob_native = "admob_native1";
    private static final String admob_native_two = "admob_native_two1";
    private static final String ads_button_blink = "ads_button_blink";
    private static final String ads_click = "ads_click";
    private static final String appOpen_click = "appOpen_click";
    private static final String appOpen_inter_show = "appOpen_inter_show";
    private static final String aura_user_id = "aura_user_id";
    private static final String back_click = "back_click";
    private static final String bottom_ads_type = "bottom_ads_type";
    private static final String comingsoon = "comingsoon";
    private static final String firstscreen = "firstscreen";
    private static final String isProShow = "isProShow";
    private static final String isUpdate = "isUpdate";
    private static final String isVpnConnect = "isVpnConnect";
    private static final String islive = "islive";
    private static final String native_btn_text_color = "native_btn_text_color";
    private static final String native_button_color = "native_button_color";
    private static final String percentage = "percentage";
    private static final String privacy_policy = "privacy_policy";
    private static final String privacy_policy_html = "privacy_policy_html";
    private static final String qureka_header_show = "qureka_header_show";
    private static final String qureka_link = "qureka_link";
    private static final String qureka_show_Ads = "qureka_show_Ads";
    private static final String rendomserver = "rendomserver";
    private static final String sample_string = "sample_string";
    private static final String secondscreen = "secondscreen";
    private static final String server_image = "server_image";
    private static final String server_name = "server_name";
    private static final String server_pass = "server_pass";
    private static final String server_short = "server_short";
    private static final String server_username = "server_username";
    private static final String theme_number = "theme_number";
    private static final String versionCode = "versionCode";
    private static final String videocall_show = "videocall_show";
    private static final String vnid = "vnid";
    private static final String vnpassword = "vnpassword";
    private static final String vpn_ip_show = "vpn_ip_show";

    public static String getBottom_ads_type() {
        return get().getString(bottom_ads_type, "nativebanner");
    }

    public static void setBottom_ads_type(String str) {
        get().edit().putString(bottom_ads_type, str).apply();
    }

    public static void setFirstscreen(boolean z) {
        get().edit().putBoolean(firstscreen, z).apply();
    }

    public static boolean getFirstscreen() {
        return get().getBoolean(firstscreen, false);
    }

    public static void setSecondscreen(boolean z) {
        get().edit().putBoolean(secondscreen, z).apply();
    }

    public static boolean getSecondscreen() {
        return get().getBoolean(secondscreen, false);
    }

    public static void setqureka_header_show(boolean z) {
        get().edit().putBoolean(qureka_header_show, z).apply();
    }

    public static boolean getqureka_header_show() {
        return get().getBoolean(qureka_header_show, false);
    }

    public static void setcomingsoon(boolean z) {
        get().edit().putBoolean(comingsoon, z).apply();
    }

    public static boolean getcomingsoon() {
        return get().getBoolean(comingsoon, false);
    }

    public static void setServer_username(String str) {
        get().edit().putString(server_username, str).apply();
    }

    public static String getServer_username() {
        return get().getString(server_username, "");
    }

    public static void setpercentage(int i) {
        get().edit().putInt(percentage, i).apply();
    }

    public static int getpercentage() {
        return get().getInt(percentage, 0);
    }

    public static void setServer_pass(String str) {
        get().edit().putString(server_pass, str).apply();
    }

    public static String getServer_pass() {
        return get().getString(server_pass, "");
    }

    public static String getVnid() {
        return get().getString(vnid, "59161_myvpn");
    }

    public static void setVnid(String str) {
        get().edit().putString(vnid, str).apply();
    }

    public static String getVnpassword() {
        return get().getString(vnpassword, "ZEziW6v0O3");
    }

    public static void setVnpassword(String str) {
        get().edit().putString(vnpassword, str).apply();
    }

    public static String getIslive() {
        return get().getString(islive, "");
    }

    public static void setIslive(String str) {
        get().edit().putString(islive, str).apply();
    }

    public static String getIsProShow() {
        return get().getString(isProShow, "");
    }

    public static void setIsProShow(String str) {
        get().edit().putString(isProShow, str).apply();
    }

    public static String getVideocall_show() {
        return get().getString(videocall_show, "");
    }

    public static void setVideocall_show(String str) {
        get().edit().putString(videocall_show, str).apply();
    }

    public static String getQureka_show_ADS() {
        return get().getString(qureka_show_Ads, "");
    }

    public static void setQureka_show_ADS(String str) {
        get().edit().putString(qureka_show_Ads, str).apply();
    }

    public static String getSample_string() {
        return get().getString(sample_string, "http://157.245.125.183:1142/");
    }

    public static void setSample_string(String str) {
        get().edit().putString(sample_string, str).apply();
    }

    public static String getAdmob_native_two() {
        return get().getString(admob_native_two, "");
    }

    public static void setAdmob_native_two(String str) {
        get().edit().putString(admob_native_two, str).apply();
    }

    public static String getQureka_link() {
        return get().getString(qureka_link, "");
    }

    public static void setQureka_link(String str) {
        get().edit().putString(qureka_link, str).apply();
    }

    public static Integer getTheme_number() {
        return Integer.valueOf(get().getInt(theme_number, 0));
    }

    public static void setTheme_number(int i) {
        get().edit().putInt(theme_number, i).apply();
    }

    public static String get_ads_open() {
        return get().getString(add_open_interstitial, "");
    }

    public static void set_ads_open(String str) {
        get().edit().putString(add_open_interstitial, str).apply();
    }

    private static SharedPreferences get() {
        return DataMyApps.getPhotoApp().getSharedPreferences("App_Ctrl_New", 0);
    }

    public static String getPrivacy_policy() {
        return get().getString(privacy_policy, "");
    }

    public static void setPrivacy_policy(String str) {
        get().edit().putString(privacy_policy, str).apply();
    }

    public static int get_AdsClick() {
        return get().getInt(ads_click, 0);
    }

    public static void set_AdsClick(int i) {
        get().edit().putInt(ads_click, i).apply();
    }

    public static int getBack_click() {
        return get().getInt(back_click, 0);
    }

    public static void setBack_click(int i) {
        get().edit().putInt(back_click, i).apply();
    }

    public static String getIsUpdate() {
        return get().getString(isUpdate, "");
    }

    public static void setIsUpdate(String str) {
        get().edit().putString(isUpdate, str).apply();
    }

    public static String getVersionCode() {
        return get().getString(versionCode, "");
    }

    public static void setVersionCode(String str) {
        get().edit().putString(versionCode, str).apply();
    }

    public static void setAdmob_banner(String str) {
        get().edit().putString(admbo_banner, str).apply();
    }

    public static String getAdmbo_banner() {
        return get().getString(admbo_banner, "");
    }

    public static void setAdmob_Interstitial(String str) {
        get().edit().putString(admob_interstitial, str).apply();
    }

    public static String getAdmob_interstitial() {
        return get().getString(admob_interstitial, "");
    }

    public static String getAdmob_interstitial_splash() {
        return get().getString(admob_interstitial_splash, "");
    }

    public static void setAdmob_interstitial_splash(String str) {
        get().edit().putString(admob_interstitial_splash, str).apply();
    }

    public static String getAdmob_native() {
        return get().getString(admob_native, "");
    }

    public static void setAdmob_native(String str) {
        get().edit().putString(admob_native, str).apply();
    }

    public static int getColor() {
        return get().getInt("color", 0);
    }

    public static void setColor(int i) {
        get().edit().putInt("color", i).apply();
    }

    public static void setStateNameVPN(String str) {
        get().edit().putString(StateNameVPN, str).apply();
    }

    public static String getStateNameVPN() {
        return get().getString(StateNameVPN, "");
    }

    public static void setCountryNmeVPN(String str) {
        get().edit().putString(CountryNmeVPN, str).apply();
    }

    public static String getCountryNmeVPN() {
        return get().getString(CountryNmeVPN, "");
    }

    public static void setCityNameVPN(String str) {
        get().edit().putString(CityNameVPN, str).apply();
    }

    public static String getCityNameVPN() {
        return get().getString(CityNameVPN, "");
    }

    public static void setVPN_Show(boolean z) {
        get().edit().putBoolean(VPN_Show, z).apply();
    }

    public static boolean getVPN_Show() {
        return get().getBoolean(VPN_Show, false);
    }

    public static void setAppOpen_click(int i) {
        get().edit().putInt(appOpen_click, i).apply();
    }

    public static int getAppOpen_click() {
        return get().getInt(appOpen_click, 0);
    }

    public static void setAppOpen_inter_show(boolean z) {
        get().edit().putBoolean(appOpen_inter_show, z).apply();
    }

    public static boolean getAppOpen_inter_show() {
        return get().getBoolean(appOpen_inter_show, false);
    }

    public static void setRendomserver(boolean z) {
        get().edit().putBoolean(rendomserver, z).apply();
    }

    public static boolean getRendomserver() {
        return get().getBoolean(rendomserver, false);
    }

    public static void set_server_short(String str) {
        get().edit().putString(server_short, str).apply();
    }

    public static String getServer_short() {
        return get().getString(server_short, "US");
    }

    public static void setserver_name(String str) {
        get().edit().putString(server_name, str).apply();
    }

    public static String getserver_name() {
        return get().getString(server_name, "");
    }

    public static void setAura_user_id(long j) {
        get().edit().putLong(aura_user_id, j).apply();
    }

    public static long getAura_user_id() {
        return get().getLong(aura_user_id, 0);
    }

    public static void setAccessToken(String str) {
        get().edit().putString(accessToken, str).apply();
    }

    public static String getAccessToken() {
        return get().getString(accessToken, "");
    }

    public static void setServer_image(String str) {
        get().edit().putString(server_image, str).apply();
    }

    public static String getServer_image() {
        return get().getString(server_image, "");
    }

    public static void setPrivacy_policy_html(String str) {
        get().edit().putString(privacy_policy_html, str).apply();
    }

    public static String getPrivacy_policy_html() {
        return get().getString(privacy_policy_html, "");
    }

    public static void setVpn_ip_show(boolean z) {
        get().edit().putBoolean(vpn_ip_show, z).apply();
    }

    public static boolean getVpn_ip_show() {
        return get().getBoolean(vpn_ip_show, true);
    }

    public static void setAds_button_blink(boolean z) {
        get().edit().putBoolean(ads_button_blink, z).apply();
    }

    public static boolean getAds_button_blink() {
        return get().getBoolean(ads_button_blink, true);
    }

    public static void setVPNTime_date(String str) {
        get().edit().putString(VPNTime_date, str).apply();
    }

    public static String getVPNTime_date() {
        return get().getString(VPNTime_date, "");
    }

    public static boolean getisVpnConnect() {
        return get().getBoolean(isVpnConnect, false);
    }

    public static void setisVpnConnect(boolean z) {
        get().edit().putBoolean(isVpnConnect, z).apply();
    }

    public static void setNative_button_color(String str) {
        get().edit().putString(native_button_color, str).apply();
    }

    public static String getNative_button_color() {
        return get().getString(native_button_color, "");
    }

    public static void setNative_btn_text_color(String str) {
        get().edit().putString(native_btn_text_color, str).apply();
    }

    public static String getNative_btn_text_color() {
        return get().getString(native_btn_text_color, "");
    }

    public static void setWhatsapp_URI(String str) {
        get().edit().putString(Whatsapp_URI, str).apply();
    }

    public static String getWhatsapp_URI() {
        return get().getString(Whatsapp_URI, "");
    }
}
