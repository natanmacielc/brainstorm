package br.com.natan.dev.tournament.utils;

public class InvalidParticipantsList extends RuntimeException {
    public InvalidParticipantsList() {
        super("Enter a valid number of participants.");
    }
}
