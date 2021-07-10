//package com.fpoly.entity;
//
//import javax.persistence.*;
//import java.util.List;
//
//@Entity
//@Table(name = "videos")
//public class VideoEntity {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")
//    private int id;
//    @Column(name = "title")
//    private String title;
//    @Column(name = "poster")
//    private String poster;
//    @Column(name = "description")
//    private String description;
//    @Column(name = "active")
//    private boolean active;
//    @Column(name = "view")
//    private int view;
//    @OneToMany(mappedBy = "video")
//    List<FavoritesEntity> listFavorites;
//}
