package wang.peidun.mhstudio.entity;

import lombok.Data;

/**
 * @Author: wangpd
 * @Date: 2019-07-03 21:16
 */
@Data
public class Contact {
    private String id;
    private String username;
    private String email;
    private String phone;
    private String message;
}
