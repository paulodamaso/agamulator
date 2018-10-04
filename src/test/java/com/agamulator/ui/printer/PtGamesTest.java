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
package com.agamulator.ui.printer;

import com.agamulator.core.Game;
import com.agamulator.core.Games;
import com.agamulator.core.simple.SpGames;
import org.cactoos.Text;
import org.cactoos.collection.CollectionOf;
import org.cactoos.text.TextOf;
import org.hamcrest.MatcherAssert;
import org.hamcrest.collection.IsIterableContainingInAnyOrder;
import org.hamcrest.core.IsEqual;
import org.junit.Test;

/**
 * Tests for {@link Games}.
 *
 * @since 1.0
 */
public class PtGamesTest {

    /**
     * Tests if {@link PtGames} can return correct iterable of printable games.
     */
    @Test
    public void returnIterable() {
        final Games games = new PtGames(new SpGames());
        final Game one = games.add(new TextOf("Maniac Mansion"));
        final Game two = games.add(
            new TextOf("Indiana Jones and The Fate of Atlantis")
        );
        MatcherAssert.assertThat(
            "Game repository did not returned correct iterable",
            games.iterate(),
            new IsIterableContainingInAnyOrder<>(
                new CollectionOf<>(
                    new IsEqual<>(one),
                    new IsEqual<>(two)
                )
            )
        );
    }

    /**
     * Tests if {@link PtGames} can find correct game.
     */
    @Test
    public void find() {
        final Games locations = new PtGames(new SpGames());
        final Text title = new TextOf("Grim Fandango");
        final Game one = locations.add(title);
        MatcherAssert.assertThat(
            "Game not found",
            locations.find(title),
            new IsEqual<>(one)
        );
    }
}
