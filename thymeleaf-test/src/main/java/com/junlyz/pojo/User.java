package com.junlyz.pojo;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Author: Administrator
 * @Date: 2019/5/7 0007 21:15
 * @Description:
 */
@Data
@Accessors(chain = true)
public class User {

    private String name;

    private Integer age;
}
