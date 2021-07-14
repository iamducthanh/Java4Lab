package com.fpoly.entity;

import javax.persistence.*;
import java.util.List;

@NamedQueries({
        @NamedQuery(name = "findByUser", query = "SELECT o.video FROM FavoritesEntity o WHERE o.user.id = ?1"),
        @NamedQuery(name = "findVideoFavoritesByKeyword", query = "SELECT DISTINCT o.video FROM FavoritesEntity o WHERE o.video.title LIKE ?1"),
        @NamedQuery(name = "filterVideoFavorite", query = "SELECT o from VideoEntity o WHERE o.listFavorites IS NOT EMPTY"),
        @NamedQuery(name = "filterVideoNotFavorite", query = "SELECT o from VideoEntity o WHERE o.listFavorites IS EMPTY")
})
@Entity
@Table(name = "videos")
public class VideoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "title")
    private String title;
    @Column(name = "poster")
    private String poster;
    @Column(name = "description")
    private String description;
    @Column(name = "active")
    private boolean active;
    @Column(name = "views")
    private int views;

    @OneToMany(mappedBy = "video")
    List<FavoritesEntity> listFavorites;

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

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int view) {
        this.views = view;
    }

    public List<FavoritesEntity> getListFavorites() {
        return listFavorites;
    }

    public void setListFavorites(List<FavoritesEntity> listFavorites) {
        this.listFavorites = listFavorites;
    }

    @Override
    public String toString() {
        return "VideoEntity{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", poster='" + poster + '\'' +
                ", description='" + description + '\'' +
                ", active=" + active +
                ", views=" + views +
                ", listFavorites=" + listFavorites +
                '}';
    }
}
