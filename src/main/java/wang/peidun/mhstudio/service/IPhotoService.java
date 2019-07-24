package wang.peidun.mhstudio.service;

import wang.peidun.mhstudio.dto.Response;
import wang.peidun.mhstudio.entity.Photo;

import java.util.List;

/**
 * @Author: wangpd
 * @Date: 2019-07-10 17:05
 */
public interface IPhotoService {
    int save(Photo photo);
    Photo getById(String id);
    Photo getByPassword(String password);
    List<Photo> findAll();
    Response delete(String id);
}
