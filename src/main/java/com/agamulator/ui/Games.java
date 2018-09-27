package com.agamulator.ui;

import org.cactoos.Text;

import java.util.Collection;

public interface Games extends com.agamulator.core.Games {

    <T> T print(Out<T> out);

    interface Out<T> {
        T print(Iterable<com.agamulator.core.Game> list);
    }
}
