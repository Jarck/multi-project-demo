package com.hello.world.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 城市
 *
 * @author jarck-lou
 * @date 2019/02/26 11:21
 **/
@Data
public class City implements Serializable {
  private static final long serialVersionUID = -1733370703250351269L;

  private Long id;

  private String name;

  private Date createdAt;

  private Date updatedAt;
}
