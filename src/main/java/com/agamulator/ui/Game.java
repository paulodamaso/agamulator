package com.agamulator.ui;

import org.cactoos.Text;

public interface Game extends com.agamulator.core.Game {

    <T> T print(Out<T> out);

    interface Out<T> {
        T print(Text title);
    }
}
