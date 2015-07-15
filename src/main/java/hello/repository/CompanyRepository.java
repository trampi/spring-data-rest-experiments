package hello.repository;

import hello.domain.Company;
import hello.domain.CompanyProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(excerptProjection = CompanyProjection.class)
public interface CompanyRepository extends JpaRepository<Company, Long> {

}
