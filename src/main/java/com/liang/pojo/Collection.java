package com.liang.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *
 * @TableName collection
 */
@TableName(value ="collection")
@Data
@EqualsAndHashCode
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
    private int type;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;


}
