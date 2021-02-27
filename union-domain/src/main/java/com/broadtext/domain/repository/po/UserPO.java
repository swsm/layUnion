package com.broadtext.domain.repository.po;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @author swsm
 * @date 2021/2/27
 */
@TableName("t_sys_user")
@Data
public class UserPO {
    
    private Integer id;
    
    private String name;
    
    private String workNo;
    
    private String truename;
    
    private String birthday;
    
    private Date createTime;
    
    private Date updateTime;
    
}
