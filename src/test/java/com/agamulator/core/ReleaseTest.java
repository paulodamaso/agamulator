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

import com.agamulator.core.fake.FkRelease;
import com.agamulator.core.simple.SpGame;
import com.agamulator.core.simple.SpLocation;
import com.agamulator.core.simple.SpPlatform;
import org.cactoos.text.TextOf;
import org.hamcrest.MatcherAssert;
import org.hamcrest.core.IsEqual;
import org.hamcrest.core.IsNot;
import org.junit.Test;

/**
 * Test cases for {@link Release} and {@link Release.Envelope}.
 *
 * @since 1.0
 */
public class ReleaseTest {

    /**
     * Fake release.
     */
    private final Release release = new FkRelease();

    /**
     * Test for {@link Release.Envelope#equals(Object)} method. Must assert
     * that the {@link Release#game()}, {@link Release#location()} and
     * {@link Release#platform()} values are equal in both objects.
     */
    @Test
    public void returnEquality() {
        MatcherAssert.assertThat(
            "Release envelope does not perform equals correctly",
            new FkRelease(),
            new IsEqual<>(new FkRelease())
        );
    }

    /**
     * Test for {@link Release.Envelope#equals(Object)} method. Must assert
     * that the result is true when comparing objects with the same reference.
     */
    @Test
    public void returnEqualityWhenSameReference() {
        MatcherAssert.assertThat(
            "Release envelope does not success when references are the same",
            this.release,
            new IsEqual<>(this.release)
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
            new FkRelease().hashCode(),
            new IsEqual<>(new FkRelease().hashCode())
        );
    }

    /**
     * Test for {@link Release.Envelope#equals(Object)} method failure when
     * using objects of two different classes.
     */
    @Test
    public void returnInequalityWhenDifferentClasses() {
        MatcherAssert.assertThat(
            "Release envelope does not fail when classes are different",
            new FkRelease().equals("Not a release"),
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
            new FkRelease(new SpGame(new TextOf("Game"))),
            new IsNot<>(new IsEqual<>(new FkRelease()))
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
            new FkRelease(new SpPlatform(new TextOf("Platform"))),
            new IsNot<>(new IsEqual<>(new FkRelease()))
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
            new FkRelease(new SpLocation(new TextOf("Location"))),
            new IsNot<>(new IsEqual<>(new FkRelease()))
        );
    }
}
