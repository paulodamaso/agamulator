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

import com.agamulator.core.Games;
import com.agamulator.core.Locations;
import com.agamulator.core.Platforms;
import com.agamulator.core.Releases;
import com.agamulator.core.simple.SpGames;
import com.agamulator.core.simple.SpLocations;
import com.agamulator.core.simple.SpPlatforms;
import com.agamulator.core.simple.SpReleases;
import com.agamulator.ui.printer.PtReleases;
import org.cactoos.Text;
import org.cactoos.text.JoinedText;
import org.cactoos.text.TextOf;
import org.cactoos.text.UncheckedText;
import org.hamcrest.MatcherAssert;
import org.hamcrest.core.IsEqual;
import org.junit.Test;

/**
 * Tests for {@link StrReleases}, a String representation of {@link Releases}.
 *
 * @since 1.0
 * @checkstyle ClassDataAbstractionCouplingCheck (100 lines)
 */
public class StrReleasesTest {

    /**
     * Tests if {@link StrReleases} can return its list correctly formatted as a
     * String.
     */
    @Test
    public void returnIterable() {
        final Text titlea = new TextOf("Castlevania");
        final Text titleb = new TextOf("Super Castlevania IV");
        final Games games = new SpGames();
        games.add(titlea);
        games.add(titleb);
        final Text platforma = new TextOf("NES");
        final Text platformb = new TextOf("SNES");
        final Platforms platforms = new SpPlatforms();
        platforms.add(platforma);
        platforms.add(platformb);
        final Text locationa = new TextOf("Original Cartridge");
        final Text locationb = new TextOf("ROM File");
        final Locations locations = new SpLocations();
        locations.add(locationa);
        locations.add(locationb);
        final PtReleases releases = new PtReleases(
            new SpReleases(
                games,
                platforms,
                locations
            )
        );
        releases.add(
            titlea,
            platforma,
            locationa
        );
        releases.add(
            titleb,
            platformb,
            locationb
        );
        MatcherAssert.assertThat(
            "Release repository did not formatted correctly to String",
            releases.print(new StrReleases()),
            new IsEqual(
                new UncheckedText(
                    new JoinedText(
                        "\n",
                        "Game: Castlevania for NES on Original Cartridge",
                        "Game: Super Castlevania IV for SNES on ROM File"
                    )
                ).asString()
            )
        );
    }
}
