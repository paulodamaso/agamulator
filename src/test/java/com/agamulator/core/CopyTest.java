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

import com.agamulator.core.simple.SpGame;
import com.agamulator.core.simple.SpGamer;
import com.agamulator.core.simple.SpLocation;
import com.agamulator.core.simple.SpPlatform;
import com.agamulator.core.simple.SpRelease;
import org.cactoos.text.TextOf;
import org.hamcrest.MatcherAssert;
import org.hamcrest.core.IsEqual;
import org.junit.Test;

/**
 * Test class for {@link Copy}.
 *
 * @since 1.0
 * @checkstyle ClassDataAbstractionCouplingCheck (100 lines)
 */
public final class CopyTest {

    /**
     * Copy can return game.
     */
    @Test
    public void returnGame() {
        final Game game = new SpGame(new TextOf("Joust"));
        MatcherAssert.assertThat(
            "Returned wrong Game",
            new Copy.Simple(
                new SpGamer(new TextOf("Gamer#2")),
                new SpRelease(
                    game,
                    new SpPlatform(new TextOf("Arcade")),
                    new SpLocation(new TextOf("Cabinet Machine"))
                )
            ).game(),
            new IsEqual<>(game)
        );
    }

    /**
     * Copy can return {@link Gamer}.
     */
    @Test
    public void returnOwner() {
        final Gamer owner = new SpGamer(new TextOf("Gamer Owner"));
        MatcherAssert.assertThat(
            "Returned wrong owner",
            new Copy.Simple(
                owner,
                new SpRelease(
                    new SpGame(new TextOf("Game One name")),
                    new SpPlatform(new TextOf("Platform One name")),
                    new SpLocation(new TextOf("Location One name"))
                )
            ).owner(),
            new IsEqual<>(owner)
        );
    }

    /**
     * Copy can return platform.
     */
    @Test
    public void returnPlatform() {
        final Platform platform = new SpPlatform(
            new TextOf("Platform Two Name")
        );
        MatcherAssert.assertThat(
            "Returned wrong Platform",
            new Copy.Simple(
                new SpGamer(new TextOf("Gamer Two Name")),
                new SpRelease(
                    new SpGame(new TextOf("Game Two Name")),
                    platform,
                    new SpLocation(new TextOf("Location Two Name"))
                )
            ).platform(),
            new IsEqual<>(platform)
        );
    }

    /**
     * Copy can return location.
     */
    @Test
    public void returnLocation() {
        final Location location = new SpLocation(
            new TextOf("Location Three Name")
        );
        MatcherAssert.assertThat(
            "Returned wrong Location",
            new Copy.Simple(
                new SpGamer(new TextOf("Gamer Three Name")),
                new SpRelease(
                    new SpGame(new TextOf("Game Three Name")),
                    new SpPlatform(new TextOf("Platform Three Name")),
                    location
                )
            ).location(),
            new IsEqual<>(location)
        );
    }
}
