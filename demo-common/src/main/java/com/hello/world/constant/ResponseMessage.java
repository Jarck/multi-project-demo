package com.hello.world.constant;

/**
 * @author jarck-lou
 * @date 2019/02/26 13:42
 **/
public final class ResponseMessage {
  private ResponseMessage() {

  }

  public static final String SUCCESS = "success";
  public static final String ARGUMENTS_ERROR = "请求参数错误";
  public static final String UNAUTHENTICATED = "Token无效";
  public static final String FORBIDDEN = "无权限访问";
  public static final String UNAUTHORIZED = "Unauthorized";
}
