package com.hello.world.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hello.world.dao.UserMapper;
import com.hello.world.dao.UserRoleMapper;
import com.hello.world.dto.PageDto;
import com.hello.world.dto.condition.SearchUserDto;
import com.hello.world.dto.create.CreateUserDto;
import com.hello.world.dto.edit.EditUserDto;
import com.hello.world.dto.result.UserDto;
import com.hello.world.entity.User;
import com.hello.world.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author jarck-lou
 * @date 2019/02/27 16:02
 **/
@Service
public class UserServiceImpl implements IUserService {
  @Autowired
  private UserMapper userMapper;

  @Autowired
  private UserRoleMapper userRoleMapper;

  @Override
  public List<UserDto> findAll() {
    return userMapper.findAll();
  }

  @Override
  public UserDto searchWithId(Long userId) {
    return userMapper.selectByPrimaryKey(userId);
  }

  @Override
  public UserDto searchWithPhone(String phone) {
    return userMapper.selectByPhone(phone);
  }

  @Override
  public UserDto getUserByPhone(String phone) {
    return userMapper.selectByPhone(phone);
  }

  @Override
  public List<UserDto> searchWithCondition(SearchUserDto searchUserDto) {
    return userMapper.searchCondition(searchUserDto);
  }

  @Override
  public PageInfo<UserDto> searchUserAndCityAndCompanyAndRoles(SearchUserDto searchUserDto, PageDto pageDto) {
    PageHelper.startPage(pageDto.getPageNum(), pageDto.getPageSize());
    PageHelper.orderBy(pageDto.getOrderBy() + " " + (pageDto.isDesc() ? "desc" : "asc"));

    List<UserDto> userList = userMapper.searchUserAndCityAndCompanyAndRoles(searchUserDto);

    return new PageInfo<>(userList);
  }

  @Override
  public List<UserDto> searchUserAndCityAndCompanyAndRoles(SearchUserDto searchUserDto) {
    return userMapper.searchUserAndCityAndCompanyAndRoles(searchUserDto);
  }

  @Override
  public UserDto searchUserAndCityAndCompanyAndRolesWithId(Long id) {
    return userMapper.searchUserAndCityAndCompanyAndRolesWithId(id);
  }

  @Override
  public UserDto searchUserAndCityAndCompanyAndRolesWithPhone(String phone) {
    return userMapper.searchUserAndCityAndCompanyAndRolesWithPhone(phone);
  }

  @Override
  @Transactional
  public UserDto createUser(CreateUserDto createUserDto) {
    userMapper.insertUser(createUserDto);

    // 设置用户角色
    if (createUserDto.getRoleIds() != null && !createUserDto.getRoleIds().isEmpty()) {
      userRoleMapper.createUserRoles(createUserDto.getId(), createUserDto.getRoleIds());
    }

    return userMapper.searchUserAndCityAndCompanyAndRolesWithId(createUserDto.getId());
  }

  @Override
  public UserDto updateUser(EditUserDto editUserDto) {
    User user = new User();
    user.setId(editUserDto.getId());
    user.setName(editUserDto.getName());
    user.setPhone(editUserDto.getPhone());
    user.setCityId(editUserDto.getCityId());
    user.setCompanyId(editUserDto.getCompanyId());
    user.setStatus(editUserDto.getStatus());

    userMapper.update(user);

    return userMapper.searchUserAndCityAndCompanyAndRolesWithId(editUserDto.getId());
  }
}
