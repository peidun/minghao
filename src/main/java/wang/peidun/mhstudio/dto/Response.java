package wang.peidun.mhstudio.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import wang.peidun.mhstudio.enums.ResponseStatus;

import java.io.Serializable;

/**
 * @Author: wangpd
 * @Date: 2019-07-16 10:48
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response<T> implements Serializable {
    private T data;

    private int status;

    private String message;

    public Response() {
        this.status = ResponseStatus.OK.getStatus();
        this.message = ResponseStatus.OK.getMessage();
    }

    public Response(ResponseStatus responseStatus) {
        this.status = responseStatus.getStatus();
        this.message = responseStatus.getMessage();
    }

    public Response(int status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public Response(T data) {
        this();
        this.data = data;
    }
}
