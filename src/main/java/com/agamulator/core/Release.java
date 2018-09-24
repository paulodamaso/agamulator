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

import org.cactoos.Text;

/**
 * A {@link Game} release, i.e., the {@link Game} launched for some
 * {@link Platform} at some {@link Location}.
 *
 * @since 1.0
 */
public interface Release extends Game {

    /**
     * The {@link Platform}.
     * @return Platform
     */
    Platform platform();

    /**
     * The {@link Location}.
     * @return Location
     */
    Location location();

    /**
     * Simple release of a {@link Game} with the fields stored in memory.
     */
    final class Simple implements Release {

        /**
         * The {@link Game} of the release.
         */
        private final Game origin;

        /**
         * The release {@link Platform}.
         */
        private final Platform platform;

        /**
         * The release {@link Location}.
         */
        private final Location location;

        /**
         * Constructor.
         * @param origin Game wrapped
         * @param platform Release platform
         * @param location Release location
         */
        public Simple(final Game origin, final Platform platform,
            final Location location) {
            this.location = location;
            this.origin = origin;
            this.platform = platform;
        }

        @Override
        public Platform platform() {
            return this.platform;
        }

        @Override
        public Location location() {
            return this.location;
        }

        @Override
        public Text title() {
            return this.origin.title();
        }
    }
}
