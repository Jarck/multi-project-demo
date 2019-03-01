package com.hello.world.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hello.world.dao.CityMapper;
import com.hello.world.dto.PageDto;
import com.hello.world.dto.condition.SearchCityDto;
import com.hello.world.dto.create.CreateCityDto;
import com.hello.world.dto.result.CityDto;
import com.hello.world.entity.City;
import com.hello.world.service.ICityService;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jarck-lou
 * @date 2019/02/27 15:32
 **/
@Service
public class CityServiceImpl implements ICityService {
  @Autowired
  private CityMapper cityMapper;

  @Override
  public CityDto searchWithId(Long cityId) {
    CityDto cityDto = cityMapper.selectByPrimaryKey(cityId);

    return cityDto;
  }

  @Override
  public List<CityDto> searchWithName(String cityName) {
    List<CityDto> cityList = cityMapper.searchWithName(cityName);

    return cityList;
  }

  @Override
  public List<CityDto> searchWithCondition(SearchCityDto searchCityDto) {
    List<CityDto> cityList = cityMapper.searchCondition(searchCityDto);

    return cityList;
  }

  @Override
  public PageInfo<CityDto> searchWithCondition(SearchCityDto searchCityDto, PageDto pageDto) {
    PageHelper.startPage(pageDto.getPageNum(), pageDto.getPageSize());
    PageHelper.orderBy(pageDto.getOrderBy() + " " + (pageDto.isDesc() ? "desc" : "asc"));

    List<CityDto> cityList = cityMapper.searchCondition(searchCityDto);

    PageInfo<CityDto> cityPageInfo = new PageInfo<>(cityList);

    return cityPageInfo;
  }

  @Override
  public CityDto createCity(CreateCityDto city) {
    long i = cityMapper.insertCity(city);
    return cityMapper.selectByPrimaryKey(city.getId());
  }

  @Override
  public CityDto updateCity(City city) throws NotFoundException {
    CityDto cityDto = cityMapper.selectByPrimaryKey(city.getId());

    if (cityDto == null) {
      throw new NotFoundException("城市不存在");
    }

    long i = cityMapper.update(city);

    return cityMapper.selectByPrimaryKey(city.getId());
  }

  @Override
  public boolean exitsCityName(String name) {
    int count = cityMapper.countByName(name);

    return count > 0;
  }
}
