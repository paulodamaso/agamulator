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
package com.agamulator;

import com.agamulator.core.AGamulator;
import com.agamulator.core.Games;
import com.agamulator.core.Locations;
import com.agamulator.core.Platforms;
import com.agamulator.ui.Console;

/**
 * Main entry point for application.
 * @since 1.0
 */
public final class Main {

    /**
     * Ctor.
     */
    private Main() {
        //It's a utility class.
    }

    /**
     * Main method.
     * @param args Arguments
     */
    public static void main(final String...args) {

        new Console(
            new AGamulator(
                new Platforms.Simple(),
                new Games.Simple(),
                new Locations.Simple()
            )
        ).run();
    }
}
