package com.liang.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @TableName note
 */
@TableName(value ="note")
@Data
@EqualsAndHashCode
public class Note implements Serializable {
    /**
     *
     */
    @TableId(type = IdType.AUTO)
    private Long noteId;

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

    private String noteHtml;

    /**
     *
     */
    private String craeteTime;

    /**
     *
     */
    private String modifiTime;

    private int type;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;


}

