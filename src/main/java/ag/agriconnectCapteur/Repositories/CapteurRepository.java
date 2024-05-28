package ag.agriconnectCapteur.Repositories;

import ag.agriconnectCapteur.Entities.Capteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CapteurRepository extends JpaRepository<Capteur, Long> {
}
