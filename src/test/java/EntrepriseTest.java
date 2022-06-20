import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.services.IEntrepriseService;
import java.util.List;
import static org.junit.Assert.assertNotNull;


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

    @Test
    public void TestgetListEntre() {
        List<Entreprise>  task = service.getEntrepriseAll();
        Assertions.assertThat(task.size()).isGreaterThan(0);
    }
    @Test
    public void TestgetEntreById() {
        int id = 1;
        Entreprise user = service.getEntrepriseById(id);
        Assertions.assertThat(user.getId()).isEqualTo(id);
    }

    @Test
    @Rollback(false)
    public void createListUser() {
        Entreprise obj = new Entreprise("Test","Test");
        int test = service.ajouterEntreprise(obj);
        assertNotNull(test);
    }
}
