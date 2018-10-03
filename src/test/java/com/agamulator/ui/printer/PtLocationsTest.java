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

import com.agamulator.core.Location;
import com.agamulator.core.Locations;
import org.cactoos.Text;
import org.cactoos.collection.CollectionOf;
import org.cactoos.text.TextOf;
import org.hamcrest.MatcherAssert;
import org.hamcrest.collection.IsIterableContainingInAnyOrder;
import org.hamcrest.core.IsEqual;
import org.junit.Test;

/**
 * Tests for {@link PtLocations}.
 *
 * @since 1.0
 */
public class PtLocationsTest {

    /**
     * Tests if {@link PtLocations} can return correct iterable of printable
     * locations.
     */
    @Test
    public void returnIterable() {
        final Locations locations = new PtLocations(new Locations.Simple());
        final Location one = locations.add(new TextOf("Steam"));
        final Location two = locations.add(new TextOf("Microsoft Live!"));
        MatcherAssert.assertThat(
            "Location repository did not returned correct iterable",
            locations.iterate(),
            new IsIterableContainingInAnyOrder<>(
                new CollectionOf<>(
                    new IsEqual<>(one),
                    new IsEqual<>(two)
                )
            )
        );
    }

    /**
     * Tests if {@link PtLocations} can find correct location.
     */
    @Test
    public void find() {
        final Locations locations = new PtLocations(new Locations.Simple());
        final Text name = new TextOf("GoG Galaxy");
        final Location one = locations.add(name);
        MatcherAssert.assertThat(
            "Location not found",
            locations.find(name),
            new IsEqual<>(one)
        );
    }
}
