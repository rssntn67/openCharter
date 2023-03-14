package OpenCharterDB.controller;

public class NaveNotFoundException extends RuntimeException {
        public NaveNotFoundException(Long id) {
            super("Impossibile trovare la nave " + id);
        }
    }