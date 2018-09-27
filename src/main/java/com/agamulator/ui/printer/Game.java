package com.agamulator.ui.printer;

import org.cactoos.Text;

public final class Game implements com.agamulator.ui.Game {

    private final com.agamulator.ui.Game origin;

    Game (final com.agamulator.ui.Game origin) {
        this.origin = origin;
    }

    @Override
    public <T> T print(Out<T> out) {
        return out.print(title());
    }

    @Override
    public Text title() {
        return origin.title();
    }
}
