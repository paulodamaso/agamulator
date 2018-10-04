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

import com.agamulator.core.simple.SpRelease;
import java.util.ArrayList;
import java.util.Collection;
import org.cactoos.Text;

/**
 * Game {@link Release} repository.
 *
 * @since 1.0
 */
public interface Releases {

    /**
     * Adds a new {@link Release} to the repository.
     *
     * @param game Release game
     * @param platform Release platform
     * @param location Release location
     * @return Release
     */
    Release add(Text game, Text platform, Text location);

    /**
     * Iterate over all releases in the repository.
     *
     * @return Iterable with all releases from repository.
     */
    Iterable<Release> iterate();

    /**
     * Simple {@link Releases} implementation with data stored in memory.
     */
    final class Simple implements Releases {

        /**
         * Releases storage.
         */
        private final Collection<Release> releases;

        /**
         * Game storage.
         */
        private final Games games;

        /**
         * Location storage.
         */
        private final Locations locations;

        /**
         * Platform storage.
         */
        private final Platforms platforms;

        /**
         * Constructor.
         * @param games Game repository
         * @param platforms Platform repository
         * @param locations Location repository
         */
        public Simple(final Games games, final Platforms platforms,
            final Locations locations) {
            this.games = games;
            this.platforms = platforms;
            this.locations = locations;
            this.releases = new ArrayList<>(0);
        }

        @Override
        public Release add(final Text game, final Text platform,
            final Text location) {
            final Release release = new SpRelease(
                this.games.find(game),
                this.platforms.find(platform),
                this.locations.find(location)
            );
            this.releases.add(release);
            return release;
        }

        @Override
        public Iterable<Release> iterate() {
            return this.releases;
        }
    }
}
