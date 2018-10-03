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

import com.agamulator.core.Platforms;
import com.agamulator.ui.printer.PtPlatforms;
import org.cactoos.text.TextOf;
import org.hamcrest.MatcherAssert;
import org.hamcrest.core.IsEqual;
import org.junit.Test;

/**
 * Tests for {@link StrPlatforms}, a repository of {@link StrPlatform}.
 *
 * @since 1.0
 */
public class StrPlatformsTest {

    /**
     * Tests if {@link StrPlatforms} can return its list correctly formatted
     * as a String.
     */
    @Test
    public void returnIterable() {
        final PtPlatforms platforms = new PtPlatforms(new Platforms.Simple());
        platforms.add(new TextOf("PS Vita"));
        platforms.add(new TextOf("PS3"));
        MatcherAssert.assertThat(
            "Platform repository did not formatted correctly to String",
            platforms.print(new StrPlatforms()),
            new IsEqual("PS Vita\nPS3")
        );
    }
}
