package com.hello.world.dto.condition;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author jarck-lou
 * @date 2019/02/27 14:17
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchUserDto {
  private Long id;

  private String name;

  private String phone;

  private Long roleId;

  private Long cityId;

  private Long companyId;
}
