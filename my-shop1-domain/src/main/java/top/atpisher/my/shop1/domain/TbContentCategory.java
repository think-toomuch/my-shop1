package top.atpisher.my.shop1.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import top.atpisher.my.shop1.commons.persistence.BaseEntity;

/**
 * @ClassName: TbContentCategory
 * @Author: l1957
 * @Date: 2021/5/15 17:16
 * @Description: TODO
 */
@Data
public class TbContentCategory extends BaseEntity {
    private Long parentId;
    private String name;
    private Integer status;
    private Integer sortOrder;
    private Boolean isParent;
}
