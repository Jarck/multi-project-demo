package com.hello.world.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hello.world.TestServiceConfiguration;
import com.hello.world.dao.CityMapper;
import com.hello.world.dto.PageDto;
import com.hello.world.dto.condition.SearchCityDto;
import com.hello.world.dto.result.CityDto;
import com.hello.world.service.impl.CityServiceImpl;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;

/**
 * @author jarck-lou
 * @date 2019/03/04 15:00
 **/
@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = TestServiceConfiguration.class)
public class CityServiceTest {
  @InjectMocks
  private ICityService cityService = new CityServiceImpl();

  @Mock
  private CityMapper cityMapper;

  @Test
  public void testSearchWithCityId() {
    CityDto cityHZ = new CityDto();
    cityHZ.setId(1L);
    cityHZ.setName("杭州");

    Mockito.when(cityMapper.selectByPrimaryKey(any(Long.class))).thenReturn(cityHZ);

    CityDto cityDto = cityService.searchWithId(1L);
    assertThat(cityDto.getName()).isEqualTo(cityHZ.getName());
  }

  @Test
  public void testSearchWithName() {
    List<CityDto> cityMockList = new ArrayList<>();
    CityDto cityHZ = new CityDto();
    cityHZ.setId(1L);
    cityHZ.setName("杭州");
    cityMockList.add(cityHZ);

    Mockito.when(cityMapper.searchWithName("杭州")).thenReturn(cityMockList);

    List<CityDto> cityDtoList = cityService.searchWithName("杭州");
    assertThat(cityDtoList.size()).isEqualTo(cityMockList.size());
    assertThat(cityDtoList.get(0).getName()).isEqualTo(cityDtoList.get(0).getName());
  }

  @Test
  @Ignore
  public void testPageSearchWithCondition() {
    SearchCityDto searchCityDto = new SearchCityDto();
    searchCityDto.setName("杭州");

    PageDto pageDto = new PageDto();

    List<CityDto> cityList = new ArrayList<>();
    CityDto cityHZ = new CityDto();
    cityHZ.setId(1L);
    cityHZ.setName("杭州1");
    cityList.add(cityHZ);

    PageHelper.startPage(pageDto.getPageNum(), pageDto.getPageSize());
    PageHelper.orderBy(pageDto.getOrderBy() + " " + (pageDto.isDesc() ? "desc" : "asc"));

    PageInfo<CityDto> mock_pageInfo = new PageInfo<>(cityList);

    Mockito.when(cityMapper.searchCondition(any(SearchCityDto.class))).thenReturn(cityList);

    PageInfo<CityDto> cityPageInfo = cityService.searchWithCondition(searchCityDto, pageDto);

    assertThat(cityPageInfo.getPageNum()).isEqualTo(1L);
    assertThat(cityPageInfo.getPageSize()).isEqualTo(20);
    assertThat(cityPageInfo.getTotal()).isEqualTo(1L);
    assertThat(cityPageInfo.isHasNextPage()).isFalse();
    assertThat(cityPageInfo.getList().get(0).getName()).isEqualTo("杭州");
  }
}
