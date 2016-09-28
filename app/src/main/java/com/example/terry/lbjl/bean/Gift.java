package com.example.terry.lbjl.bean;

import java.util.List;

/**
 * Created by Terry on 2016/9/26.
 */
public class Gift {

    /**
     * ad : [{"id":249,"title":"绝世武神独家礼包（安卓）","flag":1,"iconurl":"/allimgs/img_iad/_1474623667919.jpg","addtime":"2016-09-17","giftid":"1474618510","appName":"绝世武神","appLogo":"/allimgs/img_iapp/201607/_1469611677571.jpg","appId":1444892111},{"id":246,"title":"天天炫舞中秋独家礼包","flag":1,"iconurl":"/allimgs/img_iad/_1473751476804.jpg","addtime":"2016-09-15","giftid":"1473749901","appName":"天天炫舞","appLogo":"/allimgs/img_iapp/201609/_1474340811708.png","appId":2496048},{"id":243,"title":"航海王强者之路中秋媒体节日礼包","flag":1,"iconurl":"/allimgs/img_iad/_1473316667867.jpg","addtime":"2016-09-14","giftid":"1473316129","appName":"航海王强者之路","appLogo":"/allimgs/img_iapp/201511/_1448446144213.png","appId":1448446177},{"id":245,"title":"大秦帝国OL中秋独家礼包 ","flag":1,"iconurl":"/allimgs/img_iad/_1473749952262.jpg","addtime":"2016-09-14","giftid":"1473742131","appName":"大秦帝国OL","appLogo":"/allimgs/img_iapp/201607/_1469687930154.jpg","appId":1467784200},{"id":247,"title":"风暴部落中秋礼包","flag":1,"iconurl":"/allimgs/img_iad/_1473831738979.jpg","addtime":"2016-09-13","giftid":"1473826961","appName":"风暴部落","appLogo":"/allimgs/img_iapp/201609/_1473238539795.png","appId":1451287404}]
     * pageno : 178
     * list : [{"id":"1474593519","iconurl":"/allimgs/img_iapp/201609/_1474514750102.jpg","giftname":"媒体福利礼包","number":41,"exchanges":9,"type":1,"gname":"如果的世界","integral":0,"isintegral":0,"addtime":"2016-09-23","ptype":"1,2,","operators":"","flag":1},{"id":"1474593972","iconurl":"/allimgs/img_iapp/201609/_1474268071372.png","giftname":"不删档内测新手礼包 ","number":9,"exchanges":1,"type":1,"gname":"斗战杀神","integral":0,"isintegral":0,"addtime":"2016-09-23","ptype":"2,","operators":"","flag":1},{"id":"1474595876","iconurl":"/allimgs/img_iapp/201609/_1474595537699.png","giftname":"首发神秘礼包","number":10,"exchanges":0,"type":1,"gname":"小小部队：联盟","integral":0,"isintegral":0,"addtime":"2016-09-23","ptype":"1,","operators":"","flag":1},{"id":"1474609629","iconurl":"/allimgs/img_iapp/201607/_1467685997863.jpg","giftname":"水晶礼包","number":30,"exchanges":0,"type":1,"gname":"街机捕鱼交友版","integral":1500,"isintegral":0,"addtime":"2016-09-23","ptype":"1,2,","operators":"","flag":1},{"id":"1474610106","iconurl":"/allimgs/img_iapp/201608/_1470895602157.jpg","giftname":"开测礼包","number":8,"exchanges":1,"type":1,"gname":"冒险战记","integral":0,"isintegral":0,"addtime":"2016-09-23","ptype":"1,","operators":"","flag":1},{"id":"1474610730","iconurl":"/allimgs/img_iapp/201605/_1463469140278.jpg","giftname":"群雄问鼎限量新手卡","number":19,"exchanges":1,"type":1,"gname":"神武2","integral":0,"isintegral":0,"addtime":"2016-09-23","ptype":"1,2,","operators":"","flag":1},{"id":"1474614525","iconurl":"/allimgs/img_iapp/201606/_1466993772020.jpg","giftname":"礼包","number":8,"exchanges":12,"type":1,"gname":"少年西游记","integral":0,"isintegral":0,"addtime":"2016-09-23","ptype":"1,2,","operators":"","flag":1},{"id":"1474615035","iconurl":"/allimgs/img_iapp/201609/_1474255727284.png","giftname":"公测独家礼包","number":49,"exchanges":1,"type":1,"gname":"帝王世纪","integral":0,"isintegral":0,"addtime":"2016-09-23","ptype":"1,","operators":"","flag":1},{"id":"1474618092","iconurl":"/allimgs/img_iapp/201607/_1469611677571.jpg","giftname":"独家礼包（ios）","number":50,"exchanges":0,"type":1,"gname":"绝世武神","integral":0,"isintegral":0,"addtime":"2016-09-23","ptype":"2,","operators":"","flag":1},{"id":"1474630308","iconurl":"/allimgs/img_iapp/201504/_1429091380602.jpg","giftname":"国庆西行礼包","number":17,"exchanges":3,"type":1,"gname":"梦幻西游手游","integral":0,"isintegral":0,"addtime":"2016-09-23","ptype":"1,","operators":"","flag":1}]
     */

