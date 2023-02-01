package br.com.natan.dev.tournament.components;

import br.com.natan.dev.tournament.utils.TextFormatter;

import java.util.List;

public class Tournament {
    private final List<Bracket> brackets;

    public Tournament(List<Bracket> brackets) {
        this.brackets = brackets;
    }

    @Override
    public String toString() {
        return TextFormatter.tournamentFormatter(this.brackets);
    }
}
