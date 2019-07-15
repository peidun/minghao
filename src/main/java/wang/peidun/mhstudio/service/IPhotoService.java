package wang.peidun.mhstudio.service;

import wang.peidun.mhstudio.entity.Photo;

/**
 * @Author: wangpd
 * @Date: 2019-07-10 17:05
 */
public interface IPhotoService {
    Photo getById(String id);
    Photo getByEmailAndPassword(String email, String password);
    Photo getByPassword(String password);
}
