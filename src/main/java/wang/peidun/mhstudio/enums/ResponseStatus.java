package wang.peidun.mhstudio.enums;

/**
 * @Author: wangpd
 * @Date: 2019-07-16 11:00
 */
public enum ResponseStatus {
    REGISTER_ERROR_UNAUTHORIZED(401, "Unauthorized"),
    OK(0, "success"),
    DOWNLOAD_ERROR(1, "download error");

    private int status;
    private String message;

    ResponseStatus(int status, String message) {
        this.status = status;
        this.message = message;
    }
    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

}
