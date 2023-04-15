package com.liang.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author Liang
 * @TableName note
 */
@TableName(value ="note")
@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document(indexName = "note",createIndex = true)
public class Note implements Serializable {
    /**
     *
     */
    @Id
    @Field(store = true, type = FieldType.Long)
    @TableId(type = IdType.AUTO)
    private Long noteId;

    /**
     *
     */
    @Field(store = true, type = FieldType.Long)
    private Long uid;

    /**
     *
     */
    @Field(store = true, type = FieldType.Long)
    private Long classificID;

    /**
     *
     */
    @Field(store = true, type = FieldType.Text, analyzer = "ik_smart")
    private String noteTitle;

    /**
     *
     */
    @Field(index = false,store = true, type = FieldType.Text)
    private String noteContent;
    @Field(store = true, type = FieldType.Text, analyzer = "ik_smart")
    private String noteHtml;

    /**
     *
     */
    @Field(index = false,store = true, type = FieldType.Keyword)
    private String craeteTime;

    /**
     *
     */
    @Field(index = false,store = true, type = FieldType.Keyword)
    private String modifiTime;

    @Field(index = false,store = true, type = FieldType.Integer)
    private int type;

    @TableField(exist = false)
    @Field(index = false,store = true, type = FieldType.Long)
    private static final long serialVersionUID = 1L;


}

