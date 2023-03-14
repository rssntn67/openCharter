package OpenCharterDB.Navecontroller;

public class NaveNotFoundException extends RuntimeException {
        NaveNotFoundException(Long id) {
            super("Impossibile trovare la nave " + id);
        }
    }