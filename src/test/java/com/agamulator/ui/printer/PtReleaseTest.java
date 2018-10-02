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
import org.cactoos.Text;
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
        final Game game = new Game.Simple(new TextOf("Command & Conquer"));
        final Release release =
            new Release.Simple(
                game,
                new Platform.Simple(new TextOf("Mac")),
                new Location.Simple(new TextOf("Physical Game"))
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
        final Location location = new Location.Simple(
            new TextOf("Physical Game")
        );
        final Release release =
            new Release.Simple(
                new Game.Simple(new TextOf("Command & Conquer")),
                new Platform.Simple(new TextOf("Mac")),
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
        final Platform platform = new Platform.Simple(new TextOf("Mac"));
        final Release release =
            new Release.Simple(
                new Game.Simple(new TextOf("Command & Conquer")),
                platform,
                new Location.Simple(new TextOf("Physical Game"))
            );
        MatcherAssert.assertThat(
            "Returned wrong platform",
            platform,
            new IsEqual<>(new PtRelease<>(release).platform())
        );
    }

    /**
     * Tests if a {@link PtRelease} title is returned correctly.
     */
    @Test
    public void returnTitle() {
        final Text title = new TextOf("Earthworm Jim");
        final Release release =
            new Release.Simple(
                new Game.Simple(title),
                new Platform.Simple(new TextOf("Mac")),
                new Location.Simple(new TextOf("Physical Game"))
            );
        MatcherAssert.assertThat(
            "Returned wrong title",
            title,
            new IsEqual<>(new PtRelease<>(release).title())
        );
    }
}
