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

import com.agamulator.core.Releases;
import com.agamulator.core.fake.FkGames;
import com.agamulator.core.fake.FkLocations;
import com.agamulator.core.fake.FkPlatforms;
import com.agamulator.core.fake.FkRelease;
import com.agamulator.core.fake.FkReleases;
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
public final class SpReleasesTest {

    /**
     * Release repository can add Release.
     */
    @Test
    public void addRelease() {
        MatcherAssert.assertThat(
            "Release not added",
            new SpReleases(
                new FkGames(),
                new FkPlatforms(),
                new FkLocations()
            ).add(
                new TextOf("Fake Game Title"),
                new TextOf("Fake Gaming Platform"),
                new TextOf("Fake Game Location")
            ),
            new IsEqual<>(new FkRelease())
        );
    }

    /**
     * Release repository can iterate.
     */
    @Test
    public void returnIterable() {
        MatcherAssert.assertThat(
            "Iterable not returned",
            new SpReleases(
                new FkGames(),
                new FkPlatforms(),
                new FkLocations(),
                new FkRelease()
            ).iterate(),
            new IsCollectionContaining<>(
                new IsEqual<>(new FkRelease())
            )
        );
    }
}
