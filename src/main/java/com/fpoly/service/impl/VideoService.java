package com.fpoly.service.impl;

import com.fpoly.dao.impl.VideoDao;
import com.fpoly.entity.VideoEntity;
import com.fpoly.service.IVideoService;

import javax.inject.Inject;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class VideoService implements IVideoService {
    @Inject
    private VideoDao videoDao;

    @Override
    public List<VideoEntity> findByUser(int id) {
        return videoDao.findByUser(id);
    }

    @Override
    public List<VideoEntity> findVideoFavoritesByKeyword(String keyword) {
        keyword = "%" + keyword + "%";
        return videoDao.findVideoFavoritesByKeyword(keyword);
    }

    @Override
    public List<VideoEntity> findVideoFavorite() {
        return videoDao.findVideoFavorite();
    }

    @Override
    public List<VideoEntity> findVideoNotFavorite() {
        return videoDao.findVideoNotFavorite();
    }

    @Override
    public List<VideoEntity> findVideoByDate(String fromDate, String toDate) {
        try {
            Date fromDateD = new SimpleDateFormat("yyyy-MM-dd").parse(fromDate);
            Date toDateD = new SimpleDateFormat("yyyy-MM-dd").parse(toDate);
            return videoDao.findVideoByDate(fromDateD, toDateD);
        } catch (Exception e) {
           return null;
        }
    }
}
