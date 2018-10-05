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

import com.agamulator.core.Release;
import com.agamulator.core.fake.FkGame;
import com.agamulator.core.fake.FkLocation;
import com.agamulator.core.fake.FkPlatform;
import org.hamcrest.MatcherAssert;
import org.hamcrest.core.IsEqual;
import org.junit.Test;

/**
 * Tests {@link Release} behavior.
 *
 * @since 1.0
 */
public final class SpReleaseTest {

    /**
     * Tests if the Release can return its game.
     */
    @Test
    public void returnGame() {
        MatcherAssert.assertThat(
            "Could not return Release game",
            new SpRelease(
                new FkGame(),
                new FkPlatform(),
                new FkLocation()
            ).game(),
            new IsEqual<>(
                new FkGame()
            )
        );
    }

    /**
     * Tests if the Release can return its location.
     */
    @Test
    public void returnLocation() {
        MatcherAssert.assertThat(
            "Could not return Release location",
            new SpRelease(
                new FkGame(),
                new FkPlatform(),
                new FkLocation()
            ).location(),
            new IsEqual<>(
                new FkLocation()
            )
        );
    }

    /**
     * Tests if the Release can return its platform.
     */
    @Test
    public void returnPlatform() {
        MatcherAssert.assertThat(
            "Could not return Release platform",
            new SpRelease(
                new FkGame(),
                new FkPlatform(),
                new FkLocation()
            ).platform(),
            new IsEqual<>(
                new FkPlatform()
            )
        );
    }
}
