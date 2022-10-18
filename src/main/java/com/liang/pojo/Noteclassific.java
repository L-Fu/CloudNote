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
 * @TableName noteclassific
 */
@TableName(value ="noteclassific")
@Data
@EqualsAndHashCode
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
//    private int type;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;


}
