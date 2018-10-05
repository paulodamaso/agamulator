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

import com.agamulator.core.Games;
import com.agamulator.core.Locations;
import com.agamulator.core.Platforms;
import com.agamulator.core.Release;
import com.agamulator.core.Releases;
import com.agamulator.core.simple.SpGames;
import com.agamulator.core.simple.SpLocations;
import com.agamulator.core.simple.SpPlatforms;
import com.agamulator.core.simple.SpReleases;
import org.cactoos.Text;
import org.cactoos.collection.CollectionOf;
import org.cactoos.text.TextOf;
import org.hamcrest.MatcherAssert;
import org.hamcrest.collection.IsIterableContainingInAnyOrder;
import org.hamcrest.core.IsEqual;
import org.junit.Test;

/**
 * Tests for {@link PtReleases}.
 *
 * @since 1.0
 * @checkstyle ClassDataAbstractionCouplingCheck (100 lines)
 */
public class PtReleasesTest {

    /**
     * Tests if {@link PtReleases} can return correct iterable of printable
     * releases.
     */
    @Test
    public void returnIterable() {
        final Text titlea = new TextOf("P.O.W");
        final Text titleb = new TextOf("Choplifter");
        final Games games = new SpGames();
        games.add(titlea);
        games.add(titleb);
        final Text platforma = new TextOf("Arcade");
        final Text platformb = new TextOf("NES");
        final Platforms platforms = new SpPlatforms();
        platforms.add(platforma);
        platforms.add(platformb);
        final Text locationa = new TextOf("Physical Cabinet");
        final Text locationb = new TextOf("ROM Drive");
        final Locations locations = new SpLocations();
        locations.add(locationa);
        locations.add(locationb);
        final Releases releases = new PtReleases(
            new SpReleases(
                games,
                platforms,
                locations
            )
        );
        final Release one = releases.add(
            titlea,
            platforma,
            locationa
        );
        final Release two = releases.add(
            titleb,
            platformb,
            locationb
        );
        MatcherAssert.assertThat(
            "Release repository did not returned correct iterable",
            releases.iterate(),
            new IsIterableContainingInAnyOrder<>(
                new CollectionOf<>(
                    new IsEqual<>(one),
                    new IsEqual<>(two)
                )
            )
        );
    }
}
