package com.example.practica5mongoservice.excepciones;

/**
 * Excepcion personalizada del Id
 */
public class IdExcepcion extends RuntimeException {
    public IdExcepcion(String message) {
        super(message);
    }
}