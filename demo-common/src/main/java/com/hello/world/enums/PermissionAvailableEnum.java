package com.hello.world.enums;

/**
 * @author jarck-lou
 * @date 2019/02/26 13:27
 **/
public enum PermissionAvailableEnum implements BaseEnum {
  UNAVAILABLE("禁用", 0),
  AVAILABLE("正常", 1);

  private String desc;
  private int code;

  PermissionAvailableEnum(String desc, int code) {
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
