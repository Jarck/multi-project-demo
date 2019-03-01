package com.hello.world.service;

import com.github.pagehelper.PageInfo;
import com.hello.world.dto.PageDto;
import com.hello.world.dto.condition.SearchCityDto;
import com.hello.world.dto.create.CreateCityDto;
import com.hello.world.dto.result.CityDto;
import com.hello.world.entity.City;
import org.apache.ibatis.javassist.NotFoundException;

import java.util.List;

/**
 * @author jarck-lou
 * @date 2019/02/27 15:32
 **/
public interface ICityService {
  /**
   * find by id
   *
   * @param cityId city id
   * @return cityDto
   */
  CityDto searchWithId(Long cityId);

  /**
   * 通过城市名查询
   *
   * @param cityName 城市名
   * @return 城市列表
   */
  List<CityDto> searchWithName(String cityName);

  /**
   * 按条件查询
   *
   * @param searchCityDto 搜索条件
   * @return 城市列表
   */
  List<CityDto> searchWithCondition(SearchCityDto searchCityDto);

  /**
   * 分页查询
   * @param searchCityDto 搜索条件
   * @param pageDto 分页信息
   * @return 城市page
   */
  PageInfo<CityDto> searchWithCondition(SearchCityDto searchCityDto, PageDto pageDto);

  /**
   * 创建城市
   *
   * @param city 城市
   * @return 城市
   */
  CityDto createCity(CreateCityDto city);

  /**
   * 更新城市
   *
   * @param city 城市信息
   * @return 城市
   * @throws NotFoundException notFoundException
   */
  CityDto updateCity(City city) throws NotFoundException;

  /**
   * 判断城市名称是否存在
   *
   * @param name 城市名称
   * @return boolean
   */
  boolean exitsCityName(String name);
}
