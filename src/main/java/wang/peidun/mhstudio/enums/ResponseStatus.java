package wang.peidun.mhstudio.enums;

/**
 * @Author: wangpd
 * @Date: 2019-07-16 11:00
 */
public enum ResponseStatus {
    REGISTER_ERROR_UNAUTHORIZED(401, "Unauthorized"),
    OK(0, "success"),
    DOWNLOAD_ERROR(1, "download error"),
    DELETE_ERROR(1, "删除失败"),
    UPLOAD_FAIL(1, "上传失败");

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
