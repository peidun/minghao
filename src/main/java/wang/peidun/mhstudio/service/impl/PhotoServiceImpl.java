package wang.peidun.mhstudio.service.impl;

import org.springframework.stereotype.Service;
import wang.peidun.mhstudio.dao.PhotoMapper;
import wang.peidun.mhstudio.entity.Photo;
import wang.peidun.mhstudio.service.IPhotoService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: wangpd
 * @Date: 2019-07-10 17:38
 */
@Service
public class PhotoServiceImpl implements IPhotoService {

    @Resource
    private PhotoMapper photoMapper;

    @Override
    public int save(Photo photo) {
        return photoMapper.save(photo);
    }

    @Override
    public Photo getById(String id) {
        return photoMapper.selectById(id);
    }

    @Override
    public Photo getByPassword(String password) {
        Photo photo = null;
        if (password != null) {
            photo = photoMapper.getByPassword(password);
        }
        return photo;
    }

    @Override
    public List<Photo> findAll() {
        return photoMapper.selectAll();
    }
}
