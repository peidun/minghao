package wang.peidun.mhstudio.entity;

import lombok.Data;

/**
 * @Author: wangpd
 * @Date: 2019-07-03 20:08
 */
@Data
public class User {
    private String id;
    private String username;
    private String password;
    private String email;
    private int role;
}
