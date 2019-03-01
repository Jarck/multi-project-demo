package com.hello.world.dto.edit;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author jarck-lou
 * @date 2019/02/28 09:43
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EditCityDto {
  private Long id;

  private String name;
}
