package com.hello.world.dao;

import com.hello.world.entity.UserRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author jarck-lou
 * @date 2019/02/27 15:11
 **/
@Mapper
@Repository
public interface UserRoleMapper {
  /**
   * 创建用户对应的角色
   *
   * @param userId 用户ID
   * @param roleIds 角色IDs
   * @return 影响行数
   */
  int createUserRoles(@Param("userID") Long userId, @Param("roleIds") List<Long> roleIds);

  /**
   * 通过用户ID查询
   *
   * @param userId 用户ID
   * @return 用户角色列表
   */
  @Cacheable(key = "#p0")
  List<UserRole> searchWithUserId(Long userId);
}
