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

import com.agamulator.core.Platform;
import com.agamulator.core.Platforms;
import com.agamulator.core.simple.SpPlatform;
import com.agamulator.ui.printer.PtPlatforms;
import org.cactoos.Text;
import org.cactoos.list.ListOf;
import org.cactoos.text.TextOf;
import org.hamcrest.MatcherAssert;
import org.hamcrest.core.IsEqual;
import org.junit.Test;

/**
 * Tests for {@link StrPlatforms}, a repository of {@link StrPlatform}.
 *
 * @since 1.0
 */
public final class StrPlatformsTest {

    /**
     * Tests if {@link StrPlatforms} can return its list correctly formatted
     * as a String.
     */
    @Test
    public void returnIterable() {
        MatcherAssert.assertThat(
            "Platform repository did not formatted correctly to String",
            new PtPlatforms(new FkPlatforms()).print(new StrPlatforms()),
            new IsEqual("PC\nPS3\nWii")
        );
    }

    /**
     * Fake {@link StrPlatforms} for testing.
     */
    private final class FkPlatforms implements Platforms {

        @Override
        public Platform find(final Text name) {
            throw new UnsupportedOperationException();
        }

        @Override
        public Platform add(final Text name) {
            throw new UnsupportedOperationException();
        }

        @Override
        public Iterable<Platform> iterate() {
            return new ListOf<>(
                new SpPlatform(new TextOf("PC")),
                new SpPlatform(new TextOf("PS3")),
                new SpPlatform(new TextOf("Wii"))
            );
        }
    }
}
