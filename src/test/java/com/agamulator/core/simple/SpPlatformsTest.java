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

import com.agamulator.core.fake.FkPlatform;
import org.cactoos.Text;
import org.cactoos.text.TextOf;
import org.hamcrest.MatcherAssert;
import org.hamcrest.core.IsCollectionContaining;
import org.hamcrest.core.IsEqual;
import org.junit.Test;

/**
 * Tests for {@link SpPlatforms}.
 *
 * @since 1.0
 */
public final class SpPlatformsTest {

    /**
     * Platform name to be used in tests.
     */
    private final Text name = new TextOf("Testing Gaming Platform");

    /**
     * Platform repository can add Platform.
     */
    @Test
    public void addPlatform() {
        MatcherAssert.assertThat(
            "Platform not added",
            new SpPlatforms(new FkPlatform()).add(this.name),
            new IsEqual<>(new SpPlatform(this.name))
        );
    }

    /**
     * Platforms can return an iterable.
     */
    @Test
    public void returnIterable() {
        MatcherAssert.assertThat(
            "Iterable not returned",
            new SpPlatforms(new FkPlatform()).iterate(),
            new IsCollectionContaining<>(
                new IsEqual<>(new FkPlatform())
            )
        );
    }

    /**
     * Platforms can find platform.
     */
    @Test
    public void findPlatform() {
        MatcherAssert.assertThat(
            "Platform not found",
            new SpPlatforms(new FkPlatform()).find(new FkPlatform().name()),
            new IsEqual<>(new FkPlatform())
        );
    }
}
