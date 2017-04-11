package com.example.sus.android_xutilstext.Bean;

import org.xutils.db.annotation.Column;
import org.xutils.db.annotation.Table;

/**
 * Date：2017/4/11
 * author: 曹政杰Administrator.
 * function：
 */
 @Table(name="TopNews")
public class TopNews {
    @Column(name="id",isId = true,autoGen = true,property = "NOT NULL")
    private int id;
    @Column(name="uri")
    private String uri;
    @Column(name="title")
    private String title;

    public TopNews() {
    }

    public TopNews(String uri, String title) {
        this.uri = uri;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "TopNews{" +
                "id=" + id +
                ", uri='" + uri + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
