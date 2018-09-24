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
import java.util.Iterator;
import org.cactoos.Text;
import org.cactoos.collection.CollectionOf;

/**
 * A {@link Platform} repository.
 * @since 1.0
 */
public interface Platforms {

    /**
     * Finds a {@link Platform} by name.
     * @param name The {@link Platform} name.
     * @return Platform with the given name
     */
    Platform find(Text name);

    /**
     * Adds a new {@link Platform}.
     * @param name Platform name
     * @return Added platform
     */
    Platform add(Text name);

    /**
     * Iterate over Platforms.
     * @return All platforms
     */
    Iterator<Platform> iterate();

    /**
     * Simple Platform implementation.
     */
    final class Simple implements Platforms {

        /**
         * Platform {@link Collection}.
         */
        private final Collection<Platform> platforms;

        /**
         * Constructor.
         */
        public Simple() {
            this.platforms = new ArrayList<>(0);
        }

        @Override
        public Platform find(final Text name) {
            return
                this.platforms.stream().filter(
                    plat -> {
                        return name.equals(plat.name());
                    }
            ).findFirst().get();
        }

        @Override
        public Platform add(final Text name) {
            final Platform added = new Platform.Simple(name);
            this.platforms.add(added);
            return added;
        }

        @Override
        public Iterator<Platform> iterate() {
            return this.platforms.iterator();
        }
    }
}
