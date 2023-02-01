package br.com.natan.dev.tournament.utils;

import br.com.natan.dev.tournament.components.Bracket;

import java.util.Iterator;
import java.util.List;

public class TextFormatter {
    public static String tournamentFormatter(List<Bracket> brackets) {
        StringBuilder builder = new StringBuilder();
        Iterator<Bracket> bracketIterator = brackets.iterator();
        bracketIterator.next();

        brackets.forEach(
                tournamentBracket -> tournamentBracket.getBracket().forEach(
                        (firstParticipant, secondParticipant) -> {
                            builder.append(tournamentBracket.getNumber());
                            builder.append("º Combate: \n");
                            builder.append(firstParticipant);
                            builder.append(" vs ");
                            builder.append(secondParticipant);
                            if (bracketIterator.hasNext()) {
                                builder.append("\n");
                                bracketIterator.next();
                            }
                        }
                )
        );

        return builder.toString();
    }
}
