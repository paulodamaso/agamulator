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

import com.agamulator.core.fake.FkLocation;
import com.agamulator.core.simple.SpLocation;
import org.cactoos.Text;
import org.cactoos.text.TextOf;
import org.hamcrest.MatcherAssert;
import org.hamcrest.core.IsEqual;
import org.junit.Test;

/**
 * Test cases for {@link Location} and {@link Location.Envelope}.
 *
 * @since 1.0
 */
public class LocationTest {

    /**
     * Location name for testing.
     */
    private final Text name = new TextOf("Fake Game Location");

    /**
     * Fake location.
     */
    private final Location location = new FkLocation();

    /**
     * Test for {@link Location.Envelope#equals(Object)} method. Must assert
     * that the {@link Location#name()} values are equal in both objects.
     */
    @Test
    public void returnEquality() {
        MatcherAssert.assertThat(
            "Location envelope does not perform equals correctly",
            new SpLocation(this.name),
            new IsEqual<>(this.location)
        );
    }

    /**
     * Test for {@link Location.Envelope#equals(Object)} method. Must assert
     * that the result is true when comparing objects with the same reference.
     */
    @Test
    public void returnEqualityWhenSameReference() {
        MatcherAssert.assertThat(
            "Location envelope does not success when references are the same",
            this.location,
            new IsEqual<>(this.location)
        );
    }

    /**
     * Test for {@link Location.Envelope#hashCode()} method. Must assert
     * that the {@link Location#name()} values hashes are equal in both objects.
     */
    @Test
    public void returnHashcode() {
        MatcherAssert.assertThat(
            "Location envelope does not perform hashcode correctly",
            new SpLocation(this.name).hashCode(),
            new IsEqual<>(this.location.hashCode())
        );
    }

    /**
     * Test for {@link Location.Envelope#equals(Object)} method failure when
     * using objects of two different classes.
     */
    @Test
    public void returnInequality() {
        MatcherAssert.assertThat(
            "Did not failed when comapring objects of two different classes",
            this.location.equals("Not equals"),
            new IsEqual<>(false)
        );
    }
}
