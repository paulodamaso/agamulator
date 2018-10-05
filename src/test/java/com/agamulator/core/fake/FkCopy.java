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
package com.agamulator.core.fake;

import com.agamulator.core.Copy;
import com.agamulator.core.Gamer;
import com.agamulator.core.Release;

/**
 * Fake {@link Copy} for testing.
 *
 * @since 1.0
 */
public final class FkCopy extends Copy.Envelope {

    /**
     * Gamer.
     */
    private final Gamer gam;

    /**
     * Release.
     */
    private final Release rel;

    /**
     * Primary constructor.
     *
     * @param gamer Gamer
     * @param release Release
     */
    public FkCopy(final Gamer gamer, final Release release) {
        super();
        this.gam = gamer;
        this.rel = release;
    }

    /**
     * Gamer constructor.
     *
     * @param gamer Gamer
     */
    public FkCopy(final Gamer gamer) {
        this(gamer, new FkRelease());
    }

    /**
     * Release constructor.
     *
     * @param release Release
     */
    public FkCopy(final Release release) {
        this(new FkGamer(), release);
    }

    /**
     * Empty constructor.
     */
    public FkCopy() {
        this(new FkGamer(), new FkRelease());
    }

    @Override
    public Gamer owner() {
        return this.gam;
    }

    @Override
    public Release release() {
        return this.rel;
    }
}
