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

import com.agamulator.core.Game;
import com.agamulator.core.Location;
import com.agamulator.core.Platform;
import com.agamulator.core.Release;
import com.agamulator.ui.face.FcRelease;

/**
 * Printer implementation for {@link FcRelease}.
 *
 * @param <T> Type in which this Release will be formatted.
 * @since 1.0
 */
public final class PtRelease<T> implements FcRelease<T> {

    /**
     * Decorated Release.
     */
    private final Release origin;

    /**
     * Constructor.
     * @param origin Wrapped release
     */
    public PtRelease(final Release origin) {
        this.origin = origin;
    }

    @Override
    public T format(final Output<T> output) {
        return output.out(this.game(), this.platform(), this.location());
    }

    @Override
    public Platform platform() {
        return this.origin.platform();
    }

    @Override
    public Location location() {
        return this.origin.location();
    }

    @Override
    public Game game() {
        return this.origin.game();
    }

}
