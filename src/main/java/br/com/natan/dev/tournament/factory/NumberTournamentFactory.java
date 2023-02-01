package br.com.natan.dev.tournament.factory;

public class NumberTournamentFactory extends TournamentFactory {
    public NumberTournamentFactory() {
        super(new NumberBracketFactory());
    }

    @Override
    protected String getFileName() {
        return "\\numberParticipants.txt";
    }
}
