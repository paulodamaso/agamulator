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

import com.agamulator.core.Release;
import com.agamulator.core.Releases;
import com.agamulator.core.simple.SpGame;
import com.agamulator.core.simple.SpLocation;
import com.agamulator.core.simple.SpPlatform;
import com.agamulator.core.simple.SpRelease;
import com.agamulator.ui.printer.PtReleases;
import org.cactoos.Text;
import org.cactoos.list.ListOf;
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
 */
public class StrReleasesTest {

    /**
     * Tests if {@link StrReleases} can return its list correctly formatted as a
     * String.
     */
    @Test
    public void returnIterable() {
        MatcherAssert.assertThat(
            "Release repository did not formatted correctly to String",
            new PtReleases(new FkReleases()).print(new StrReleases()),
            new IsEqual(
                new UncheckedText(
                    new JoinedText(
                        "\n",
                        "Game: Castlevania for NES on NES Cartridge",
                        "Game: Super Castlevania IV for SNES on SNES Cartridge"
                    )
                ).asString()
            )
        );
    }

    /**
     * Fake {@link Release} for tests.
     */
    private final class FkReleases implements Releases {

        @Override
        public Release add(final Text game, final Text platform,
            final Text location) {
            throw new UnsupportedOperationException();
        }

        @Override
        public Iterable<Release> iterate() {
            return new ListOf<>(
                new SpRelease(
                    new SpGame(new TextOf("Castlevania")),
                    new SpPlatform(new TextOf("NES")),
                    new SpLocation(new TextOf("NES Cartridge"))
                ),
                new SpRelease(
                    new SpGame(new TextOf("Super Castlevania IV")),
                    new SpPlatform(new TextOf("SNES")),
                    new SpLocation(new TextOf("SNES Cartridge"))
                )
            );
        }
    }
}
