package wang.peidun.mhstudio.service.impl;

import org.springframework.stereotype.Service;
import wang.peidun.mhstudio.dao.PhotoMapper;
import wang.peidun.mhstudio.entity.Photo;
import wang.peidun.mhstudio.service.IPhotoService;

import javax.annotation.Resource;

/**
 * @Author: wangpd
 * @Date: 2019-07-10 17:38
 */
@Service
public class PhotoServiceImpl implements IPhotoService {

    @Resource
    private PhotoMapper photoMapper;

    @Override
    public Photo getById(String id) {
        return photoMapper.selectById(id);
    }

    @Override
    public Photo getByEmailAndCOde(String email, String code) {
        Photo photo = null;
        if (email != null && code != null) {
            photo = photoMapper.selectByEmailAndCode(email, code);
        }
        return photo;
    }
}