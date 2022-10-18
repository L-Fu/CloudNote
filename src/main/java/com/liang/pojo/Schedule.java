package com.liang.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *
 * @author Liang
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
    private String scheduleDate;

    /**
     *
     */
    private String scheduleTitle;

    /**
     *
     */
    private String scheduleBeginTime;

    /**
     *
     */
    private String scheduleEndTime;
    private String scheduleContent;


    private boolean state;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;


}
