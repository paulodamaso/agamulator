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
     * Copy can return title.
     */
    @Test
    public void returnTitle() {
        final Text title = new TextOf("Game name");
        MatcherAssert.assertThat(
            "Returned wrong Title",
            new Copy.Simple(
                new Gamer.Simple(new TextOf("Gamer name")),
                new Release.Simple(
                    new Game.Simple(title),
                    new Platform.Simple(new TextOf("Platform name")),
                    new Location.Simple(new TextOf("Location name"))
                )
            ).title(),
            new IsEqual<>(title)
        );
    }

    /**
     * Copy can return {@link Gamer}.
     */
    @Test
    public void returnOwner() {
        final Gamer owner = new Gamer.Simple(new TextOf("Gamer Owner"));
        MatcherAssert.assertThat(
            "Returned wrong owner",
            new Copy.Simple(
                owner,
                new Release.Simple(
                    new Game.Simple(new TextOf("Game One name")),
                    new Platform.Simple(new TextOf("Platform One name")),
                    new Location.Simple(new TextOf("Location One name"))
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
        final Platform platform = new Platform.Simple(
            new TextOf("Platform Two Name")
        );
        MatcherAssert.assertThat(
            "Returned wrong Platform",
            new Copy.Simple(
                new Gamer.Simple(new TextOf("Gamer Two Name")),
                new Release.Simple(
                    new Game.Simple(new TextOf("Game Two Name")),
                    platform,
                    new Location.Simple(new TextOf("Location Two Name"))
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
        final Location location = new Location.Simple(
            new TextOf("Location Three Name")
        );
        MatcherAssert.assertThat(
            "Returned wrong Location",
            new Copy.Simple(
                new Gamer.Simple(new TextOf("Gamer Three Name")),
                new Release.Simple(
                    new Game.Simple(new TextOf("Game Three Name")),
                    new Platform.Simple(new TextOf("Platform Three Name")),
                    location
                )
            ).location(),
            new IsEqual<>(location)
        );
    }
}
