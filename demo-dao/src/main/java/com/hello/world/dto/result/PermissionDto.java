package com.hello.world.dto.result;

import com.hello.world.enums.PermissionAvailableEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author jarck-lou
 * @date 2019/02/27 14:45
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PermissionDto implements Serializable {
  private static final long serialVersionUID = 3564388180984951028L;

  private Long id;

  private String name;

  private String permission;

  private String resourceType;

  private PermissionAvailableEnum available;
}
