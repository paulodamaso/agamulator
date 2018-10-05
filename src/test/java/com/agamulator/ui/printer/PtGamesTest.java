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

import com.agamulator.core.Games;
import com.agamulator.core.fake.FkGame;
import com.agamulator.core.fake.FkGames;
import com.agamulator.core.simple.SpGame;
import com.agamulator.core.simple.SpGames;
import org.cactoos.Text;
import org.cactoos.text.TextOf;
import org.hamcrest.MatcherAssert;
import org.hamcrest.core.IsCollectionContaining;
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
        MatcherAssert.assertThat(
            "Game repository did not returned correct iterable",
            new FkGames().iterate(),
            new IsCollectionContaining<>(new IsEqual<>(new FkGame()))
        );
    }

    /**
     * Tests if {@link PtGames} can find correct game.
     */
    @Test
    public void find() {
        MatcherAssert.assertThat(
            "Game not found",
            new PtGames(new FkGames()).find(new FkGame().title()),
            new IsEqual<>(new FkGame())
        );
    }

    /**
     * Game title to be used in tests.
     */
    private final Text title = new TextOf("Testing Game Title");

    /**
     * The {@link PtGames} repository can add game.
     */
    @Test
    public void addGame() {
        MatcherAssert.assertThat(
            "Game not added",
            new PtGames(new FkGames()).add(this.title),
            new IsEqual<>(new FkGame())
        );
    }
}
