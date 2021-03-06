package com.hello.world.dao;

import com.hello.world.dto.condition.SearchCompanyDto;
import com.hello.world.dto.create.CreateCompanyDto;
import com.hello.world.dto.result.CompanyDto;
import com.hello.world.entity.Company;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author jarck-lou
 * @date 2019/02/27 14:55
 **/
@Mapper
@Repository
public interface CompanyMapper {
  /**
   * 按ID删除
   *
   * @param id ID
   * @return 影响行数
   */
  int deleteByPrimaryKey(Integer id);

  /**
   * 创建公司
   *
   * @param company 公司
   * @return 影响的行数
   */
  Long createCompany(CreateCompanyDto company);

  /**
   * 更新
   *
   * @param company 公司
   * @return 影响行数
   */
  int update(Company company);

  /**
   * 按公司名查询
   *
   * @param name name
   * @return 公司列表
   */
  List<CompanyDto> searchWithName(String name);

  /**
   * 按城市ID查询
   *
   * @param cityId 城市ID
   * @return 公司列表
   */
  List<CompanyDto> searchWithCityId(Long cityId);

  /**
   * 按条件查询
   *
   * @param searchCompanyDto 查询条件
   * @return 公司列表
   */
  List<CompanyDto> searchCondition(SearchCompanyDto searchCompanyDto);

  /**
   * 按条件查询
   *
   * @param searchCompanyDto 查询条件
   * @return 公司列表
   */
  List<CompanyDto> searchCompanyAndCity(SearchCompanyDto searchCompanyDto);

  /**
   * 按ID查询
   *
   * @param id id
   * @return 公司
   */
  CompanyDto searchCompanyAndCityWithId(@Param("id") Long id);

  /**
   * 判断公司名称是否存在
   *
   * @param name name
   * @return boolean
   */
  @Select("select count(*) from company where name = #{name} and status = 1")
  int countByName(@Param("name") String name);
}
