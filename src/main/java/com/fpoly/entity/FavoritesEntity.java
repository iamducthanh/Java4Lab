//package com.fpoly.entity;
//
//import javax.persistence.*;
//import java.util.Date;
//import java.util.List;
//
//@Entity
//@Table(name = "favorites", uniqueConstraints = {@UniqueConstraint(columnNames = {"videoId","userId"})})
//public class FavoritesEntity {
//    @Id
//    @Column(name = "id")
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id;
//    @Column(name = "videoId")
//    @ManyToOne @JoinColumn(name = "videoId")
//    private int videoId;
//    @Column(name = "userId")
//    @ManyToOne @JoinColumn(name = "userId")
//    private int userId;
//    @Column(name = "likeDate")
//    @Temporal(TemporalType.DATE)
//    private Date likeDate;
//}
