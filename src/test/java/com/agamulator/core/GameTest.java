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

import com.agamulator.core.fake.FkGame;
import com.agamulator.core.simple.SpGame;
import org.cactoos.Text;
import org.cactoos.text.TextOf;
import org.hamcrest.MatcherAssert;
import org.hamcrest.core.IsEqual;
import org.junit.Test;

/**
 * Test cases for {@link Game} and {@link Game.Envelope}.
 *
 * @since 1.0
 */
public class GameTest {

    /**
     * Game title for testing.
     */
    private final Text title = new TextOf("Fake Game Title");

    /**
     * Game for testing.
     */
    private final Game game = new SpGame(this.title);

    /**
     * Test for {@link Game.Envelope#equals(Object)} method. Must assert
     * that the {@link Game#title()} values are equal in both objects.
     */
    @Test
    public void returnEquality() {
        MatcherAssert.assertThat(
            "Game envelope does not perform equals correctly",
            new SpGame(this.title),
            new IsEqual<>(new FkGame())
        );
    }

    /**
     * Test for {@link Game.Envelope#equals(Object)} method. Must assert
     * that the method returns true when comparing the same reference.
     */
    @Test
    public void returnEqualityWhenSameReference() {
        MatcherAssert.assertThat(
            "Game envelope does not perform equals correctly on same reference",
            this.game,
            new IsEqual<>(this.game)
        );
    }

    /**
     * Test for {@link Game.Envelope#hashCode()} method. Must assert
     * that the {@link Game#title()} values hashes are equal in both objects.
     */
    @Test
    public void returnHashcode() {
        MatcherAssert.assertThat(
            "Game envelope does not perform hashcode correctly",
            new SpGame(this.title).hashCode(),
            new IsEqual<>(new FkGame().hashCode())
        );
    }

    /**
     * Test for {@link Game.Envelope#equals(Object)} method failure when
     * using objects of two different classes.
     */
    @Test
    public void returnInequality() {
        MatcherAssert.assertThat(
            "Game envelope does not inequality check correctly",
            new FkGame().equals("Not equals"),
            new IsEqual<>(false)
        );
    }
}
