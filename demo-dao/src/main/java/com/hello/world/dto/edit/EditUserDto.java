package com.hello.world.dto.edit;

import com.hello.world.enums.UserStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author jarck-lou
 * @date 2019/02/28 09:49
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EditUserDto {
  private Long id;

  private String name;

  private String phone;

  private Long cityId;

  private Long companyId;

  private UserStatusEnum status;

  private List<Long> roleIds;
}
