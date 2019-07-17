package wang.peidun.mhstudio.service;

import wang.peidun.mhstudio.entity.Photo;

/**
 * @Author: wangpd
 * @Date: 2019-07-10 17:05
 */
public interface IPhotoService {
    int save(Photo photo);
    Photo getById(String id);
    Photo getByPassword(String password);
}
