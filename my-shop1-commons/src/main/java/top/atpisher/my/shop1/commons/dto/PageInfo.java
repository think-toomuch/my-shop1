package top.atpisher.my.shop1.commons.dto;

import top.atpisher.my.shop1.commons.persistence.BaseEntity;

import java.io.Serializable;
import java.util.List;

/**分页数据传输对象
 * @ClassName: PageInfo
 * @Author: l1957
 * @Date: 2021/5/5 19:45
 * @Description: TODO
 */
public class PageInfo<T extends BaseEntity> implements Serializable {
    private int draw;
    //记录总数
    private int recordsTotal;
    //过滤后的总记录数
    private int recordsFiltered;
    //要在表中显示的数据
    private List<T> data;
    //如果服务端发生了异常，你可以定义一个错误来描述服务器出了问题来通知用户该错误。
    private String error;

    public int getDraw() {
        return draw;
    }

    public void setDraw(int draw) {
        this.draw = draw;
    }

    public int getRecordsTotal() {
        return recordsTotal;
    }

    public void setRecordsTotal(int recordsTotal) {
        this.recordsTotal = recordsTotal;
    }

    public int getRecordsFiltered() {
        return recordsFiltered;
    }

    public void setRecordsFiltered(int recordsFiltered) {
        this.recordsFiltered = recordsFiltered;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
