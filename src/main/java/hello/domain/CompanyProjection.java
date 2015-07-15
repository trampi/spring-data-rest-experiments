package hello.domain;

import org.springframework.data.rest.core.config.Projection;

import java.util.List;

@Projection(types = Company.class)
public interface CompanyProjection {

    String getName();

    List<PersonCompany> getPersonCompanies();

}
