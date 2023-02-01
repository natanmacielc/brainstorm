package br.com.natan.dev.tournament.factory;

import br.com.natan.dev.tournament.components.Bracket;

import java.util.List;

public interface BracketFactory {
    List<Bracket> generateBrackets(List<String> participants);
}
