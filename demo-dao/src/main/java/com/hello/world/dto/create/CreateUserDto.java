package com.hello.world.dto.create;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author jarck-lou
 * @date 2019/02/28 09:42
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserDto {
  private  Long id;

  private String name;

  private String phone;

  private Long cityId;

  private Long companyId;

  private List<Long> roleIds;
}
