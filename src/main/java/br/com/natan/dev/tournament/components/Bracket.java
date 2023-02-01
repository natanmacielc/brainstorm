package br.com.natan.dev.tournament.components;

import java.util.Map;

public class Bracket {
    private final Integer number;
    private final Map<String, String> bracket;

    public Bracket(Integer number, Map<String, String> bracket) {
        this.number = number;
        this.bracket = bracket;
    }

    public Integer getNumber() {
        return number;
    }

    public Map<String, String> getBracket() {
        return bracket;
    }
}
