package com.hello.world.dto.result;

import com.hello.world.enums.RoleStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author jarck-lou
 * @date 2019/02/27 14:46
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleDto implements Serializable {
  private static final long serialVersionUID = -5158982595215261866L;

  private Long id;

  private String name;

  private RoleStatusEnum status;

  private String remark;
}
