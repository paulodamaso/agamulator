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
import com.agamulator.core.simple.SpLocation;
import com.agamulator.core.simple.SpPlatform;
import com.agamulator.core.simple.SpRelease;
import org.cactoos.text.TextOf;
import org.hamcrest.MatcherAssert;
import org.hamcrest.core.IsEqual;
import org.junit.Test;

/**
 * Tests {@link Release} behavior.
 *
 * @since 1.0
 */
public final class ReleaseTest {

    /**
     * Tests if the Release can return its game.
     */
    @Test
    public void returnGame() {
        final Game game = new SpGame(new TextOf("Loom"));
        MatcherAssert.assertThat(
            "Could not return Release game",
            game,
            new IsEqual<>(
                new SpRelease(
                    game,
                    new SpPlatform(new TextOf("PS4")),
                    new SpLocation(new TextOf("PSN"))
                ).game()
            )
        );
    }

    /**
     * Tests if the Release can return its location.
     */
    @Test
    public void returnLocation() {
        final Location location = new SpLocation(new TextOf("Origin"));
        MatcherAssert.assertThat(
            "Could not return Release location",
            location,
            new IsEqual<>(
                new SpRelease(
                    new SpGame(new TextOf("Dragon Age Origins")),
                    new SpPlatform(new TextOf("PC")),
                    location
                ).location()
            )
        );
    }

    /**
     * Tests if the Release can return its platform.
     */
    @Test
    public void returnPlatform() {
        final Platform platform = new SpPlatform(new TextOf("PC"));
        MatcherAssert.assertThat(
            "Could not return Release platform",
            platform,
            new IsEqual<>(
                new SpRelease(
                    new SpGame(new TextOf("Splinter Cell")),
                    platform,
                    new SpLocation(new TextOf("UPlay"))
                ).platform()
            )
        );
    }
}
