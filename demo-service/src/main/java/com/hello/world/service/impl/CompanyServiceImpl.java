package com.hello.world.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hello.world.dao.CompanyMapper;
import com.hello.world.dto.PageDto;
import com.hello.world.dto.condition.SearchCompanyDto;
import com.hello.world.dto.create.CreateCompanyDto;
import com.hello.world.dto.result.CompanyDto;
import com.hello.world.entity.Company;
import com.hello.world.service.ICompanyService;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jarck-lou
 * @date 2019/02/27 15:52
 **/
@Service
public class CompanyServiceImpl implements ICompanyService {
  @Autowired
  private CompanyMapper companyMapper;

  @Override
  public CompanyDto searchWithId(Long companyId) {
    return companyMapper.searchCompanyAndCityWithId(companyId);
  }

  @Override
  public CompanyDto searchCompanyAndCityWithId(Long companyId) {
    return companyMapper.searchCompanyAndCityWithId(companyId);
  }

  @Override
  public List<CompanyDto> searchWithName(String name) {
    return companyMapper.searchWithName(name);
  }

  @Override
  public List<CompanyDto> searchWithCityId(Long cityId) {
    return companyMapper.searchWithCityId(cityId);
  }

  @Override
  public List<CompanyDto> searchCondition(SearchCompanyDto searchCompanyDto) {
    return companyMapper.searchCompanyAndCity(searchCompanyDto);
  }

  @Override
  public PageInfo<CompanyDto> searchCondition(SearchCompanyDto searchCompanyDto, PageDto pageDto) {
    PageHelper.startPage(pageDto.getPageNum(), pageDto.getPageSize());
    PageHelper.orderBy(pageDto.getOrderBy() + " " + (pageDto.isDesc() ? "desc" : "acs"));

    List<CompanyDto> companyList = companyMapper.searchCompanyAndCity(searchCompanyDto);

    return new PageInfo<>(companyList);
  }

  @Override
  public CompanyDto createCompany(CreateCompanyDto company) {
    companyMapper.createCompany(company);

    return companyMapper.searchCompanyAndCityWithId(company.getId());
  }

  @Override
  public CompanyDto updateCompany(Company company) throws NotFoundException {
    CompanyDto companyDto = companyMapper.searchCompanyAndCityWithId(company.getId());

    if (companyDto == null) {
      throw new NotFoundException("公司不存在");
    }

    companyMapper.update(company);

    return companyMapper.searchCompanyAndCityWithId(company.getId());
  }

  @Override
  public boolean exitsCompanyName(String name) {
    int count = companyMapper.countByName(name);

    return count > 0;
  }
}
