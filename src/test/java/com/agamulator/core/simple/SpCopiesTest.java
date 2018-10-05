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
package com.agamulator.core.simple;

import com.agamulator.core.Copies;
import com.agamulator.core.Copy;
import com.agamulator.core.fake.FkCopy;
import com.agamulator.core.fake.FkGamer;
import com.agamulator.core.fake.FkRelease;
import org.hamcrest.MatcherAssert;
import org.hamcrest.core.IsCollectionContaining;
import org.hamcrest.core.IsEqual;
import org.junit.Test;

/**
 * Tests for {@link Copies}.
 *
 * @since 1.0
 * @checkstyle ClassDataAbstractionCouplingCheck (100 lines)
 */
public final class SpCopiesTest {

    /**
     * Copies repository can add {@link Copy}.
     */
    @Test
    public void addCopy() {
        MatcherAssert.assertThat(
            "Copy not added",
            new SpCopies().add(new FkGamer(), new FkRelease()),
            new IsEqual<>(new SpCopy(new FkGamer(), new FkRelease()))
        );
    }

    /**
     * Copies repository can add {@link Copy}.
     */
    @Test
    public void returnIterable() {
        MatcherAssert.assertThat(
            "Copy returned",
            new SpCopies(new FkCopy()).iterate(),
            new IsCollectionContaining<>(new IsEqual<>(new FkCopy()))
        );
    }
}
