package com.hello.world.dto.create;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author jarck-lou
 * @date 2019/02/28 09:41
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateRoleDto {
  private Long id;

  private String name;

  private String remark;
}
