/*
 * MIT License
 *
 * Copyright (c) 2018 Paulo Lobo
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.agamulator.ui.string;

import com.agamulator.core.Game;
import com.agamulator.core.Games;
import com.agamulator.core.simple.SpGame;
import com.agamulator.ui.printer.PtGames;
import org.cactoos.Text;
import org.cactoos.list.ListOf;
import org.cactoos.text.TextOf;
import org.hamcrest.MatcherAssert;
import org.hamcrest.core.IsEqual;
import org.junit.Test;

/**
 * Tests for {@link StrGames}, a repository of {@link StrGame}.
 *
 * @since 1.0
 */
public final class StrGamesTest {

    /**
     * Tests if {@link StrGames} can return its list correctly formatted as a
     * String.
     */
    @Test
    public void returnIterable() {
        MatcherAssert.assertThat(
            "Game repository did not formatted correctly to String",
            new PtGames(new FkStrGames()).print(new StrGames()),
            new IsEqual("Day Of The Tentacle\nGrim Fandango\nManiac Mansion")
        );
    }

    /**
     * Fake {@link Games} implementation.
     */
    private final class FkStrGames implements Games {

        @Override
        public Game add(final Text name) {
            throw new UnsupportedOperationException();
        }

        @Override
        public Game find(final Text title) {
            throw new UnsupportedOperationException();
        }

        @Override
        public Iterable<Game> iterate() {
            return new ListOf<>(
                new SpGame(new TextOf("Day Of The Tentacle")),
                new SpGame(new TextOf("Grim Fandango")),
                new SpGame(new TextOf("Maniac Mansion"))
            );
        }
    }
}
