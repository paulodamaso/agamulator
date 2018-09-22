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
import org.cactoos.Text;

/**
 * Game {@link Location} repository.
 *
 * @since 1.0
 */
public interface Locations {
    /**
     * Finds a {@link Location} by name.
     * @param name The {@link Location} name.
     * @return Platform with the given name
     */
    Location find(Text name);

    /**
     * Adds a new {@link Location}.
     * @param name Location name
     * @return Added provider
     */
    Location add(Text name);

    /**
     * Iterate over Locations.
     * @return All locations
     */
    Iterable<Location> iterate();

    /**
     * Simple Locations implementation.
     */
    final class Simple implements Locations {

        /**
         * Location {@link Collection}.
         */
        private final Collection<Location> locations;

        /**
         * Constructor.
         */
        public Simple() {
            this.locations = new ArrayList<>(0);
        }

        @Override
        public Location find(final Text name) {
            return
                this.locations.stream().filter(
                    location -> name.equals(location.name())
            ).findFirst().get();
        }

        @Override
        public Location add(final Text name) {
            final Location added = new Location.Simple(name);
            this.locations.add(added);
            return added;
        }

        @Override
        public Iterable<Location> iterate() {
            return this.locations;
        }
    }
}
