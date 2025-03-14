package com.example.practica5mongoservice.excepciones;

public class ConnectionDbExcepcion extends RuntimeException {
    public ConnectionDbExcepcion(String message) {
        super(message);
    }
}