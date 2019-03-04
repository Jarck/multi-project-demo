package com.hello.world.dao;

import com.hello.world.dto.create.CreateUserDto;
import com.hello.world.entity.User;
import com.hello.world.dto.condition.SearchUserDto;
import com.hello.world.dto.result.UserDto;
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
public interface UserMapper {
  /**
   * 按ID查询
   *
   * @param id ID
   * @return 用户
   */
  UserDto selectByPrimaryKey(Long id);

  /**
   * 按ID删除
   *
   * @param id ID
   * @return 影响行数
   */
  int deleteByPrimaryKey(Long id);

  /**
   * 创建用户
   *
   * @param user user
   * @return 影响的行数
   */
  Long insertUser(CreateUserDto user);

  /**
   * 更新
   *
   * @param user user
   * @return 影响行数
   */
  int update(User user);

  /**
   * 所有用户
   *
   * @return 用户列表
   */
  List<UserDto> findAll();

  /**
   * 按手机号查询用户
   *
   * @param phone phone
   * @return 用户
   */
  @Cacheable("users")
  UserDto selectByPhone(String phone);

  /**
   * 按条件查询
   *
   * @param searchUserDto searchUserDto
   * @return 用户列表
   */
  List<UserDto> searchCondition(SearchUserDto searchUserDto);

  /**
   * 按条件查询
   *
   * @param searchUserDto searchUserDto
   * @return 用户列表
   */
  List<UserDto> searchUserAndCityAndCompanyAndRoles(SearchUserDto searchUserDto);

  /**
   * 按ID查询
   *
   * @param id id
   * @return 用户
   */
  UserDto searchUserAndCityAndCompanyAndRolesWithId(@Param("id") Long id);

  /**
   * 按手机号查询
   *
   * @param phone phone
   * @return 用户
   */
  UserDto searchUserAndCityAndCompanyAndRolesWithPhone(@Param("phone") String phone);
}
