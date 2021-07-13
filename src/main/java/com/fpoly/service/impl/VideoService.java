package com.fpoly.service.impl;

import com.fpoly.dao.impl.VideoDao;
import com.fpoly.entity.VideoEntity;
import com.fpoly.service.IVideoService;

import javax.inject.Inject;
import java.util.List;

public class VideoService implements IVideoService {
    @Inject
    private VideoDao videoDao;

    @Override
    public List<VideoEntity> findByUser(int id) {
        return videoDao.findByUser(id);
    }
}
