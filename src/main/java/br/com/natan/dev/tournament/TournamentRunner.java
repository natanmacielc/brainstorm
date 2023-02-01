package br.com.natan.dev.tournament;

import br.com.natan.dev.tournament.components.Tournament;
import br.com.natan.dev.tournament.factory.NameTournamentFactory;
import br.com.natan.dev.tournament.factory.NumberTournamentFactory;
import br.com.natan.dev.tournament.factory.TournamentFactory;
import br.com.natan.dev.tournament.utils.Path;

import java.io.FileWriter;
import java.io.IOException;

public class TournamentRunner {
    public static void run() {
        TournamentFactory nameFactory = new NameTournamentFactory();
        writeFiles(nameFactory);
        TournamentFactory numberFactory = new NumberTournamentFactory();
        writeFiles(numberFactory);
        String basePath = Path.PATH_INSTANCE.getActualPackageDirectory(TournamentRunner.class);
        ProcessBuilder process = new ProcessBuilder(basePath.concat(File.SCRIPT_FILE.getPath()));
        try {
            process.start();
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    private static void writeFiles(TournamentFactory tournamentFactory) {
        Tournament nameTournament = tournamentFactory.createTournament();
        String file = (tournamentFactory instanceof NameTournamentFactory)
                ? File.NAME_BRACKETS_FILE.getPath()
                : File.NUMBER_BRACKETS_FILE.getPath();
        try {
            FileWriter bracketWriter = new FileWriter(file);
            bracketWriter.write(nameTournament.toString());
            bracketWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    private enum File {
        NAME_BRACKETS_FILE("c:/temp/nameBracket.txt"),
        NUMBER_BRACKETS_FILE("c:/temp/numberBracket.txt"),
        SCRIPT_FILE("\\scripts\\script.bat");
        private final String path;

        File(String path) {
            this.path = path;
        }

        public String getPath() {
            return this.path;
        }
    }
}
