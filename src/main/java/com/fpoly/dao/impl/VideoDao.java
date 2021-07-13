package com.fpoly.dao.impl;

import com.fpoly.dao.IVideoDao;
import com.fpoly.entity.VideoEntity;

import java.util.List;

public class VideoDao extends AbstractDao<VideoEntity> implements IVideoDao {

    @Override
    public List<VideoEntity> findByUser(int idUser) {
        List<VideoEntity> listVideo = excuteQuery("findByUser", VideoEntity.class, idUser);
        System.out.println(listVideo.size());
        return listVideo == null ? null : listVideo;
    }
}
