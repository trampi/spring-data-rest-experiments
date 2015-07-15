package hello.repository;

import hello.domain.PersonCompany;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonCompanyRepository extends JpaRepository<PersonCompany, Long> {

}
