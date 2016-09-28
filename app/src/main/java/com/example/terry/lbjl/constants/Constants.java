package com.example.terry.lbjl.constants;

/**
 * Created by Terry on 2016/9/26.
 */
public class Constants {
    //    礼包
    public static final String GIFT_MAIN = "http://www.1688wan.com/";
    //    礼包列表  后跟页码，从1开始
    public static final String GIFT_PATH = "http://www.1688wan.com/majax.action?method=getGiftList&pageno=";
    //    礼包详情  后跟礼包列表中的ID
    public static final String GIFT_DETAIL = "http://www.1688wan.com/majax.action?method=getGiftInfo&id=";
    //    开服-开服
    public static final String GAME_OPEN = "http://www.1688wan.com/majax.action?method=getJtkaifu";
    //    开服-开测
    public static final String GAME_TEST = "http://www.1688wan.com/majax.action?method=getWebfutureTest";
    //    开服-开服详情   后跟开服-开服和开服-开测接口中的gid（待验证）
    public static final String GAME_OPEN_DETAIL = "http://www.1688wan.com/majax.action?method=getAppInfo&id=";
    //    热门
    public static final String HOT_PATH = "http://www.1688wan.com//majax.action?method=hotpushForAndroid";
    //    特色-暴打星期三  后跟页码，从0开始
    public static final String FEATURE_WED = "http://www.1688wan.com/majax.action?method=bdxqs&pageNo=";
    //    特色-暴打星期三详情   后跟暴打星期三列表中的ID
    public static final String FEATURE_WED_DETAIL = "http://www.1688wan.com/majax.action?method=bdxqschild&id=";
    //    特色-新游周刊   后跟页码，从0开始
    public static final String FEATURE_NEW = "http://www.1688wan.com/majax.action?method=getWeekll&pageNo=";
    //   特色-新游周刊-详情
    public static final String FEATURE_NEW_DETAIL = "http://www.1688wan.com/majax.action?method=getWeekllChid&id=";
    //    搜索
    public static final String SEARCH = "http://www.1688wan.com/majax.action?method=searchGift&key=";
}
