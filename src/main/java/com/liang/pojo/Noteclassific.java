package com.liang.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

/**
 *
 * @TableName noteclassific
 */
@TableName(value ="noteclassific")
@Data
public class Noteclassific implements Serializable {
    /**
     *
     */
    @TableId(type = IdType.AUTO)
    private Long classificID;

    /**
     *
     */
    private Long uid;

    /**
     *
     */
    private String classifiName;

    /**
     *
     */
    private String classifiDesc;

    /**
     *
     */
    private String createTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Noteclassific other = (Noteclassific) that;
        return (this.getClassificID() == null ? other.getClassificID() == null : this.getClassificID().equals(other.getClassificID()))
            && (this.getUid() == null ? other.getUid() == null : this.getUid().equals(other.getUid()))
            && (this.getClassifiName() == null ? other.getClassifiName() == null : this.getClassifiName().equals(other.getClassifiName()))
            && (this.getClassifiDesc() == null ? other.getClassifiDesc() == null : this.getClassifiDesc().equals(other.getClassifiDesc()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getClassificID() == null) ? 0 : getClassificID().hashCode());
        result = prime * result + ((getUid() == null) ? 0 : getUid().hashCode());
        result = prime * result + ((getClassifiName() == null) ? 0 : getClassifiName().hashCode());
        result = prime * result + ((getClassifiDesc() == null) ? 0 : getClassifiDesc().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", classificID=").append(classificID);
        sb.append(", uid=").append(uid);
        sb.append(", classifiName=").append(classifiName);
        sb.append(", classifiDesc=").append(classifiDesc);
        sb.append(", createTime=").append(createTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
