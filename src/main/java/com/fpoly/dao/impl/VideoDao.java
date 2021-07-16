package com.fpoly.dao.impl;

import com.fpoly.dao.IVideoDao;
import com.fpoly.entity.VideoEntity;

import java.util.Date;
import java.util.List;

public class VideoDao extends AbstractDao<VideoEntity> implements IVideoDao {

    @Override
    public List<VideoEntity> findByUser(int idUser) {
        List<VideoEntity> listVideo = excuteQuery("findByUser", VideoEntity.class, idUser);
        return listVideo == null ? null : listVideo;
    }

    @Override
    public List<VideoEntity> findVideoFavoritesByKeyword(String keyword) {
        List<VideoEntity> listVideo = excuteQuery("findVideoFavoritesByKeyword", VideoEntity.class, keyword);
        return listVideo == null ? null : listVideo;
    }

    @Override
    public List<VideoEntity> findVideoFavorite() {
        List<VideoEntity> listVideo = excuteQuery("filterVideoFavorite", VideoEntity.class);
        return listVideo == null ? null : listVideo;
    }

    @Override
    public List<VideoEntity> findVideoNotFavorite() {
        List<VideoEntity> listVideo = excuteQuery("filterVideoNotFavorite", VideoEntity.class);
        return listVideo == null ? null : listVideo;
    }

    @Override
    public List<VideoEntity> findVideoByDate(Date fromDate, Date toDate) {
        List<VideoEntity> listVideo = excuteQuery("findVideoByDate", VideoEntity.class, fromDate, toDate);
        return listVideo == null ? null : listVideo;
    }
}
