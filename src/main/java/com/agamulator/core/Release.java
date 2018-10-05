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

/**
 * A {@link Game} release, i.e., the {@link Game} launched for some
 * {@link Platform} at some {@link Location}.
 *
 * @since 1.0
 */
public interface Release {

    /**
     * The {@link Platform}.
     *
     * @return Platform
     */
    Platform platform();

    /**
     * The {@link Location}.
     *
     * @return Location
     */
    Location location();

    /**
     * The {@link Game}.
     *
     * @return Game
     */
    Game game();

    /**
     * Envelope for default {@link Release} behavior.
     */
    abstract class Envelope implements Release {
        @Override
        public int hashCode() {
            return
                this.game().hashCode()
                * this.platform().hashCode()
                * this.location().hashCode();
        }

        @Override
        public boolean equals(final Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Release)) {
                return false;
            }
            final Release that = (Release) obj;
            return
                this.game().equals(that.game())
                && this.location().equals(that.location())
                && this.platform().equals(that.platform());
        }
    }
}
