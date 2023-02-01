package br.com.natan.dev.tournament.factory;

import br.com.natan.dev.tournament.components.Bracket;
import br.com.natan.dev.tournament.utils.Pair;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Spliterator;

public class NumberBracketFactory implements BracketFactory {
    protected NumberBracketFactory() {}
    @Override
    public List<Bracket> generateBrackets(List<String> participants) {
        Collections.shuffle(participants);
        return generateRandomBrackets(participants);
    }

    private List<Bracket> generateRandomBrackets(List<String> participants) {
        Spliterator<String> iterator = participants.spliterator();
        Spliterator<String> spliterator = iterator.trySplit();
        List<Bracket> brackets = new ArrayList<>();
        iterator.forEachRemaining(firstParticipant ->
                spliterator.tryAdvance(secondParticipant -> brackets.add(
                        generateRandomBracket(firstParticipant, secondParticipant, getBracketNumber(brackets))
                ))
        );
        return brackets;
    }

    private Bracket generateRandomBracket(String firstParticipant, String secondParticipant, int size) {
        Pair<String, String> bracket = Pair.of(firstParticipant, secondParticipant);
        return new Bracket(size, bracket);
    }

    private int getBracketNumber(List<Bracket> brackets) {
        return Math.addExact(brackets.size(), 1);
    }
}
