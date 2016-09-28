package com.example.terry.lbjl.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

/**
 * Created by Terry on 2016/9/28.
 */
@Entity
public class SearchHistory {
    @Id(autoincrement = true)
    private Long id;
    private String input;
    private int searchCount;

    @Generated(hash = 1168269588)
    public SearchHistory(Long id, String input, int searchCount) {
        this.id = id;
        this.input = input;
        this.searchCount = searchCount;
    }

    public SearchHistory(String input, int searchCount) {
        this.input = input;
        this.searchCount = searchCount;
    }

    @Generated(hash = 1905904755)
    public SearchHistory() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInput() {
        return this.input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public int getSearchCount() {
        return this.searchCount;
    }

    public void setSearchCount(int searchCount) {
        this.searchCount = searchCount;
    }
}
