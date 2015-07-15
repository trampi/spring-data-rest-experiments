package hello;

import hello.domain.Person;
import hello.repository.PersonRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@TestPropertySource(locations = "classpath:test-application.properties")
@WebIntegrationTest
public class PersonRepositoryTest {

    @Autowired
    private PersonRepository personRepository;

    private RestTemplate restTemplate = new RestTemplate();

    @Test
    public void testDeletion() {
        assertThat(personRepository.count(), is(0L));
        Person person = new Person();
        person.setFirstName("firstName");
        person.setLastName("lastName");
        personRepository.save(person);
        assertThat(personRepository.count(), is(1L));
    }

    @Test
    public void testValidationOfPersonFirstName() {
        Person person = new Person();
        person.setFirstName(null);
        person.setLastName("lastName");
        restTemplate.postForLocation("http://localhost:8080/persons", person);
    }

    @Test
    public void testValidationOfPersonLastName() {
        Person person = new Person();
        person.setFirstName("firstName");
        person.setLastName(null);
        restTemplate.postForLocation("http://localhost:8080/persons", person);
    }

}
