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
import com.agamulator.core.fake.FkLocation;
import com.agamulator.core.fake.FkPlatform;
import com.agamulator.core.simple.SpGame;
import com.agamulator.core.simple.SpLocation;
import com.agamulator.core.simple.SpPlatform;
import com.agamulator.core.simple.SpRelease;
import org.cactoos.text.TextOf;
import org.hamcrest.MatcherAssert;
import org.hamcrest.core.IsEqual;
import org.hamcrest.core.IsNot;
import org.junit.Test;

/**
 * Test cases for {@link Release} and {@link Release.Envelope}.
 *
 * @since 1.0
 * @checkstyle ClassDataAbstractionCouplingCheck (200 lines)
 */
public class ReleaseTest {

    /**
     * Test for {@link Release.Envelope#equals(Object)} method. Must assert
     * that the {@link Release#game()}, {@link Release#location()} and
     * {@link Release#platform()} values are equal in both objects.
     */
    @Test
    public void returnEquality() {
        MatcherAssert.assertThat(
            "Release envelope does not perform equals correctly",
            new SpRelease(
                new FkGame(),
                new FkPlatform(),
                new FkLocation()
            ),
            new IsEqual<>(
                new SpRelease(
                    new FkGame(),
                    new FkPlatform(),
                    new FkLocation()
                )
            )
        );
    }

    /**
     * Test for {@link Release.Envelope#hashCode()} method. Must assert
     * that the {@link Release} hashes are equal in both objects.
     */
    @Test
    public void returnHashcode() {
        MatcherAssert.assertThat(
            "Release envelope does not perform hashcode correctly",
            new SpRelease(
                new FkGame(),
                new FkPlatform(),
                new FkLocation()
            ).hashCode(),
            new IsEqual<>(
                new SpRelease(
                    new FkGame(),
                    new FkPlatform(),
                    new FkLocation()
                ).hashCode()
            )
        );
    }

    /**
     * Test for {@link Release.Envelope#equals(Object)} method failure when
     * using objects of two different classes.
     */
    @Test
    public void returnInequalityWhenDifferentClasses() {
        MatcherAssert.assertThat(
            "Release envelope does not inequality check correctly",
            new SpRelease(
                new FkGame(),
                new FkPlatform(),
                new FkLocation()
            ).equals("Not a release"),
            new IsEqual<>(false)
        );
    }

    /**
     * Test for {@link Release.Envelope#equals(Object)} method failure when
     * using objects with different {@link Release#game()} values.
     */
    @Test
    public void returnInequalityWhenDifferentGame() {
        MatcherAssert.assertThat(
            "Release envelope does not check inequality correctly on game",
            new SpRelease(
                new SpGame(new TextOf("Game")),
                new FkPlatform(),
                new FkLocation()
            ),
            new IsNot<>(
                new IsEqual<>(
                    new SpRelease(
                        new FkGame(),
                        new FkPlatform(),
                        new FkLocation()
                    )
                )
            )
        );
    }

    /**
     * Test for {@link Release.Envelope#equals(Object)} method failure when
     * using objects with different {@link Release#platform()} values.
     */
    @Test
    public void returnInequalityWhenDifferentPlatform() {
        MatcherAssert.assertThat(
            "Release envelope does not check inequality correctly on platform",
            new SpRelease(
                new FkGame(),
                new SpPlatform(new TextOf("Platform")),
                new FkLocation()
            ),
            new IsNot<>(
                new IsEqual<>(
                    new SpRelease(
                        new FkGame(),
                        new FkPlatform(),
                        new FkLocation()
                    )
                )
            )
        );
    }

    /**
     * Test for {@link Release.Envelope#equals(Object)} method failure when
     * using objects with different {@link Release#location()} values.
     */
    @Test
    public void returnInequalityWhenDifferentLocation() {
        MatcherAssert.assertThat(
            "Release envelope does not check inequality correctly on location",
            new SpRelease(
                new FkGame(),
                new FkPlatform(),
                new SpLocation(new TextOf("Location"))
            ),
            new IsNot<>(
                new IsEqual<>(
                    new SpRelease(
                        new FkGame(),
                        new FkPlatform(),
                        new FkLocation()
                    )
                )
            )
        );
    }
}
