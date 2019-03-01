package com.hello.world;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author jarck-lou
 * @date 2019/03/01 14:00
 **/
@SpringBootApplication
@SuppressWarnings("checkstyle:HideUtilityClassConstructor")
public class DaoApplication {
  /**
   * main
   * @param args args
   */
  public static void main(String[] args) {
    SpringApplication.run(DaoApplication.class, args);
  }
}
