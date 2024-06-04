package ag.agriconnectCapteur.Services;

import ag.agriconnectCapteur.Entities.Capteur;
import ag.agriconnectCapteur.Exceptions.CapteurNotFoundException;
import ag.agriconnectCapteur.Repositories.CapteurRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CapteurService {

    private final CapteurRepository capteurRepository;
    private final SchedulerServiceClient schedulerServiceClient;

    public CapteurService(CapteurRepository capteurRepository, SchedulerServiceClient schedulerServiceClient) {
        this.capteurRepository = capteurRepository;
        this.schedulerServiceClient = schedulerServiceClient;
    }

    public Capteur save(Capteur capteur){
        return capteurRepository.save(capteur);
    }

    public Capteur update(Capteur capteur) throws CapteurNotFoundException{
        try{
            Capteur capteur1 = capteurRepository.findById(capteur.getId()).get();
            capteur1.setHumidite(capteur.getHumidite());
            capteur1.setTemperature(capteur.getTemperature());
            capteur1.setLongitude(capteur.getLongitude());
            capteur1.setLatitude(capteur.getLatitude());
            capteur1.setIntervalle(capteur.getIntervalle());
            return capteurRepository.save(capteur1);
        }catch (NullPointerException e){
            throw new CapteurNotFoundException();
        }
    }

    public Capteur getCapteur(long idCapteur) throws CapteurNotFoundException {
        return capteurRepository.findById(idCapteur).orElseThrow(() -> new CapteurNotFoundException());
    }

    public List<Capteur> getAllCapteurs() {
        return capteurRepository.findAll();
    }

    public double getTemperture(long idCapteur) throws CapteurNotFoundException {
        try {
            return capteurRepository.findById(idCapteur).get().getTemperature();
        }catch (NullPointerException e){
            throw new CapteurNotFoundException();
        }
    }

    public int getHumidite(long idCapteur) throws CapteurNotFoundException {
        try{
            return capteurRepository.findById(idCapteur).get().getHumidite();
        }catch (NullPointerException e){
            throw new CapteurNotFoundException();
        }
    }

    public List<Capteur> changerAllIntervalles(int intervalle) {
        List<Capteur> capteurList= capteurRepository.findAll();
        for(Capteur c : capteurList){
            c.setIntervalle(intervalle);
        }
        return capteurRepository.saveAllAndFlush(capteurList);
    }

    public Capteur updateCapteurInterval(Long id, int interval) throws CapteurNotFoundException {
        Capteur capteur = capteurRepository.findById(id)
                .orElseThrow(CapteurNotFoundException::new);
        capteur.setIntervalle(interval);
        Capteur updatedCapteur = capteurRepository.save(capteur);
        schedulerServiceClient.scheduleSensorDataCollection(updatedCapteur.getId());
        return updatedCapteur;
    }
}
