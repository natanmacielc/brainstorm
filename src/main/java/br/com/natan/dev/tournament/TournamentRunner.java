package br.com.natan.dev.tournament;

import br.com.natan.dev.tournament.components.Tournament;
import br.com.natan.dev.tournament.factory.NameTournamentFactory;
import br.com.natan.dev.tournament.factory.NumberTournamentFactory;
import br.com.natan.dev.tournament.factory.TournamentFactory;
import br.com.natan.dev.tournament.utils.PathUtils;

import java.io.FileWriter;
import java.io.IOException;

public class TournamentRunner {
    private static final String NAME_BRACKETS_FILE = "c:/temp/nameBracket.txt";
    private static final String NUMBER_BRACKETS_FILE = "c:/temp/numberBracket.txt";
    private static final String SCRIPT_FILE = "\\scripts\\script.bat";

    public static void run() {
        TournamentFactory nameFactory = new NameTournamentFactory();
        writeFiles(nameFactory);
        TournamentFactory numberFactory = new NumberTournamentFactory();
        writeFiles(numberFactory);
        String basePath = PathUtils.getPackageDirectory(TournamentRunner.class);
        ProcessBuilder process = new ProcessBuilder(basePath.concat(SCRIPT_FILE));
        try {
            process.start();
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    private static void writeFiles(TournamentFactory tournamentFactory) {
        Tournament nameTournament = tournamentFactory.createTournament();
        String file = (tournamentFactory instanceof NameTournamentFactory)
                ? NAME_BRACKETS_FILE
                : NUMBER_BRACKETS_FILE;
        try {
            FileWriter bracketWriter = new FileWriter(file);
            bracketWriter.write(nameTournament.toString());
            bracketWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
