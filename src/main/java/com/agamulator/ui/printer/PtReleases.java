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

import com.agamulator.core.Release;
import com.agamulator.core.Releases;
import com.agamulator.ui.face.FcReleases;
import org.cactoos.Text;

/**
 * Printer for {@link FcReleases}.
 *
 * @since 1.0
 */
public final class PtReleases implements FcReleases {

    /**
     * Decorated {@link Releases}.
     */
    private final Releases origin;

    /**
     * Constructor.
     *
     * @param origin Decorated release repository
     */
    public PtReleases(final Releases origin) {
        this.origin = origin;
    }

    @Override
    public Release add(final Text game, final Text platform,
        final Text location) {
        return this.origin.add(game, platform, location);
    }

    @Override
    public Iterable<Release> iterate() {
        return this.origin.iterate();
    }

    @Override
    public <T> T print(final Output<T> where) {
        return where.out(this.iterate());
    }
}
