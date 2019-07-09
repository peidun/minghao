package wang.peidun.mhstudio.dao;

import wang.peidun.mhstudio.entity.User;

import java.util.List;

/**
 * @Author: wangpd
 * @Date: 2019-07-03 21:05
 */
public interface UserMapper {
    /**
     * 新增用户
     *
     * @param user
     * @return
     */
    int save(User user);

    /**
     * 更新用户信息
     *
     * @param user
     * @return
     */
    int update(User user);

    /**
     * 根据id删除
     *
     * @param id
     * @return
     */
    int deleteById(int id);

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    User selectById(int id);

    /**
     * 查询所有用户信息
     *
     * @return
     */
    List<User> selectAll();
}
