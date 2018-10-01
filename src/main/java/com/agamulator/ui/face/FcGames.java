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
package com.agamulator.ui.face;

import com.agamulator.core.Game;
import com.agamulator.core.Games;

/**
 * Face for {@link Games}. Provides contract for printing {@link Games}
 * instances in various output types.
 *
 * @since 1.0
 */
public interface FcGames extends Games {

    /**
     * Returns a printed instance of the {@link Games} object.
     *
     * @param who Who will create printed instance
     * @param <T> Type of the printed instance
     * @return Printed instance
     */
    <T> T print(Output<T> who);

    /**
     * Creates printed instances of {@link Games} objects.
     *
     * @param <T> Type of generated output
     */
    interface Output<T> {

        /**
         * Prints the game list.
         * @param list List to be printed
         * @return Printed list
         */
        T out(Iterable<Game> list);
    }
}
