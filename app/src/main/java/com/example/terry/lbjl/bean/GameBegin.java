package com.example.terry.lbjl.bean;

import java.util.List;

/**
 * Created by Terry on 2016/10/1.
 */
public class GameBegin {

    /**
     * id : 1475057723
     * iconurl : /allimgs/img_iapp/201607/_1469498781500.jpg
     * gname : 开挂江湖
     * openstate : 1
     * opentype : 2
     * score : 5
     * linkurl : 10-08 12:00
     * istop : 0
     * colors : 0
     * platform : 1,2
     * operators : 掌游科技
     * state : 1
     * addtime : 2016-10-08
     * starttime : 2016-10-08 12:00
     * keyword :
     * area : 1008
     * uid : 402881d255627faf01556c3e92fa0255
     * gid : 1444373631
     * indexpy : 0
     * isdel : 1
     * openflag : 3
     * vtypeimage : <i class='android'></i><i class='ios'></i>
     */

    private List<InfoBean> info;

    public List<InfoBean> getInfo() {
        return info;
    }

    public void setInfo(List<InfoBean> info) {
        this.info = info;
    }

    public static class InfoBean {
        private int id;
        private String iconurl;
        private String gname;
        private int openstate;
        private int opentype;
        private int score;
        private String linkurl;
        private int istop;
        private int colors;
        private String platform;
        private String operators;
        private int state;
        private String addtime;
        private String starttime;
        private String keyword;
        private String area;
        private String uid;
        private String gid;
        private String indexpy;
        private int isdel;
        private int openflag;
        private String vtypeimage;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getIconurl() {
            return iconurl;
        }

        public void setIconurl(String iconurl) {
            this.iconurl = iconurl;
        }

        public String getGname() {
            return gname;
        }

        public void setGname(String gname) {
            this.gname = gname;
        }

        public int getOpenstate() {
            return openstate;
        }

        public void setOpenstate(int openstate) {
            this.openstate = openstate;
        }

        public int getOpentype() {
            return opentype;
        }

        public void setOpentype(int opentype) {
            this.opentype = opentype;
        }

        public int getScore() {
            return score;
        }

        public void setScore(int score) {
            this.score = score;
        }

        public String getLinkurl() {
            return linkurl;
        }

        public void setLinkurl(String linkurl) {
            this.linkurl = linkurl;
        }

        public int getIstop() {
            return istop;
        }

        public void setIstop(int istop) {
            this.istop = istop;
        }

        public int getColors() {
            return colors;
        }

        public void setColors(int colors) {
            this.colors = colors;
        }

        public String getPlatform() {
            return platform;
        }

        public void setPlatform(String platform) {
            this.platform = platform;
        }

        public String getOperators() {
            return operators;
        }

        public void setOperators(String operators) {
            this.operators = operators;
        }

        public int getState() {
            return state;
        }

        public void setState(int state) {
            this.state = state;
        }

        public String getAddtime() {
            return addtime;
        }

        public void setAddtime(String addtime) {
            this.addtime = addtime;
        }

        public String getStarttime() {
            return starttime;
        }

        public void setStarttime(String starttime) {
            this.starttime = starttime;
        }

        public String getKeyword() {
            return keyword;
        }

        public void setKeyword(String keyword) {
            this.keyword = keyword;
        }

        public String getArea() {
            return area;
        }

        public void setArea(String area) {
            this.area = area;
        }

        public String getUid() {
            return uid;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }

        public String getGid() {
            return gid;
        }

        public void setGid(String gid) {
            this.gid = gid;
        }

        public String getIndexpy() {
            return indexpy;
        }

        public void setIndexpy(String indexpy) {
            this.indexpy = indexpy;
        }

        public int getIsdel() {
            return isdel;
        }

        public void setIsdel(int isdel) {
            this.isdel = isdel;
        }

        public int getOpenflag() {
            return openflag;
        }

        public void setOpenflag(int openflag) {
            this.openflag = openflag;
        }

        public String getVtypeimage() {
            return vtypeimage;
        }

        public void setVtypeimage(String vtypeimage) {
            this.vtypeimage = vtypeimage;
        }
    }
}
