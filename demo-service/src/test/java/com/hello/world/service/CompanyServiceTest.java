package com.hello.world.service;

import com.hello.world.TestServiceConfiguration;
import com.hello.world.dao.CompanyMapper;
import com.hello.world.dto.result.CompanyDto;
import com.hello.world.service.impl.CompanyServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * @author jarck-lou
 * @date 2019/03/05 09:34
 **/
@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = TestServiceConfiguration.class)
public class CompanyServiceTest {
  @InjectMocks
  private ICompanyService companyService = new CompanyServiceImpl();

  @Mock
  private CompanyMapper companyMapper;

  @Test
  public void testSearchWithId() {
    CompanyDto companyHZ = new CompanyDto();
    companyHZ.setId(1L);
    companyHZ.setName("杭州xxxx");

    Mockito.when(companyMapper.searchCompanyAndCityWithId(1L)).thenReturn(companyHZ);

    CompanyDto companyDto = companyService.searchWithId(1L);
    assertThat(companyDto.getName()).isEqualTo(companyHZ.getName());
  }
}
