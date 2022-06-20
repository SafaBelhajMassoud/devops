import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.services.IEntrepriseService;


@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class EntrepriseTest {

    @Autowired
    private IEntrepriseService service;

    @Test
    public void testFindEntreByName() {
        String name = "entre1";
        Entreprise entr = service.findByName(name);
        Assertions.assertThat(entr.getName()).isEqualTo(name);
    }


}
