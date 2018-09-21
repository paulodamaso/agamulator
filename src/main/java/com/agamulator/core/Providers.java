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

import java.util.Collection;
import java.util.Iterator;
import org.cactoos.Text;
import org.cactoos.collection.CollectionOf;

/**
 * Game {@link Provider} repository.
 *
 * @since 1.0
 */
public interface Providers {
    /**
     * Finds a {@link Provider} by name.
     * @param name The {@link Provider} name.
     * @return Platform with the given name
     */
    Provider find(Text name);

    /**
     * Adds a new {@link Provider}.
     * @param name Provider name
     * @return Added provider
     */
    Provider add(Text name);

    /**
     * Iterate over Providers.
     * @return All providers
     */
    Iterator<Provider> iterate();

    /**
     * Simple Providers implementation.
     */
    final class Simple implements Providers {

        /**
         * Provider {@link Collection}.
         */
        private Collection<Provider> providers;

        /**
         * Primary constructor.
         *
         * @param providers Platforms supported
         */
        public Simple(final Provider...providers) {
            this.providers = new CollectionOf<>(providers);
        }

        @Override
        public Provider find(final Text name) {
            return
                new CollectionOf<>(this.iterate()).stream().filter(
                    provider -> {
                        return name.equals(provider.name());
                    }
            ).findFirst().get();
        }

        @Override
        public Provider add(final Text name) {
            final Provider added = new Provider.Simple(name);
            this.providers.add(added);
            return added;
        }

        @Override
        public Iterator<Provider> iterate() {
            return this.providers.iterator();
        }
    }
}
