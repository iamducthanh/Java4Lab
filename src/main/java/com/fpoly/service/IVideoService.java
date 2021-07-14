package com.fpoly.service;

import com.fpoly.entity.VideoEntity;

import java.util.List;

public interface IVideoService {
    List<VideoEntity> findByUser(int id);
    List<VideoEntity> findVideoFavoritesByKeyword(String keyword);
    List<VideoEntity> findVideoFavorite();
    List<VideoEntity> findVideoNotFavorite();
}
