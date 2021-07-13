package com.fpoly.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "favorites", uniqueConstraints = {@UniqueConstraint(columnNames = {"videoId","userId"})})
public class FavoritesEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne @JoinColumn(name = "videoId")
    VideoEntity video;

    @ManyToOne @JoinColumn(name = "userId")
    UserEntity user;

    @Column(name = "likeDate")
    @Temporal(TemporalType.DATE)
    private Date likeDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public VideoEntity getVideo() {
        return video;
    }

    public void setVideoId(VideoEntity video) {
        this.video = video;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity userId) {
        this.user = userId;
    }

    public Date getLikeDate() {
        return likeDate;
    }

    public void setLikeDate(Date likeDate) {
        this.likeDate = likeDate;
    }
}
