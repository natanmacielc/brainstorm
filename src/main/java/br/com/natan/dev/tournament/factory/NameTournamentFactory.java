package br.com.natan.dev.tournament.factory;

public class NameTournamentFactory extends TournamentFactory {
    public NameTournamentFactory() {
        super(new NameBracketFactory());
    }

    @Override
    protected String getFileName() {
        return "\\nameParticipants.txt";
    }
}
