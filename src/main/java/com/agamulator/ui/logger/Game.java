package com.agamulator.ui.logger;

import org.cactoos.Text;
import org.cactoos.text.UncheckedText;

import java.util.logging.Logger;

public class Game implements com.agamulator.ui.Game.Out<String> {

    private final static Logger logger = Logger.getLogger("Game logger");

    @Override
    public String print(Text title) {
        logger.fine(new UncheckedText(title).asString());
        return new UncheckedText(title).asString();
    }
}
