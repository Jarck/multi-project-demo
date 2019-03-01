package com.hello.world.dto.result;

import com.hello.world.enums.CompanyStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author jarck-lou
 * @date 2019/02/27 14:25
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompanyDto implements Serializable {
  private static final long serialVersionUID = -5184859552413778922L;

  private Long id;

  private String name;

  private String shortName;

  private String address;

  private String linkName;

  private String phone;

  private Long cityId;

  private CompanyStatusEnum status;

  private CityDto city;
}
