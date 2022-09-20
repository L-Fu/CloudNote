package com.liang.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Liang
 */
@Data
@EqualsAndHashCode
public class User {
    @TableId(type = IdType.AUTO)
    private long uId;

    private String uName;
    private String uAccount;
    private String uPassword;
    private String icon;
    private String uDesc;
}
