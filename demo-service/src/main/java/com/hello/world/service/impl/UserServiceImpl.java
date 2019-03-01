package com.hello.world.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hello.world.dto.create.CreateUserDto;
import com.hello.world.dto.edit.EditUserDto;
import com.hello.world.entity.User;
import com.hello.world.dao.RoleMapper;
import com.hello.world.dao.UserMapper;
import com.hello.world.dao.UserRoleMapper;
import com.hello.world.dto.PageDto;
import com.hello.world.dto.condition.SearchUserDto;
import com.hello.world.dto.result.UserDto;
import com.hello.world.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author jarck-lou
 * @date 2019/02/27 16:02
 **/
@Service
public class UserServiceImpl implements IUserService {
  @Value("${secret_key}")
  private String secretKey;

  @Autowired
  private UserMapper userMapper;

  @Autowired
  private UserRoleMapper userRoleMapper;

  @Autowired
  private RoleMapper roleMapper;

  @Override
  public List<UserDto> findAll() {
    return userMapper.findAll();
  }

  @Override
  public UserDto searchWithId(Long userId) {
    UserDto userDto = userMapper.selectByPrimaryKey(userId);

    return userDto;
  }

  @Override
  public UserDto searchWithPhone(String phone) {
    UserDto userDto = userMapper.selectByPhone(phone);

    return userDto;
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

    PageInfo<UserDto> userDtoPageInfo = new PageInfo<>(userList);

    return userDtoPageInfo;
  }

  @Override
  public List<UserDto> searchUserAndCityAndCompanyAndRoles(SearchUserDto searchUserDto) {
    List<UserDto> userList = userMapper.searchUserAndCityAndCompanyAndRoles(searchUserDto);

    return  userList;
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
    User user = new User();
    user.setName(createUserDto.getName());
    user.setPhone(createUserDto.getPhone());
    user.setCityId(createUserDto.getCityId());
    user.setCompanyId(createUserDto.getCompanyId());

    userMapper.insertUser(user);

    // 设置用户角色
    if (createUserDto.getRoleIds() != null && !createUserDto.getRoleIds().isEmpty()) {
      userRoleMapper.createUserRoles(user.getId(), createUserDto.getRoleIds());
    }

    return userMapper.searchUserAndCityAndCompanyAndRolesWithId(user.getId());
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
    UserDto userDto = userMapper.searchUserAndCityAndCompanyAndRolesWithId(editUserDto.getId());

    return userDto;
  }
}
