package com.hello.world.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hello.world.dto.create.CreateRoleDto;
import com.hello.world.entity.Role;
import com.hello.world.dao.RoleMapper;
import com.hello.world.dto.PageDto;
import com.hello.world.dto.result.RoleDto;
import com.hello.world.dto.result.RolePermissionsDto;
import com.hello.world.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jarck-lou
 * @date 2019/02/27 15:59
 **/
@Service
public class RoleServiceImpl implements IRoleService {
  @Autowired
  private RoleMapper roleMapper;

  @Override
  public List<RoleDto> findAll() {
    return roleMapper.findAll();
  }

  @Override
  public PageInfo<RoleDto> findAll(PageDto pageDto) {
    PageHelper.startPage(pageDto.getPageNum(), pageDto.getPageSize());
    PageHelper.orderBy(pageDto.getOrderBy() + " " + (pageDto.isDesc() ? "desc" : "asc"));

    List<RoleDto> roleList = roleMapper.findAll();

    return new PageInfo<>(roleList);
  }

  @Override
  public RoleDto searchWithId(Long roleId) {
    return roleMapper.selectByPrimaryKey(roleId);
  }

  @Override
  public RolePermissionsDto searchRoleAndPermissions(Long roleId) {
    return roleMapper.searchRoleAndPermissions(roleId);
  }

  @Override
  public List<RoleDto> searchWithName(String name) {
    return roleMapper.searchWithName(name);
  }

  @Override
  public List<RoleDto> searchWithUserId(Long userId) {
    return roleMapper.searchWithUserId(userId);
  }

  @Override
  public RoleDto createRole(CreateRoleDto role) {
    roleMapper.insertRole(role);
    return roleMapper.selectByPrimaryKey(role.getId());
  }

  @Override
  public RoleDto updateRole(Role role) {
    roleMapper.update(role);

    return roleMapper.selectByPrimaryKey(role.getId());
  }

  @Override
  public boolean exitsRoleName(String name) {
    int count = roleMapper.countByName(name);

    return count > 0;
  }
}
