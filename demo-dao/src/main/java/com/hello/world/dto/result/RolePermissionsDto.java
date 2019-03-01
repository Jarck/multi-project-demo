package com.hello.world.dto.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author jarck-lou
 * @date 2019/02/27 14:47
 **/
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class RolePermissionsDto extends RoleDto {
  private List<PermissionDto> permissions;
}
