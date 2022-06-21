import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;
import org.springframework.test.context.junit4.SpringRunner;
import tn.esprit.spring.entities.Mission;
import tn.esprit.spring.services.IMissionService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.List;



@RunWith(SpringRunner.class)
@SpringBootTest
public class MissionTest {

    private List<Mission> missionList;

    @Autowired
    private IMissionService serviceMission;

    private static final Logger log = LogManager.getLogger(MissionTest.class);

    @Test
    @Order(1)
    public void testgetAllMissions() {
        log.info("TESTING GET ALL Missions IN PROGRESS");
        try{
            missionList = serviceMission.getAlMissions();
            if(missionList.isEmpty()) {
                log.warn("Missions not found");
            }
        }catch (Exception e) {
            log.error("Please add a mission ! " + e.getMessage());
        }
    }
}