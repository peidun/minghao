package wang.peidun.mhstudio.service.impl;

import org.springframework.stereotype.Service;
import wang.peidun.mhstudio.dao.UserMapper;
import wang.peidun.mhstudio.entity.User;
import wang.peidun.mhstudio.service.IUserService;

import javax.annotation.Resource;

/**
 * @Author: wangpd
 * @Date: 2019-07-15 22:02
 */
@Service
public class UserServiceImpl implements IUserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public User login(String username, String password) {
        return userMapper.selectByUserAndPassword(username, password);
    }
}
