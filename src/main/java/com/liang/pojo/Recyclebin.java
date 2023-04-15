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
 * @TableName recyclebin
 */
@TableName(value ="recyclebin")
@Data
@EqualsAndHashCode
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

    private int type;

    private String noteHtml;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

}
