package GrowerFarmFieldAPI.Exceptions;

public class GrowerNotFoundException extends RuntimeException {

    public GrowerNotFoundException(Long id) {
        super("Could not find grower " + id);
    }
}
