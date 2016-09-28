package com.example.terry.lbjl.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.terry.lbjl.bean.SearchHistory;

import java.util.List;

/**
 * Created by Terry on 2016/9/28.
 */
public class SearchHistoryUtils implements ISearchHistoryDao {

    public static final String DB_NAME = "search.db";
    SearchHistoryDao historyDao;

    public SearchHistoryUtils(Context context) {
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(context, DB_NAME);
        SQLiteDatabase database = helper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(database);
        DaoSession daoSession = daoMaster.newSession();
        historyDao = daoSession.getSearchHistoryDao();

    }

    @Override
    public void saveSearchHistory(SearchHistory history) {
//        查看搜索记录是否在数据库中存在
        List<SearchHistory> list = historyDao.queryBuilder().where(
                SearchHistoryDao.Properties.Input.eq(history.getInput()))
                .build()
                .list();
//        不存在添加进去
        if (list.size() == 0) {
            historyDao.insert(history);
//            存在就将搜索次数加1
        } else {
            SearchHistory history1 = list.get(0);
            history.setSearchCount(history.getSearchCount() + 1);
            historyDao.update(history1);
        }
    }

    @Override
    public void clearSearchHistory() {
        historyDao.deleteAll();
    }

    @Override
    public List<SearchHistory> getSearchHistories(String input) {
//        模糊查询
        List<SearchHistory> list = historyDao.queryBuilder().where(
                SearchHistoryDao.Properties.Input.like(input + "%"))
                .orderDesc(SearchHistoryDao.Properties.SearchCount)
                .build().list();
        return list;
    }
}
