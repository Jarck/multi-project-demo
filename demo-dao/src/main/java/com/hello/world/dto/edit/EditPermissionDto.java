package com.hello.world.dto.edit;

import com.hello.world.enums.PermissionAvailableEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author jarck-lou
 * @date 2019/02/28 09:46
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EditPermissionDto {
  private Long id;

  private String name;

  private String permission;

  private String resourceType;

  private PermissionAvailableEnum available;
}
