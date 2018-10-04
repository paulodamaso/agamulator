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
import org.cactoos.text.UncheckedText;

/**
 * Gaming platform (PC, Xbox, PS3, PS4, Wii, etc).
 *
 * @since 1.0
 */
public interface Platform {

    /**
     * Gaming platform name.
     *
     * @return Gaming platform name
     */
    Text name();

    /**
     * Envelope for default {@link Platform} behavior.
     */
    abstract class Envelope implements Platform {
        @Override
        public int hashCode() {
            return this.name().hashCode();
        }

        @Override
        public boolean equals(final Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Platform)) {
                return false;
            }
            final Platform that = (Platform) obj;
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
