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
import org.cactoos.Text;
import org.cactoos.text.UncheckedText;

/**
 * The {@link Gamer}, a person which have and plays games.
 *
 * @since 1.0
 * @todo #7:30min Refactor Gamer class to behave according to Release / Copy
 *  logic, instead of using direct Game references. Gamer class was created
 *  before this logic creation so it have to be fixed. Refactor Gamer tests too.
 */
public interface Gamer {

    /**
     * Gamer name.
     *
     * @return The gamer name
     */
    Text name();

    /**
     * Adds a release to the library.
     *
     * @param game Release to be added to the player's library.
     * @return Game copy
     */
    Copy add(Release game);

    /**
     * Return the copies owned by this player.
     *
     * @return Copies owned by this player
     */
    Collection<Release> games();

    /**
     * Envelope for default {@link Gamer} behavior.
     */
    abstract class Envelope implements Gamer {
        @Override
        public int hashCode() {
            return this.name().hashCode();
        }

        @Override
        public boolean equals(final Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Gamer)) {
                return false;
            }
            final Gamer that = (Gamer) obj;
            return
                new UncheckedText(
                    this.name()
                ).asString().equals(
                    new UncheckedText(
                        that.name()
                    ).asString()
                );
        }
    }
}

