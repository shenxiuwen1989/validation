package com.sxw.model; /*
 * @(#)CascadeValication.java 1.0 2018/12/12
 * @Copyright:  Copyright © 2007-2018 ky-express.com.All Rights Reserved.
 * @Description: 
 * 
 * @Modification History:
 * @Date:        2018/12/12
 * @Author:      
 * @Version:     1.0.0.0
 * @Description: (Initialize)
 * @Reviewer:    
 * @Review Date: 
 */

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
@Data
public class CascadeValication {

    @NotBlank(message="公司不能为空")
    private String company;
    @NotNull(message="数据集不能为空")
    @Valid //如果是级联校验一定要加上 @Valid 否组 user里面的校验不会生效
    private List<User> data;
}
