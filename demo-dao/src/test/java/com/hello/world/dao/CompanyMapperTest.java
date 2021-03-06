package com.hello.world.dao;

import com.hello.world.TestDaoConfiguration;
import com.hello.world.dto.condition.SearchCompanyDto;
import com.hello.world.dto.create.CreateCompanyDto;
import com.hello.world.dto.result.CompanyDto;
import com.ninja_squad.dbsetup.DbSetup;
import com.ninja_squad.dbsetup.DbSetupTracker;
import com.ninja_squad.dbsetup.Operations;
import com.ninja_squad.dbsetup.destination.DataSourceDestination;
import com.ninja_squad.dbsetup.operation.Operation;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.List;

/**
 * @author jarck-lou
 * @date 2019/03/04 10:45
 **/
@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = TestDaoConfiguration.class)
public class CompanyMapperTest {
  private static DbSetupTracker dbSetupTracker = new DbSetupTracker();

  @Autowired
  private CompanyMapper companyMapper;

  @Resource
  private DataSource dataSource;

  @Before
  public void setUp() {
    Operation operation = Operations.sequenceOf(
            Operations.deleteAllFrom("company", "city"),
            Operations.insertInto("city")
                    .columns("id", "name")
                    .values(1, "杭州")
                    .values(2, "苏州")
                    .build(),
            Operations.insertInto("company")
                    .columns("id", "name", "short_name", "city_id")
                    .values(1, "杭州xxx有限公司", "杭州xxx", 1)
                    .values(2, "苏州xxx有限公司", "苏州xxx", 2)
                    .values(3, "苏州xxx2有限公司", "苏州xxx2", 2)
                    .build()
    );

    DbSetup dbSetup = new DbSetup(new DataSourceDestination(dataSource), operation);
    dbSetupTracker.launchIfNecessary(dbSetup);
  }

  @Test
  public void testSearchWithName() {
    List<CompanyDto> companyList = companyMapper.searchWithName("杭州");

    Assert.assertEquals(companyList.size(), 1);
    Assert.assertEquals(companyList.get(0).getName(), "杭州xxx有限公司");
    Assert.assertEquals(companyList.get(0).getShortName(), "杭州xxx");
  }

  @Test
  public void testSearchWithCityId() {
    List<CompanyDto> companyList = companyMapper.searchWithCityId(2L);

    Assert.assertEquals(companyList.size(), 2);
    Assert.assertEquals(companyList.get(0).getName(),"苏州xxx有限公司");
    Assert.assertEquals(companyList.get(0).getShortName(), "苏州xxx");
  }

  @Test
  public void testSearchCondition() {
    SearchCompanyDto searchCompanyDto = new SearchCompanyDto();
    searchCompanyDto.setCityId(2L);
    searchCompanyDto.setName("苏州xxx2有限公司");
    List<CompanyDto> companyList = companyMapper.searchCondition(searchCompanyDto);

    Assert.assertEquals(companyList.size(), 1);
    Assert.assertEquals(companyList.get(0).getName(), "苏州xxx2有限公司");
    Assert.assertEquals(companyList.get(0).getShortName(), "苏州xxx2");
  }

  @Test
  @Transactional
  public void testCreateCompany() {
    CreateCompanyDto createCompanyDto = new CreateCompanyDto();
    createCompanyDto.setName("杭州xxx2有限公司");
    createCompanyDto.setShortName("杭州xxx2");
    createCompanyDto.setCityId(1L);
    companyMapper.createCompany(createCompanyDto);

    SearchCompanyDto searchCompanyDto = new SearchCompanyDto();
    searchCompanyDto.setCityId(1L);
    searchCompanyDto.setName("杭州xxx2有限公司");

    List<CompanyDto> companyList = companyMapper.searchCondition(searchCompanyDto);
    Assert.assertEquals(companyList.size(), 1);
    Assert.assertEquals(companyList.get(0).getName(), createCompanyDto.getName());
    Assert.assertEquals(companyList.get(0).getShortName(), createCompanyDto.getShortName());
    Assert.assertEquals(companyList.get(0).getCityId(), createCompanyDto.getCityId());
  }

  @Test
  public void testSearchCompanyAndCity() {
    SearchCompanyDto searchCompanyDto = new SearchCompanyDto();
    searchCompanyDto.setName("杭州xxx有限公司");

    List<CompanyDto> companyDtoList = companyMapper.searchCompanyAndCity(searchCompanyDto);
    Assert.assertEquals(companyDtoList.size(), 1);
    Assert.assertEquals(companyDtoList.get(0).getName(), "杭州xxx有限公司");
    Assert.assertEquals(companyDtoList.get(0).getCity().getName(), "杭州");
  }

  @Test
  public void testSearchCompanyAndCityWithId() {
    CompanyDto companyDto = companyMapper.searchCompanyAndCityWithId(1L);

    Assert.assertEquals(companyDto.getName(), "杭州xxx有限公司");
    Assert.assertEquals(companyDto.getCity().getName(), "杭州");
  }
}
