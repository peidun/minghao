package wang.peidun.mhstudio.dto;

import lombok.Data;

import java.util.List;

/**
 * @author ：Zcw
 * @date ：2019/3/11 17:13
 * @description：分页基础参数，可改造成抽象类，用实体类继承来实现查询功能
 */
@Data
public class PageParam<T> {

    public static final int DEFAULT_PAGE_NUM = 1;

    public static final int DEFAULT_PAGE_SIZE = 5;

    private Integer pageNum;

    private Integer pageSize;

    /**
     * 拓展字段1
     */
    private String param1;

    /**
     * 拓展字段2
     */
    private String param2;

    /**
     * 拓展字段3
     */
    private String param3;
    /**
     * 拓展字段4
     */
    private String param4;

    /**
     * 拓展字段5
     */
    private T param5;

    /**
     * 拓展字段6
     */
    private T param6;

    /**
     * 拓展时间条件查询
     */
    private Long fromTime;

    private Long toTime;

    private T searchEntity;

    private List<T> content;

    private int totalElements;

    public PageParam() {
        if (null == this.pageNum)
            this.pageNum = DEFAULT_PAGE_NUM;
        if (null == this.pageSize)
            this.pageSize = DEFAULT_PAGE_SIZE;
    }

    public void setContent(List<T> list) {
        if (null == list || list.isEmpty()) {
            this.content = null;
            this.totalElements = 0;
        } else {
            int total = list.size();
            this.totalElements = total;

            // 当pageSize 为最大的int值，默认返回全部结果
            if (pageSize == Integer.MAX_VALUE) {
                this.content = list;
            }

            int currIdx = (pageNum > 1 ? (pageNum - 1) * pageSize : 0);
            if (total >= currIdx) {
                this.content = list.subList(currIdx, currIdx + pageSize > total ? total : currIdx + pageSize);
            }
        }
    }

}