    private int pageno;
    /**
     * id : 249
     * title : 绝世武神独家礼包（安卓）
     * flag : 1
     * iconurl : /allimgs/img_iad/_1474623667919.jpg
     * addtime : 2016-09-17
     * giftid : 1474618510
     * appName : 绝世武神
     * appLogo : /allimgs/img_iapp/201607/_1469611677571.jpg
     * appId : 1444892111
     */

    private List<AdBean> ad;
    /**
     * id : 1474593519
     * iconurl : /allimgs/img_iapp/201609/_1474514750102.jpg
     * giftname : 媒体福利礼包
     * number : 41
     * exchanges : 9
     * type : 1
     * gname : 如果的世界
     * integral : 0
     * isintegral : 0
     * addtime : 2016-09-23
     * ptype : 1,2,
     * operators :
     * flag : 1
     */

    private List<ListBean> list;

    public int getPageno() {
        return pageno;
    }

    public void setPageno(int pageno) {
        this.pageno = pageno;
    }

    public List<AdBean> getAd() {
        return ad;
    }

    public void setAd(List<AdBean> ad) {
        this.ad = ad;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class AdBean {
        private int id;
        private String title;
        private int flag;
        private String iconurl;
        private String addtime;
        private String giftid;
        private String appName;
        private String appLogo;
        private int appId;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getFlag() {
            return flag;
        }

        public void setFlag(int flag) {
            this.flag = flag;
        }

        public String getIconurl() {
            return iconurl;
        }

        public void setIconurl(String iconurl) {
            this.iconurl = iconurl;
        }

        public String getAddtime() {
            return addtime;
        }

        public void setAddtime(String addtime) {
            this.addtime = addtime;
        }

        public String getGiftid() {
            return giftid;
        }

        public void setGiftid(String giftid) {
            this.giftid = giftid;
        }

        public String getAppName() {
            return appName;
        }

        public void setAppName(String appName) {
            this.appName = appName;
        }

        public String getAppLogo() {
            return appLogo;
        }

        public void setAppLogo(String appLogo) {
            this.appLogo = appLogo;
        }

        public int getAppId() {
            return appId;
        }

        public void setAppId(int appId) {
            this.appId = appId;
        }
    }

    public static class ListBean {
        private String id;
        private String iconurl;
        private String giftname;
        private int number;
        private int exchanges;
        private int type;
        private String gname;
        private int integral;
        private int isintegral;
        private String addtime;
        private String ptype;
        private String operators;
        private int flag;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getIconurl() {
            return iconurl;
        }

        public void setIconurl(String iconurl) {
            this.iconurl = iconurl;
        }

        public String getGiftname() {
            return giftname;
        }

        public void setGiftname(String giftname) {
            this.giftname = giftname;
        }

        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
        }

        public int getExchanges() {
            return exchanges;
        }

        public void setExchanges(int exchanges) {
            this.exchanges = exchanges;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getGname() {
            return gname;
        }

        public void setGname(String gname) {
            this.gname = gname;
        }

        public int getIntegral() {
            return integral;
        }

        public void setIntegral(int integral) {
            this.integral = integral;
        }

        public int getIsintegral() {
            return isintegral;
        }

        public void setIsintegral(int isintegral) {
            this.isintegral = isintegral;
        }

        public String getAddtime() {
            return addtime;
        }

        public void setAddtime(String addtime) {
            this.addtime = addtime;
        }

        public String getPtype() {
            return ptype;
        }

        public void setPtype(String ptype) {
            this.ptype = ptype;
        }

        public String getOperators() {
            return operators;
        }

        public void setOperators(String operators) {
            this.operators = operators;
        }

        public int getFlag() {
            return flag;
        }

        public void setFlag(int flag) {
            this.flag = flag;
        }
    }
}
