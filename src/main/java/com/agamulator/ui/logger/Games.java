package com.agamulator.ui.logger;

import com.agamulator.core.Game;
import org.cactoos.Text;
import org.cactoos.text.UncheckedText;

import java.util.logging.Logger;

public class Games implements com.agamulator.ui.Games.Out<String> {

    private final static Logger logger = Logger.getLogger("Game logger");

    @Override
    public String print(Iterable<Game> list) {
        logger.fine("Games Available");
        list.iterator().forEachRemaining( item ->
            new com.agamulator.ui.printer.Game(item).print()
        );
        return null;
    }
}