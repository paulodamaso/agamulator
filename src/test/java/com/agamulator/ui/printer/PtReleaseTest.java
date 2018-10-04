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
import com.agamulator.core.Location;
import com.agamulator.core.Platform;
import com.agamulator.core.Release;
import com.agamulator.core.simple.SpGame;
import com.agamulator.core.simple.SpLocation;
import com.agamulator.core.simple.SpPlatform;
import com.agamulator.core.simple.SpRelease;
import org.cactoos.text.TextOf;
import org.hamcrest.MatcherAssert;
import org.hamcrest.core.IsEqual;
import org.junit.Test;

/**
 * Tests for {@link PtRelease} class.
 *
 * @since 1.0
 */
public final class PtReleaseTest {

    /**
     * Tests if a {@link PtRelease} game is returned correctly.
     */
    @Test
    public void returnGame() {
        final Game game = new SpGame(new TextOf("Command & Conquer"));
        final Release release =
            new SpRelease(
                game,
                new SpPlatform(new TextOf("Mac")),
                new SpLocation(new TextOf("Physical CD ROM"))
            );
        MatcherAssert.assertThat(
            "Returned wrong game",
            game,
            new IsEqual<>(new PtRelease<>(release).game())
        );
    }

    /**
     * Tests if a {@link PtRelease} location is returned correctly.
     */
    @Test
    public void returnLocation() {
        final Location location = new SpLocation(
            new TextOf("Physical Game")
        );
        final Release release =
            new SpRelease(
                new SpGame(
                    new TextOf("Command & Conquer Red Alert")
                ),
                new SpPlatform(new TextOf("MS-DOS")),
                location
            );
        MatcherAssert.assertThat(
            "Returned wrong location",
            location,
            new IsEqual<>(new PtRelease<>(release).location())
        );
    }

    /**
     * Tests if a {@link PtRelease} platform is returned correctly.
     */
    @Test
    public void returnPlatform() {
        final Platform platform = new SpPlatform(new TextOf("Windows 95"));
        final Release release =
            new SpRelease(
                new SpGame(
                    new TextOf("Command & Conquer Tiberiun Sun")
                ),
                platform,
                new SpLocation(new TextOf("Physical DVD-ROM"))
            );
        MatcherAssert.assertThat(
            "Returned wrong platform",
            platform,
            new IsEqual<>(new PtRelease<>(release).platform())
        );
    }
}
