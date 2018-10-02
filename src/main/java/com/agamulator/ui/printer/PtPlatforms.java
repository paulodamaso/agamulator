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

import com.agamulator.core.Platform;
import com.agamulator.core.Platforms;
import com.agamulator.ui.face.FcPlatforms;
import org.cactoos.Text;

/**
 * Printer for {@link FcPlatforms}.
 *
 * @since 1.0
 */
public final class PtPlatforms implements FcPlatforms {

    /**
     * Decorated {@link Platforms}.
     */
    private final Platforms origin;

    /**
     * Constructor.
     *
     * @param origin Decorated platform repository
     */
    public PtPlatforms(final Platforms origin) {
        this.origin = origin;
    }

    @Override
    public Platform find(final Text name) {
        return this.origin.find(name);
    }

    @Override
    public Platform add(final Text name) {
        return this.origin.add(name);
    }

    @Override
    public Iterable<Platform> iterate() {
        return this.origin.iterate();
    }

    @Override
    public <T> T print(final Output<T> where) {
        return where.out(this.iterate());
    }
}
