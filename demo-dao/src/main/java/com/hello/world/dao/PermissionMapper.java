package com.hello.world.dao;

import com.hello.world.entity.Permission;
import com.hello.world.dto.result.PermissionDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author jarck-lou
 * @date 2019/02/27 15:01
 **/
@Mapper
@Repository
public interface PermissionMapper {
  /**
   * 按ID删除
   *
   * @param id id
   * @return 影响行数
   */
  int deleteByPrimaryKey(Long id);

  /**
   * 按ID查询
   *
   * @param id id
   * @return 权限
   */
  PermissionDto selectByPrimaryKey(Long id);

  /**
   * 更新
   *
   * @param permission permission
   * @return 影响行数
   */
  int update(Permission permission);

  /**
   * 创建权限
   *
   * @param permission permission
   * @return 影响的行数
   */
  Long insertPermission(Permission permission);

  /**
   * 查询所有权限
   *
   * @return 权限列表
   */
  List<PermissionDto> findAll();

  /**
   * 按权限名查询
   *
   * @param name 权限名
   * @return 权限列表
   */
  List<PermissionDto> searchWithName(String name);

  /**
   * 按角色ID查询
   *
   * @param roleId 角色ID
   * @return 权限列表
   */
  List<PermissionDto> searchWithRoleId(@Param("roleId") Long roleId);

  /**
   * 按用户ID查询
   *
   * @param userId 用户ID
   * @return 权限列表
   */
  List<PermissionDto> searchWithUserId(@Param("userId") Long userId);

  /**
   * 判断权限名称是否存在
   *
   * @param name name
   * @return boolean
   */
  @Select("select count(*) from permission where name = #{name} and available = 1")
  int countByName(@Param("name") String name);
}
