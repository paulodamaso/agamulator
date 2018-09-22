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
 * {@link Game} collection holder.
 * @since 1.0
 */
public interface Games {

    /**
     * Adds a new game.
     * @param name Game name
     * @return The created {@link Game}
     */
    Game add(Text name);

    /**
     * Iterate over the {@link Game} instaces stored by this {@link Games}.
     * @return A {@link Game} iterable
     */
    Iterable<Game> iterate();

    /**
     * Simple implementation.
     */
    final class Simple implements Games {

        /**
         * Game library.
         */
        private final Collection<Game> library;

        /**
         * Default constructor.
         */
        public Simple() {
            this.library = new ArrayList<>(0);
        }

        @Override
        public Game add(final Text name) {
            final Game game = new Game.Simple(name);
            this.library.add(game);
            return game;
        }

        @Override
        public Iterable<Game> iterate() {
            return this.library;
        }
    }
}
