package br.com.natan.dev.tournament.utils;

import br.com.natan.dev.tournament.components.Bracket;

import java.util.Iterator;
import java.util.List;

public class TextFormatter {
    public static String tournamentFormatter(List<Bracket> brackets) {
        StringBuilder builder = new StringBuilder();
        Iterator<Bracket> iterator = brackets.iterator();
        iterator.next();
        brackets.forEach(
                bracket -> {
                    Pair<String, String> participants = bracket.getParticipants();
                    builder.append(bracket.getNumber());
                    builder.append("º Combate: \n");
                    builder.append(participants.getLeft());
                    builder.append(" vs ");
                    builder.append(participants.getRight());
                    if (iterator.hasNext()) {
                        builder.append("\n");
                        iterator.next();
                    }
                }
        );

        return builder.toString();
    }
}
