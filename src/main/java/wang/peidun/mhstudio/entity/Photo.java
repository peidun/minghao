package wang.peidun.mhstudio.entity;

import lombok.Data;

import java.util.Date;

/**
 * @Author: wangpd
 * @Date: 2019-07-10 15:53
 */
@Data
public class Photo {
    private String id;
    private String remark;
    private String email;
    private String fileName;
    private String password;
    private Date uploadTime;
    private int status;
}
