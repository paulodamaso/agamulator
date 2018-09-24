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
 * Game {@link Copy} repository.
 *
 * @since 1.0
 */
public interface Copies {

    /**
     * Add a new {@link Copy} to the repository.
     * @param gamer Game who owns the copy
     * @param release Release which the copy refers to.
     * @return New copy.
     */
    Copy add(Gamer gamer, Release release);

    /**
     * Iterate over all copies in the repository.
     * @return Iterable with all copies from repository.
     */
    Iterable<Copy> iterate();

    /**
     * Simple {@link Copies} implementation with data stored in memory.
     */
    final class Simple implements Copies {

        /**
         * Copies storage.
         */
        private final Collection<Copy> copies;

        /**
         * Constructor.
         */
        public Simple() {
            this.copies = new ArrayList<>(0);
        }

        @Override
        public Copy add(final Gamer gamer, final Release release) {
            final Copy copy = new Copy.Simple(gamer, release);
            this.copies.add(copy);
            return copy;
        }

        @Override
        public Iterable<Copy> iterate() {
            return this.copies;
        }
    }
}
