package com.hello.world.dto.create;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author jarck-lou
 * @date 2019/02/28 09:37
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreatePermissionDto {
  private Long id;

  private String name;

  private String permission;

  private String resourceType;
}
