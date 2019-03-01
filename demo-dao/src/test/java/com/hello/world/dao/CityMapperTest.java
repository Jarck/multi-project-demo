package com.hello.world.dao;

import com.hello.world.dto.condition.SearchCityDto;
import com.hello.world.dto.create.CreateCityDto;
import com.hello.world.dto.result.CityDto;
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
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.List;

/**
 * @author jarck-lou
 * @date 2019/02/28 16:41
 **/
@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@SpringBootTest
public class CityMapperTest {
  private static DbSetupTracker dbSetupTracker = new DbSetupTracker();

  @Autowired
  private CityMapper cityMapper;

  @Resource
  private DataSource dataSource;

  @Before
  public void setUp() {
    Operation operation = Operations.sequenceOf(
            Operations.deleteAllFrom("city"),
            Operations.insertInto("city")
                    .columns("id", "name")
                    .values(1, "杭州")
                    .values(2, "苏州")
                    .build()
    );

    DbSetup dbSetup = new DbSetup(new DataSourceDestination(dataSource), operation);
    dbSetupTracker.launchIfNecessary(dbSetup);
  }

  @Test
  public void testSelectByPrimaryKey() {
    CityDto cityDto = cityMapper.selectByPrimaryKey(1L);

    Assert.assertEquals(cityDto.getName(), "杭州");
  }

  @Test
  public void testInsertCity() {
    CreateCityDto createCityDto = new CreateCityDto();
    createCityDto.setName("上海");
    cityMapper.insertCity(createCityDto);

    List<CityDto> cityList = cityMapper.searchWithName("上海");
    Assert.assertEquals(cityList.get(0).getName(), "上海");
  }

  @Test
  public void testSearchWithName() {
    CreateCityDto city = insertCity();

    List<CityDto> cityList = cityMapper.searchWithName("上海");
    Assert.assertEquals(cityList.size(), 1);
    Assert.assertEquals(cityList.get(0).getId(), city.getId());
    Assert.assertEquals(cityList.get(0).getName(), city.getName());
  }

  @Test
  public void testSearchCondition() {
    CreateCityDto city = insertCity();

    SearchCityDto searchCityDto = new SearchCityDto();
    searchCityDto.setName("上海");

    List<CityDto> cityList = cityMapper.searchCondition(searchCityDto);
    Assert.assertEquals(cityList.size(), 1);
    Assert.assertEquals(cityList.get(0).getName(), city.getName());
  }

  private CreateCityDto insertCity() {
    CreateCityDto createCityDto = new CreateCityDto();
    createCityDto.setName("上海");
    cityMapper.insertCity(createCityDto);

    return createCityDto;
  }
}
