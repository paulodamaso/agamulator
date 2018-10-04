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
package com.agamulator.ui.string;

import com.agamulator.core.Release;
import com.agamulator.core.simple.SpGame;
import com.agamulator.core.simple.SpLocation;
import com.agamulator.core.simple.SpPlatform;
import com.agamulator.core.simple.SpRelease;
import com.agamulator.ui.printer.PtRelease;
import org.cactoos.text.TextOf;
import org.hamcrest.MatcherAssert;
import org.hamcrest.core.IsEqual;
import org.junit.Test;

/**
 * Tests for {@link StrRelease}.
 *
 * @since 1.0
 * @checkstyle ClassDataAbstractionCouplingCheck (100 lines)
 */
public final class StrReleaseTest {

    /**
     * Tests if a {@link StrRelease} can format correctly a
     * {@link Release} into a String.
     */
    @Test
    public void formatString() {
        final Release release = new SpRelease(
            new SpGame(new TextOf("Final Fight")),
            new SpPlatform(new TextOf("Super NES")),
            new SpLocation(new TextOf("Original Cartridge"))
        );
        MatcherAssert.assertThat(
            "Cannot format release as string",
            new PtRelease<String>(
                release
            ).format(
                new StrRelease()
            ),
            new IsEqual<>(
                "Game: Final Fight for Super NES on Original Cartridge"
            )
        );
    }
}
