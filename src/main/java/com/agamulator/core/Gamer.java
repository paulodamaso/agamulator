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
 * The {@link Gamer}, a person which have and plays games.
 * @since 1.0
 */
public interface Gamer {

    /**
     * Gamer name.
     * @return The gamer name
     */
    Text name();

    /**
     * Adds a game to the library.
     * @param game Game to be added to the player's library.
     */
    void add(Game game);

    /**
     * Return the games owned by this player.
     * @return Games owned by this player
     */
    Collection<Game> games();

    /**
     * Simple gamer implementation which store its data in instance fields.
     */
    final class Simple implements Gamer {

        /**
         * Gamer name.
         */
        private final Text name;

        /**
         * Gamer games.
         */
        private final Collection<Game> library;

        /**
         * Simple constructor with name.
         * @param name Gamer name
         */
        public Simple(final Text name) {
            this.name = name;
            this.library = new ArrayList<>(0);
        }

        /**
         * Gamer name.
         * @return The name of the gamer
         */
        public Text name() {
            return this.name;
        }

        /**
         * Adds a {@link Gamer} to library.
         * @param game Game to be added to the player's library.
         */
        public void add(final Game game) {
            this.library.add(game);
        }

        /**
         * Gamer library.
         * @return All the games of the gamer
         */
        public Collection<Game> games() {
            return this.library;
        }
    }
}

