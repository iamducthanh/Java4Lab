package com.fpoly.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@NamedQueries({
        @NamedQuery(name = "thongKe", query = "SELECT new Report(o.video.title, count(o), min(o.likeDate), max(o.likeDate)) FROM FavoritesEntity o GROUP BY o.video.title")
})
@Entity
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Serializable group;
    private Long like;
    private Date newest;
    private Date oldest;

    public Report(Serializable group, Long like, Date newest, Date oldest) {
        this.group = group;
        this.like = like;
        this.newest = newest;
        this.oldest = oldest;
    }

    public Report() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Serializable getGroup() {
        return group;
    }

    public void setGroup(Serializable group) {
        this.group = group;
    }

    public Long getLike() {
        return like;
    }

    public void setLike(Long like) {
        this.like = like;
    }

    public Date getNewest() {
        return newest;
    }

    public void setNewest(Date newest) {
        this.newest = newest;
    }

    public Date getOldest() {
        return oldest;
    }

    public void setOldest(Date oldest) {
        this.oldest = oldest;
    }

    @Override
    public String toString() {
        return "Report{" +
                "id=" + id +
                ", group=" + group +
                ", like=" + like +
                ", newest=" + newest +
                ", oldest=" + oldest +
                '}';
    }
}
