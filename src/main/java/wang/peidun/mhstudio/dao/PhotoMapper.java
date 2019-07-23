package wang.peidun.mhstudio.dao;

import wang.peidun.mhstudio.entity.Photo;

import java.util.List;

/**
 * @Author: wangpd
 * @Date: 2019-07-10 16:05
 */
public interface PhotoMapper {
    int save(Photo photo);
    int update(Photo photo);
    Photo selectById(String id);
    Photo getByPassword(String password);
    List<Photo> selectAll();
}
