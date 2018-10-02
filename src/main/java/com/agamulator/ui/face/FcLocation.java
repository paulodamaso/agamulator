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

import com.agamulator.core.Location;
import org.cactoos.Text;

/**
 * Face for {@link Location}. Provides contracts for printing {@link Location}
 * instances in various output types.
 *
 * @param <T> Type of the printed instance
 * @since 1.0
 */
public interface FcLocation<T> extends Location {

    /**
     * Returns a formatted instance of {@link Location} as T.
     *
     * @param output Who will format the instance into the desired format
     * @return Printed instance
     */
    T format(Output<T> output);

    /**
     * Creates formatted instances of {@link Location} objects. Defines the
     * behavior of formatting a {@link Location} into a T instance.
     *
     * @param <T> Type of generated output
     */
    interface Output<T> {

        /**
         * Creates an T instance which receives a {@link Text} as parameter
         * representing the location name.
         *
         * @param name The location name
         * @return A {@link Location} in T format
         */
        T out(Text name);
    }
}
