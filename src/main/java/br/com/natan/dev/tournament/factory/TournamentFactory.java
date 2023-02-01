package br.com.natan.dev.tournament.factory;

import br.com.natan.dev.tournament.TournamentRunner;
import br.com.natan.dev.tournament.components.Tournament;
import br.com.natan.dev.tournament.utils.FileNotExistsException;
import br.com.natan.dev.tournament.utils.InvalidParticipantsList;
import br.com.natan.dev.tournament.utils.PathUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;

public abstract class TournamentFactory {
    private final BracketFactory bracketFactory;
    protected TournamentFactory(BracketFactory bracketFactory){
        this.bracketFactory = bracketFactory;
    }

    public Tournament createTournament() {
        List<String> participants = getParticipants();
        return new Tournament(bracketFactory.generateBrackets(participants));
    }

    private List<String> getParticipants() {
        Path path = Paths.get(PathUtils.getPackageDirectory(TournamentRunner.class).concat(getFileName()));
        try {
            List<String> participants = Files.readAllLines(path);
            validateParticipantsList(participants);
            return participants;
        } catch (IOException e) {
            throw new FileNotExistsException(path.toString().concat(" does not exist."));
        }
    }

    private void validateParticipantsList(List<String> participants) {
        if (Objects.equals(participants.size() % 2, 1))
            throw new InvalidParticipantsList("Enter a valid number of participants.");
    }

    protected String getFileName() {
        return "\\fileName.txt";
    }
}
