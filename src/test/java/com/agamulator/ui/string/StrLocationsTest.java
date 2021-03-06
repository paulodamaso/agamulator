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
package com.agamulator.ui.string;

import com.agamulator.core.Location;
import com.agamulator.core.Locations;
import com.agamulator.core.simple.SpLocation;
import com.agamulator.ui.printer.PtLocations;
import org.cactoos.Text;
import org.cactoos.list.ListOf;
import org.cactoos.text.TextOf;
import org.hamcrest.MatcherAssert;
import org.hamcrest.core.IsEqual;
import org.junit.Test;

/**
 * Tests for {@link StrLocations}, a repository of {@link StrLocation}.
 *
 * @since 1.0
 */
public class StrLocationsTest {

    /**
     * Tests if {@link StrLocations} can return its list correctly formatted as
     * a String.
     */
    @Test
    public void returnIterable() {
        MatcherAssert.assertThat(
            "Location repository did not formatted correctly to String",
            new PtLocations(new FkLocations()).print(new StrLocations()),
            new IsEqual("Physical Copy\nPSN\nSteam")
        );
    }

    /**
     * Fake {@link Locations} for testing.
     */
    private final class FkLocations implements Locations {

        @Override
        public Location find(final Text name) {
            throw new UnsupportedOperationException();
        }

        @Override
        public Location add(final Text name) {
            throw new UnsupportedOperationException();
        }

        @Override
        public Iterable<Location> iterate() {
            return new ListOf<>(
                new SpLocation(new TextOf("Physical Copy")),
                new SpLocation(new TextOf("PSN")),
                new SpLocation(new TextOf("Steam"))
            );
        }
    }
}
