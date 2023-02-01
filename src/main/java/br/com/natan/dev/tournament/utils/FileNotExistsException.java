package br.com.natan.dev.tournament.utils;

public class FileNotExistsException extends RuntimeException {
    public FileNotExistsException(String message) {
        super(message.concat(" does not exist."));
    }
}
