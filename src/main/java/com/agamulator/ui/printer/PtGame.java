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
package com.agamulator.ui.printer;

import com.agamulator.ui.face.FcGame;
import org.cactoos.Text;

/**
 * Printer implementation for {@link FcGame}.
 *
 * @param <T> Type in which this Game will be formatted.
 * @since 1.0
 */
public final class PtGame<T> implements FcGame<T> {

    /**
     * Decorated {@link com.agamulator.core.Game}.
     */
    private final com.agamulator.core.Game origin;

    /**
     * Constructor.
     * @param origin Decorated game
     */
    public PtGame(final com.agamulator.core.Game origin) {
        this.origin = origin;
    }

    @Override
    public T format(final Output<T> output) {
        return output.out(this.title());
    }

    @Override
    public Text title() {
        return this.origin.title();
    }
}
