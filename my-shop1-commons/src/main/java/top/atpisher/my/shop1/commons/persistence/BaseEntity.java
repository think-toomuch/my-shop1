package top.atpisher.my.shop1.commons.persistence;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName: BaseEntity
 * @Author: l1957
 * @Date: 2021/5/5 19:49
 * @Description: TODO
 */
public abstract class BaseEntity implements Serializable {
    private Long id;
    private Date created;
    private Date updated;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }
}
