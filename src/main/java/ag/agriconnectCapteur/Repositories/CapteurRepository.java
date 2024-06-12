package ag.agriconnectCapteur.Repositories;

import ag.agriconnectCapteur.Entities.Capteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CapteurRepository extends JpaRepository<Capteur, Long> {

    List<Capteur> findCapteurByIdUtilisateur(Long idUtilisateur);
}
