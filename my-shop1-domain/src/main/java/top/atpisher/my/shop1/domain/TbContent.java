package top.atpisher.my.shop1.domain;

import lombok.Data;
import top.atpisher.my.shop1.commons.persistence.BaseEntity;

/**
 * @ClassName: TbContent
 * @Author: l1957
 * @Date: 2021/5/17 08:32
 * @Description: TODO
 */
@Data
public class TbContent extends BaseEntity {
    private Long categoryId;
    private String title;
    private String subTitle;
    private String titleDesc;
    private String url;
    private String pic;
    private String pic2;
    private String content;
}
