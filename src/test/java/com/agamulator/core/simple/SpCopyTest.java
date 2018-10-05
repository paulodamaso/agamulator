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

import com.agamulator.core.Copy;
import com.agamulator.core.Gamer;
import com.agamulator.core.fake.FkGamer;
import com.agamulator.core.fake.FkRelease;
import org.hamcrest.MatcherAssert;
import org.hamcrest.core.IsEqual;
import org.junit.Test;

/**
 * Test class for {@link Copy}.
 *
 * @since 1.0
 * @checkstyle ClassDataAbstractionCouplingCheck (100 lines)
 */
public final class SpCopyTest {

    /**
     * Copy can return release.
     */
    @Test
    public void returnRelease() {
        MatcherAssert.assertThat(
            "Returned wrong Release",
            new SpCopy(new FkGamer(), new FkRelease()).release(),
            new IsEqual<>(new FkRelease())
        );
    }

    /**
     * Copy can return {@link Gamer}.
     */
    @Test
    public void returnOwner() {
        MatcherAssert.assertThat(
            "Returned wrong owner",
            new SpCopy(new FkGamer(), new FkRelease()).owner(),
            new IsEqual<>(new FkGamer())
        );
    }
}
