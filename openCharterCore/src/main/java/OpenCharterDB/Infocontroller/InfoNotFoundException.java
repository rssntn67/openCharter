package OpenCharterDB.Infocontroller;

public class InfoNotFoundException extends RuntimeException {
    InfoNotFoundException(Long id) {
        super("Impossibile trovare info: " + id);
    }
}