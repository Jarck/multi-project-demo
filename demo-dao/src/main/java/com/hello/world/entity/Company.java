package com.hello.world.entity;

import com.hello.world.enums.CompanyStatusEnum;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 公司
 *
 * @author jarck-lou
 * @date 2019/02/26 11:25
 **/
@Data
public class Company implements Serializable {
  private static final long serialVersionUID = -31829302250346444L;

  private Long id;

  private String name;

  private String shortName;

  private String address;

  private String linkName;

  private String phone;

  private Long cityId;

  private CompanyStatusEnum status;

  private Date createdAt;

  private Date updatedAt;
}
