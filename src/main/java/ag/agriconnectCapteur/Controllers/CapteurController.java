package ag.agriconnectCapteur.Controllers;

import ag.agriconnectCapteur.Entities.Capteur;
import ag.agriconnectCapteur.Exceptions.CapteurNotFoundException;
import ag.agriconnectCapteur.Services.CapteurService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/capteurs")
public class CapteurController {

    private CapteurService capteurService;

    public CapteurController(CapteurService capteurService) {
        this.capteurService = capteurService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Capteur save(@Valid @RequestBody Capteur capteur){
        return capteurService.save(capteur);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Capteur update(@Valid @RequestBody Capteur capteur) throws CapteurNotFoundException {
        return capteurService.update(capteur);
    }

    @GetMapping("/{id}")
    public Capteur getCatpeur(@PathVariable Long id) throws CapteurNotFoundException {
        return capteurService.getCapteur(id);
    }

    @GetMapping
    public List<Capteur> getAllCatpeurs() {
        return capteurService.getAllCapteurs();
    }

    @GetMapping("/temperature/{id}")
    public double getTemperature(@PathVariable Long id) throws CapteurNotFoundException {
        return capteurService.getTemperture(id);
    }

    @GetMapping("/humidite/{id}")
    public double getHumitide(@PathVariable Long id) throws CapteurNotFoundException {
        return capteurService.getHumidite(id);
    }

    @PutMapping("/intervalle")
    public List<Capteur> changerAllIntervalles(@RequestBody int intervalle){
        return capteurService.changerAllIntervalles(intervalle);
    }

    @ExceptionHandler(CapteurNotFoundException.class)
    public ResponseEntity<String> handleCapteurNotFoudException(CapteurNotFoundException e){
        return new ResponseEntity<>("Capteur non trouvé "+ e.getMessage(), HttpStatus.NOT_FOUND);
    }
}
