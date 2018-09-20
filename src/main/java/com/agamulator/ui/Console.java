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
package com.agamulator.ui;

import org.cactoos.Text;

import java.util.logging.Logger;

/**
 * Console {@link Media}.
 *
 * Basically prints objects of type T represented as a sequence of characters in
 * console view. Uses {@link Logger} for writing to console.
 *
 * @param <T> Type of object to be printed in media (console).
 * @since 1.0
 */
public abstract class Console<T> implements Media {

    /**
     * Get a logger for printing things.
     */
    private final Logger logger = Logger.getLogger(this.getClass().getName());

    /**
     * Piece of information to be printed.
     */
    abstract Text text();

    @Override
    public void show() {
        try {
            logger.fine(text().asString());
        } catch (final Exception err) {
            throw new IllegalStateException(err);
        }
    }
}
