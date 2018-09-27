package com.agamulator.ui.printer;

import com.agamulator.core.Game;
import org.cactoos.Text;

public final class Games implements com.agamulator.ui.Games {

    private final com.agamulator.ui.Games origin;

    Games (final com.agamulator.ui.Games origin) {
        this.origin = origin;
    }

    @Override
    public Game add(Text name) {
        return origin.add(name);
    }

    @Override
    public Iterable<Game> iterate() {
        return origin.iterate();
    }

    @Override
    public <T> T print(Out<T> out) {
        return out.print(iterate());
    }
}
