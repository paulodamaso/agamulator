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
import org.hamcrest.core.IsCollectionContaining;
import org.hamcrest.core.IsEqual;
import org.junit.Test;

/**
 * Tests for {@link Releases}.
 *
 * @since 1.0
 */
public final class ReleasesTest {

    /**
     * Release repository can add Release.
     */
    @Test
    public void addRelease() {
        final Text title = new TextOf("Dark Forces");
        final Games games = new Games.Simple();
        games.add(title);
        final Text platform = new TextOf("MS-DOS");
        final Platforms platforms = new Platforms.Simple();
        platforms.add(platform);
        final Text location = new TextOf("CD-ROM");
        final Locations locations = new Locations.Simple();
        locations.add(location);
        final Releases releases = new Releases.Simple(
            games,
            platforms,
            locations
        );
        final Release release = releases.add(
            title,
            platform,
            location
        );
        MatcherAssert.assertThat(
            "Release not added",
            releases.iterate(),
            new IsCollectionContaining<>(
                new IsEqual<>(release)
            )
        );
    }
}
