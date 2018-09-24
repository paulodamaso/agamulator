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

import org.cactoos.text.TextOf;
import org.hamcrest.MatcherAssert;
import org.hamcrest.core.IsCollectionContaining;
import org.hamcrest.core.IsEqual;
import org.junit.Test;

/**
 * Tests for {@link Copies}.
 *
 * @since 1.0
 * @checkstyle ClassDataAbstractionCouplingCheck (100 lines)
 */
public final class CopiesTest {

    /**
     * Copies repository can add {@link Copy}.
     */
    @Test
    public void addCopy() {
        final Copies copies = new Copies.Simple();
        final Copy copy = copies.add(
            new Gamer.Simple(
                new TextOf("Gamer Number One")
            ),
            new Release.Simple(
                new Game.Simple(
                    new TextOf("Game Number One")
                ),
                new Platform.Simple(
                    new TextOf("Gaming Platform")
                ),
                new Location.Simple(
                    new TextOf("Game Location")
                )
            )
        );
        MatcherAssert.assertThat(
            "Copy not added",
            copies.iterate(),
            new IsCollectionContaining<>(
                new IsEqual<>(copy)
            )
        );
    }
}
