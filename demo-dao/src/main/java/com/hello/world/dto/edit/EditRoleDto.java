package com.hello.world.dto.edit;

import com.hello.world.enums.RoleStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author jarck-lou
 * @date 2019/02/28 09:47
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EditRoleDto {
  private Long id;

  private String name;

  private RoleStatusEnum status;

  private String remark;

  private List<Long> permissionIds;
}
