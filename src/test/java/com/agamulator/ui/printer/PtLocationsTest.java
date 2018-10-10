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

import com.agamulator.core.fake.FkLocation;
import com.agamulator.core.fake.FkLocations;
import org.cactoos.Text;
import org.cactoos.text.TextOf;
import org.hamcrest.MatcherAssert;
import org.hamcrest.core.IsCollectionContaining;
import org.hamcrest.core.IsEqual;
import org.junit.Test;

/**
 * Tests for {@link PtLocations}.
 *
 * @since 1.0
 */
public class PtLocationsTest {

    /**
     * Location name to be used in tests.
     */
    private final Text name = new TextOf("Testing Game Location");

    /**
     * Tests if {@link PtLocations} can return correct iterable of printable
     * locations.
     */
    @Test
    public void returnIterable() {
        MatcherAssert.assertThat(
            "Location repository did not returned correct iterable",
            new FkLocations().iterate(),
            new IsCollectionContaining<>(new IsEqual<>(new FkLocation()))
        );
    }

    /**
     * Tests if {@link PtLocations} can find correct location.
     */
    @Test
    public void find() {
        MatcherAssert.assertThat(
            "Location not found",
            new PtLocations(new FkLocations()).find(new FkLocation().name()),
            new IsEqual<>(new FkLocation())
        );
    }

    /**
     * Location repository can add Location.
     */
    @Test
    public void addLocation() {
        MatcherAssert.assertThat(
            "Location not added",
            new PtLocations(new FkLocations()).add(this.name),
            new IsEqual<>(new FkLocation())
        );
    }
}
