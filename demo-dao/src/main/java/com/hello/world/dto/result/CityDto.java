package com.hello.world.dto.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author jarck-lou
 * @date 2019/02/27 14:24
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CityDto implements Serializable {
  private static final long serialVersionUID = 4967906632668717876L;

  private Long id;

  private String name;
}
