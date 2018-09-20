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

/**
 * Gaming platform (PC, Xbox, PS3, PS4, Wii, etc).
 * @since 1.0
 */
public interface Platform {

    /**
     * Gaming platform name.
     * @return Gaming platform name
     */
    Text name();

    /**
     * Simple Platform implementation which stores its data in instance fields.
     */
    final class Simple implements Platform {

        /**
         * Platform name.
         */
        private final Text name;

        /**
         * Contructor.
         * @param name Plataform name
         */
        public Simple(final Text name) {
            this.name = name;
        }

        /**
         * The Platform name.
         * @return Platform name
         */
        public Text name() {
            return this.name;
        }
    }
}
