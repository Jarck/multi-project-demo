package com.hello.world.dto.result;

import com.hello.world.enums.UserStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @author jarck-lou
 * @date 2019/02/27 14:22
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto implements Serializable {
  private static final long serialVersionUID = 7044217244225275316L;

  private Long id;

  private String name;

  private String phone;

  private Long cityId;

  private Long companyId;

  private UserStatusEnum status;

  private CityDto city;

  private CompanyDto company;

  private List<RoleDto> roles;
}
