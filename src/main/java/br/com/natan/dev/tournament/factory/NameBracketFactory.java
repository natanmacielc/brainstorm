package br.com.natan.dev.tournament.factory;

import br.com.natan.dev.tournament.components.Bracket;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Random;

public class NameBracketFactory implements BracketFactory {
    private String firstParticipant;
    private String secondParticipant;

    protected NameBracketFactory() {}

    @Override
    public List<Bracket> generateBrackets(List<String> participants) {
        List<Bracket> tournamentBracket = new ArrayList<>();
        final int size = Math.floorDiv(participants.size(), 2);
        for(int i=1; i<=size; i++) {
            tournamentBracket.add(generateBracket(participants, i));
        }
        return tournamentBracket;
    }

    private Bracket generateBracket(List<String> participants, int number) {
        raffleParticipants(participants);
        Map<String, String> tournamentMap = new HashMap<>();
        tournamentMap.put(firstParticipant, secondParticipant);
        return new Bracket(number, tournamentMap);
    }

    private void raffleParticipants(List<String> participants) {
        firstParticipant = participants.get(new Random().nextInt(participants.size()));
        secondParticipant = participants.get(new Random().nextInt(participants.size()));
        if (Objects.equals(firstParticipant, secondParticipant)) {
            do {
                secondParticipant = participants.get(new Random().nextInt(participants.size()));
            } while (Objects.equals(firstParticipant, secondParticipant));
        }
        removeRaffledParticipants(participants);
    }

    private void removeRaffledParticipants(List<String> participants) {
        participants.remove(firstParticipant);
        participants.remove(secondParticipant);
    }
}
