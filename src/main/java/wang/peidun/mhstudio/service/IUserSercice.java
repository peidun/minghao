package wang.peidun.mhstudio.service;

import wang.peidun.mhstudio.entity.User;

/**
 * @Author: wangpd
 * @Date: 2019-07-15 22:01
 */
public interface IUserSercice {
    User login(String username, String password);
}
