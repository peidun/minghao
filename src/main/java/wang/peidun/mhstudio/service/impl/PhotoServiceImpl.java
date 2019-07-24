package wang.peidun.mhstudio.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import wang.peidun.mhstudio.dao.PhotoMapper;
import wang.peidun.mhstudio.dto.Response;
import wang.peidun.mhstudio.entity.Photo;
import wang.peidun.mhstudio.enums.ResponseStatus;
import wang.peidun.mhstudio.service.IPhotoService;

import javax.annotation.Resource;
import java.io.File;
import java.util.List;

/**
 * @Author: wangpd
 * @Date: 2019-07-10 17:38
 */
@Service
public class PhotoServiceImpl implements IPhotoService {

    @Value("${upload.file.path}")
    private String filePath;

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

    @Override
    public Response delete(String id) {
        Photo photo = photoMapper.selectById(id);
        if (photo != null) {
            File file = new File(filePath, photo.getPath());
            if (file.exists()) {
                file.delete();
            }
            photoMapper.delete(id);
            return new Response(ResponseStatus.OK);
        } else {
            return new Response(ResponseStatus.DELETE_ERROR);
        }
    }
}
