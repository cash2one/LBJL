package com.example.terry.lbjl.db;

import com.example.terry.lbjl.bean.SearchHistory;

import java.util.List;

/**
 * Created by Terry on 2016/9/28.
 * 搜索历史数据接口
 */
public interface ISearchHistoryDao {

    void saveSearchHistory(SearchHistory history);

    void clearSearchHistory();

    List<SearchHistory> getSearchHistories(String input);
}
