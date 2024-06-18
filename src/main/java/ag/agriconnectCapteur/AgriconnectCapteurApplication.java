package ag.agriconnectCapteur;

import ag.agriconnectCapteur.Entities.Capteur;
import ag.agriconnectCapteur.Repositories.CapteurRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class AgriconnectCapteurApplication implements CommandLineRunner {

    private final CapteurRepository capteurRepository;

    public AgriconnectCapteurApplication(CapteurRepository capteurRepository) {
        this.capteurRepository = capteurRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(AgriconnectCapteurApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Capteur capteur1 = new Capteur();
        capteur1.setLongitude(10.0);
        capteur1.setLatitude(20.0);
        capteur1.setTemperature(30.0);
        capteur1.setHumidite(50);
        capteur1.setIntervalle(60);
        capteur1.setIdUtilisateur(1L);

        Capteur capteur2 = new Capteur();
        capteur2.setLongitude(11.0);
        capteur2.setLatitude(21.0);
        capteur2.setTemperature(31.0);
        capteur2.setHumidite(51);
        capteur2.setIntervalle(120);
        capteur2.setIdUtilisateur(1L);

        Capteur capteur3 = new Capteur();
        capteur3.setLongitude(12.0);
        capteur3.setLatitude(22.0);
        capteur3.setTemperature(32.0);
        capteur3.setHumidite(52);
        capteur3.setIntervalle(60);
        capteur3.setIdUtilisateur(2L);

        Capteur capteur4 = new Capteur();
        capteur4.setLongitude(13.0);
        capteur4.setLatitude(23.0);
        capteur4.setTemperature(33.0);
        capteur4.setHumidite(53);
        capteur4.setIntervalle(120);
        capteur4.setIdUtilisateur(2L);

        Capteur capteur5 = new Capteur();
        capteur5.setLongitude(14.0);
        capteur5.setLatitude(24.0);
        capteur5.setTemperature(34.0);
        capteur5.setHumidite(54);
        capteur5.setIntervalle(60);
        capteur5.setIdUtilisateur(3L);

        Capteur capteur6 = new Capteur();
        capteur6.setLongitude(15.0);
        capteur6.setLatitude(25.0);
        capteur6.setTemperature(35.0);
        capteur6.setHumidite(55);
        capteur6.setIntervalle(120);
        capteur6.setIdUtilisateur(3L);

        List<Capteur> capteurs = Arrays.asList(capteur1, capteur2, capteur3, capteur4, capteur5, capteur6);
        capteurRepository.saveAll(capteurs);
    }
}
