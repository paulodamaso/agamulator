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
package com.agamulator.core.simple;

import com.agamulator.core.Game;
import com.agamulator.core.Gamer;
import com.agamulator.core.fake.FkGamer;
import org.cactoos.Text;
import org.cactoos.text.TextOf;
import org.hamcrest.MatcherAssert;
import org.hamcrest.core.IsCollectionContaining;
import org.hamcrest.core.IsEqual;
import org.junit.Test;
import org.llorllale.cactoos.matchers.TextIs;

/**
 * Test case for {@link SpGamer}.
 *
 * @since 1.0
 */
public final class SpGamerTest {

    /**
     * Name.
     */
    private final Text name = new TextOf("Fake Gamer");

    /**
     * The {@link SpGamer} can return its name.
     */
    @Test
    public void returnName() {
        MatcherAssert.assertThat(
            "Returned wrong name",
            new SpGamer(this.name).name(),
            new TextIs(new FkGamer().name())
        );
    }

    /**
     * Gamer can add game to library.
     */
    @Test
    public void addGame() {
        final Game game = new SpGame(new TextOf("New Game"));
        final Gamer gamer = new SpGamer(new TextOf("Gamer"));
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
