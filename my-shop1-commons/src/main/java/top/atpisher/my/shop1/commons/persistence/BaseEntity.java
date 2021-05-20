package top.atpisher.my.shop1.commons.persistence;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName: BaseEntity
 * @Author: l1957
 * @Date: 2021/5/5 19:49
 * @Description: TODO
 */
@Data
public abstract class BaseEntity implements Serializable {
    private Long id;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date created;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updated;

}
