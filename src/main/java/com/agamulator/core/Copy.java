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
 * A {@link Game} copy, which belongs to a a {@link Gamer}.
 *
 * @since 1.0
 */
public interface Copy {

    /**
     * The {@link Gamer} who owns this copy.
     *
     * @return Gamer
     */
    Gamer owner();

    /**
     * The {@link Release} of this copy.
     *
     * @return Release
     */
    Release release();

    /**
     * Envelope for default {@link Copy} behavior.
     */
    abstract class Envelope implements Copy {

        @Override
        public int hashCode() {
            return this.owner().hashCode()
                * this.release().hashCode();
        }

        @Override
        public boolean equals(final Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Copy)) {
                return false;
            }
            final Copy that = (Copy) obj;
            return
                this.owner().equals(that.owner())
                && this.release().equals(that.release());
        }
    }
}
