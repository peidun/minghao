package wang.peidun.mhstudio.enums;

/**
 * @Author: wangpd
 * @Date: 2019-07-17 14:12
 */
public enum MySessionAttribute {

    LOGIN_USER("loginUser");

    private String key;
    MySessionAttribute(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }
}
