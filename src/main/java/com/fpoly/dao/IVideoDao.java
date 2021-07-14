package com.fpoly.dao;

import com.fpoly.entity.VideoEntity;

import java.util.List;

public interface IVideoDao extends GenegicDao<VideoEntity>{
    List<VideoEntity> findByUser(int idUser);
    List<VideoEntity> findVideoFavoritesByKeyword(String keyword);
    List<VideoEntity> findVideoFavorite();
    List<VideoEntity> findVideoNotFavorite();
}
