package com.hello.world.dao;

import com.hello.world.dto.create.CreateRoleDto;
import com.hello.world.entity.Role;
import com.hello.world.dto.result.RoleDto;
import com.hello.world.dto.result.RolePermissionsDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author jarck-lou
 * @date 2019/02/27 15:03
 **/
@Mapper
@Repository
public interface RoleMapper {
  /**
   * 按ID删除
   *
   * @param id 角色ID
   * @return 影响行数
   */
  int deleteByPrimaryKey(Long id);

  /**
   * 创建角色
   *
   * @param role role
   * @return 影响的行数
   */
  Long insertRole(CreateRoleDto role);

  /**
   * 更新
   *
   * @param role role
   * @return 影响行数
   */
  int update(Role role);

  /**
   * 按ID查询
   *
   * @param id ID
   * @return 角色
   */
  RoleDto selectByPrimaryKey(Long id);

  /**
   * 查询所有角色
   *
   * @return 角色列表
   */
  List<RoleDto> findAll();

  /**
   * 通过角色名查询
   *
   * @param name 角色名
   * @return 角色列表
   */
  List<RoleDto> searchWithName(String name);

  /**
   * 通过用户ID查询
   *
   * @param userId 用户ID
   * @return 角色列表
   */
  List<RoleDto> searchWithUserId(@Param("userId") Long userId);

  /**
   * 按ID查询
   *
   * @param id 角色ID
   * @return 角色
   */
  RolePermissionsDto searchRoleAndPermissions(@Param("id") long id);

  /**
   * 判断角色名称是否存在
   *
   * @param name name
   * @return boolean
   */
  @Select("select count(*) from role where name = #{name} and status = 1")
  int countByName(@Param("name") String name);
}
