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
 * @TableName recyclebin
 */
@TableName(value ="recyclebin")
@Data
public class Recyclebin implements Serializable {
    /**
     *
     */

    private Long noteID;

    /**
     *
     */
    @TableId(type = IdType.AUTO)
    private Long recycleID;

    /**
     *
     */
    private Long uid;

    /**
     *
     */
    private Long classificID;

    /**
     *
     */
    private String noteTitle;

    /**
     *
     */
    private String noteContent;

    /**
     *
     */
    private String craeteTime;

    /**
     *
     */
    private String modifiTime;

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
        Recyclebin other = (Recyclebin) that;
        return (this.getNoteID() == null ? other.getNoteID() == null : this.getNoteID().equals(other.getNoteID()))
            && (this.getRecycleID() == null ? other.getRecycleID() == null : this.getRecycleID().equals(other.getRecycleID()))
            && (this.getUid() == null ? other.getUid() == null : this.getUid().equals(other.getUid()))
            && (this.getClassificID() == null ? other.getClassificID() == null : this.getClassificID().equals(other.getClassificID()))
            && (this.getNoteTitle() == null ? other.getNoteTitle() == null : this.getNoteTitle().equals(other.getNoteTitle()))
            && (this.getNoteContent() == null ? other.getNoteContent() == null : this.getNoteContent().equals(other.getNoteContent()))
            && (this.getCraeteTime() == null ? other.getCraeteTime() == null : this.getCraeteTime().equals(other.getCraeteTime()))
            && (this.getModifiTime() == null ? other.getModifiTime() == null : this.getModifiTime().equals(other.getModifiTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getNoteID() == null) ? 0 : getNoteID().hashCode());
        result = prime * result + ((getRecycleID() == null) ? 0 : getRecycleID().hashCode());
        result = prime * result + ((getUid() == null) ? 0 : getUid().hashCode());
        result = prime * result + ((getClassificID() == null) ? 0 : getClassificID().hashCode());
        result = prime * result + ((getNoteTitle() == null) ? 0 : getNoteTitle().hashCode());
        result = prime * result + ((getNoteContent() == null) ? 0 : getNoteContent().hashCode());
        result = prime * result + ((getCraeteTime() == null) ? 0 : getCraeteTime().hashCode());
        result = prime * result + ((getModifiTime() == null) ? 0 : getModifiTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", noteID=").append(noteID);
        sb.append(", recycleID=").append(recycleID);
        sb.append(", uid=").append(uid);
        sb.append(", classificID=").append(classificID);
        sb.append(", noteTitle=").append(noteTitle);
        sb.append(", noteContent=").append(noteContent);
        sb.append(", craeteTime=").append(craeteTime);
        sb.append(", modifiTime=").append(modifiTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
