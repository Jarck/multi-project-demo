package com.hello.world.dto.edit;

import com.hello.world.enums.CompanyStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author jarck-lou
 * @date 2019/02/28 09:44
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EditCompanyDto {
  private Long id;

  private String name;

  private String shortName;

  private String address;

  private String linkName;

  private String phone;

  private Long cityId;

  private CompanyStatusEnum status;
}
