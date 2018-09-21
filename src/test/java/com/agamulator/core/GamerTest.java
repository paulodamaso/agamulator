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
package com.agamulator.core;

import org.cactoos.Text;
import org.cactoos.text.TextOf;
import org.hamcrest.MatcherAssert;
import org.hamcrest.core.IsCollectionContaining;
import org.hamcrest.core.IsEqual;
import org.junit.Test;
import org.llorllale.cactoos.matchers.TextIs;

/**
 * Test case for {@link Gamer}.
 *
 * @since 1.0
 */
public class GamerTest {

    /**
     * Gamer can return name.
     */
    @Test
    public void returnName() {
        final Text name = new TextOf("Gamer Name");
        MatcherAssert.assertThat(
            "Returned wrong name",
            new Gamer.Simple(name).name(),
            new TextIs(name)
        );
    }

    /**
     * Gamer can add game to library.
     */
     @Test
     public void addGame() {
        final Game game = new Game.Simple(new TextOf("New Game"));
        final Gamer gamer = new Gamer.Simple(new TextOf("Gamer"));
        gamer.add(game);
        MatcherAssert.assertThat(
            "Did not added game",
            gamer.games(),
            new IsCollectionContaining<>(
                new IsEqual<>(
                    game
                )
            )
        );
     }


}
