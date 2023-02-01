package br.com.natan.dev.tournament;

import br.com.natan.dev.tournament.components.Tournament;
import br.com.natan.dev.tournament.factory.NameTournamentFactory;
import br.com.natan.dev.tournament.factory.NumberTournamentFactory;
import br.com.natan.dev.tournament.factory.TournamentFactory;
import br.com.natan.dev.tournament.utils.PathUtils;

import java.io.FileWriter;
import java.io.IOException;

public class TournamentRunner {
    public static void run() throws IOException {
        TournamentFactory nameFactory = new NameTournamentFactory();
        writeFiles(nameFactory);
        TournamentFactory numberFactory = new NumberTournamentFactory();
        writeFiles(numberFactory);
        String basePath = PathUtils.getPackageDirectory(TournamentRunner.class);
        ProcessBuilder process = new ProcessBuilder(basePath.concat("\\scripts\\script.bat"));
        process.start();
    }

    private static void writeFiles(TournamentFactory tournamentFactory) throws IOException {
        Tournament nameTournament = tournamentFactory.createTournament();
        String file = (tournamentFactory instanceof NameTournamentFactory)
                ? "c:/temp/nameBracket.txt"
                : "c:/temp/numberBracket.txt";
        FileWriter bracketWriter = new FileWriter(file);
        bracketWriter.write(nameTournament.toString());
        bracketWriter.close();
    }
}
