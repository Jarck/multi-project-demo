package com.hello.world.dao;

import com.hello.world.dto.condition.SearchCityDto;
import com.hello.world.dto.create.CreateCityDto;
import com.hello.world.dto.result.CityDto;
import com.hello.world.entity.City;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 城市DAO
 *
 * @author jarck-lou
 * @date 2019/02/26 16:16
 **/
@Mapper
@Repository
public interface CityMapper {
  /**
   * 按主键查询
   *
   * @param id id
   * @return 城市
   */
  CityDto selectByPrimaryKey(Long id);

  /**
   * 按主键删除
   *
   * @param id id
   * @return 影响行数
   */
  int deleteByPrimaryKey(Integer id);

  /**
   * 更新
   *
   * @param city 城市
   * @return 影响行数
   */
  int update(City city);

  /**
   * 创建城市
   *
   * @param city city
   * @return 影响的行数
   */
  Long insertCity(CreateCityDto city);

  /**
   * 通过城市名查询
   *
   * @param name name
   * @return 城市列表
   */
  List<CityDto> searchWithName(String name);

  /**
   * 按条件查询
   *
   * @param searchCityDto 查询条件
   * @return 城市列表
   */
  List<CityDto> searchCondition(SearchCityDto searchCityDto);

  /**
   * 判断城市名称是否存在
   *
   * @param name name
   * @return boolean
   */
  @Select("select count(*) from city where name = #{name}")
  int countByName(@Param("name") String name);
}
