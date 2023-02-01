package br.com.natan.dev.tournament.components;

import br.com.natan.dev.tournament.utils.Pair;

public class Bracket {
    private final Integer number;
    private final Pair<String, String> participants;

    public Bracket(Integer number, Pair<String, String> participants) {
        this.number = number;
        this.participants = participants;
    }

    public Integer getNumber() {
        return number;
    }

    public Pair<String, String> getParticipants() {
        return participants;
    }
}
