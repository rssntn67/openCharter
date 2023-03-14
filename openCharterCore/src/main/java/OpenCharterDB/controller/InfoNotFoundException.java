package OpenCharterDB.controller;

public class InfoNotFoundException extends RuntimeException {
    public InfoNotFoundException(Long id) {
        super("Impossibile trovare info: " + id);
    }
}