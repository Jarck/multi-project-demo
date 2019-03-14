package com.hello.world.service.impl;

import com.hello.world.dto.create.CreatePermissionDto;
import com.hello.world.entity.Permission;
import com.hello.world.service.IPermissionService;
import com.hello.world.dao.PermissionMapper;
import com.hello.world.dto.result.PermissionDto;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jarck-lou
 * @date 2019/02/27 15:56
 **/
@Service
public class PermissionServiceImpl implements IPermissionService {
  @Autowired
  private PermissionMapper permissionMapper;

  @Override
  public List<PermissionDto> findAll() {
    return permissionMapper.findAll();
  }

  @Override
  public PermissionDto searchWithId(Long permissionId) {
    return permissionMapper.selectByPrimaryKey(permissionId);
  }

  @Override
  public List<PermissionDto> searchWithName(String name) {
    return permissionMapper.searchWithName(name);
  }

  @Override
  public List<PermissionDto> searchWithRoleId(Long roleId) {
    return permissionMapper.searchWithRoleId(roleId);
  }

  @Override
  public List<PermissionDto> searchWithUserId(Long userId) {
    return permissionMapper.searchWithUserId(userId);
  }

  @Override
  public PermissionDto createPermission(CreatePermissionDto permission) {
    permissionMapper.insertPermission(permission);
    return permissionMapper.selectByPrimaryKey(permission.getId());
  }

  @Override
  public PermissionDto updatePermission(Permission permission) throws NotFoundException {
    PermissionDto permissionDto = permissionMapper.selectByPrimaryKey(permission.getId());

    if (permissionDto == null) {
      throw new NotFoundException("权限不存在");
    }

    permissionMapper.update(permission);
    PermissionDto permissionDtoUpdate = permissionMapper.selectByPrimaryKey(permission.getId());
    return permissionDtoUpdate;
  }

  @Override
  public boolean exitsPermissionName(String name) {
    int count = permissionMapper.countByName(name);

    return count > 0;
  }
}
