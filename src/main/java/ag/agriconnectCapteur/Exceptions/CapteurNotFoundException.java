package ag.agriconnectCapteur.Exceptions;

public class CapteurNotFoundException extends Exception{
    public CapteurNotFoundException(){
        super("Capteur non trouvé");
    }
}
