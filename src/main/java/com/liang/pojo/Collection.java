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
 * @TableName collection
 */
@TableName(value ="collection")
@Data
public class Collection implements Serializable {
    /**
     *
     */
    @TableId(type = IdType.AUTO)
    private Long collectionID;

    /**
     *
     */
    private Long uid;

    /**
     *
     */
    private Long originalUID;

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
    private String collectionTime;

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
        Collection other = (Collection) that;
        return (this.getCollectionID() == null ? other.getCollectionID() == null : this.getCollectionID().equals(other.getCollectionID()))
            && (this.getUid() == null ? other.getUid() == null : this.getUid().equals(other.getUid()))
            && (this.getOriginalUID() == null ? other.getOriginalUID() == null : this.getOriginalUID().equals(other.getOriginalUID()))
            && (this.getClassificID() == null ? other.getClassificID() == null : this.getClassificID().equals(other.getClassificID()))
            && (this.getNoteTitle() == null ? other.getNoteTitle() == null : this.getNoteTitle().equals(other.getNoteTitle()))
            && (this.getNoteContent() == null ? other.getNoteContent() == null : this.getNoteContent().equals(other.getNoteContent()))
            && (this.getCollectionTime() == null ? other.getCollectionTime() == null : this.getCollectionTime().equals(other.getCollectionTime()))
            && (this.getModifiTime() == null ? other.getModifiTime() == null : this.getModifiTime().equals(other.getModifiTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCollectionID() == null) ? 0 : getCollectionID().hashCode());
        result = prime * result + ((getUid() == null) ? 0 : getUid().hashCode());
        result = prime * result + ((getOriginalUID() == null) ? 0 : getOriginalUID().hashCode());
        result = prime * result + ((getClassificID() == null) ? 0 : getClassificID().hashCode());
        result = prime * result + ((getNoteTitle() == null) ? 0 : getNoteTitle().hashCode());
        result = prime * result + ((getNoteContent() == null) ? 0 : getNoteContent().hashCode());
        result = prime * result + ((getCollectionTime() == null) ? 0 : getCollectionTime().hashCode());
        result = prime * result + ((getModifiTime() == null) ? 0 : getModifiTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", collectionID=").append(collectionID);
        sb.append(", uid=").append(uid);
        sb.append(", originalUID=").append(originalUID);
        sb.append(", classificID=").append(classificID);
        sb.append(", noteTitle=").append(noteTitle);
        sb.append(", noteContent=").append(noteContent);
        sb.append(", collectionTime=").append(collectionTime);
        sb.append(", modifiTime=").append(modifiTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
