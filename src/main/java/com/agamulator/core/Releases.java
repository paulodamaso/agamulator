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

import java.util.ArrayList;
import java.util.Collection;

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
    Release add(Game game, Platform platform, Location location);

    /**
     * Iterate over all releases in the repository.
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
         * Constructor.
         */
        public Simple() {
            this.releases = new ArrayList<>(0);
        }

        @Override
        public Release add(final Game game, final Platform platform,
            final Location location) {
            final Release release = new Release.Simple(
                game, platform, location
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
