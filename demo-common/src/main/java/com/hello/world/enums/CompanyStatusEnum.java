package com.hello.world.enums;

/**
 * @author jarck-lou
 * @date 2019/02/26 11:36
 **/
public enum CompanyStatusEnum implements BaseEnum {
  ARCHIVED("禁用", 0),
  ACTIVE("正常", 1);

  private String desc;
  private int code;

  CompanyStatusEnum(String desc, int code) {
    this.desc = desc;
    this.code = code;
  }

  public String getDesc() {
    return this.desc;
  }

  public int getCode() {
    return this.code;
  }
}
