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
 * @TableName schedule
 */
@TableName(value ="schedule")
@Data
@EqualsAndHashCode
public class Schedule implements Serializable {
    /**
     *
     */
    @TableId(type = IdType.AUTO)
    private Long scheduleID;

    /**
     *
     */
    private Long uid;

    /**
     *
     */
    private String scheduleTime;

    /**
     *
     */
    private String scheduleTitle;

    /**
     *
     */
    private String scheduleContent;

    /**
     *
     */
    private String craeteTime;

    private boolean finish;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

}
