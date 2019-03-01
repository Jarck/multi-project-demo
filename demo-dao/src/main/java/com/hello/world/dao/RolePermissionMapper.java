package com.hello.world.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author jarck-lou
 * @date 2019/02/27 15:04
 **/
@Mapper
@Repository
public interface RolePermissionMapper {
  /**
   * 按角色ID删除
   *
   * @param roleId 角色ID
   * @return 影响行数
   */
  @Delete("DELETE * FROM role_permission WHERE role_id = #{roleId}")
  int deleteByRoleId(Long roleId);

  /**
   * 创建角色对应权限
   *
   * @param roleId 角色ID
   * @param permissionIds 权限IDs
   * @return 影响行数
   */
  int createRolePermissions(@Param("roleId") Long roleId, @Param("permissionIds") List<Long> permissionIds);
}
