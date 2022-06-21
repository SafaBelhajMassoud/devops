import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.services.IContratService;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration
public class ContratTest {

    private List<Contrat> contratList;
    @Autowired
    private IContratService serviceContrat;

    private static final Logger log = LogManager.getLogger(ContratTest.class);

    @Test
    @Order(1)
    public void testgetAllContrats() {
        log.info("TESTING GET ALL CONTRATS IN PROGRESS");
        try{
            contratList = serviceContrat.getAllContrats();
            if(contratList.isEmpty()) {
                log.warn("contrats not found");
            }
        }catch (Exception e) {
            log.error("Please add a contrat ! " + e.getMessage());
        }
    }
}