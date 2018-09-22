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
package com.agamulator.core;

/**
 * An aGamulator instance. Holds all the core objects and serves as entry point
 * for user interaction with aGamulator.
 * @since 1.0
 */
public final class AGamulator {

    /**
     * Games repository.
     */
    private final Games games;

    /**
     * Platform repository.
     */
    private final Platforms platforms;

    /**
     * Location repository.
     */
    private final Locations locations;

    /**
     * Constructor.
     * @param platforms Platform repository
     * @param games Game repository
     * @param locations Locations repository
     */
    public AGamulator(final Platforms platforms, final Games games,
        final Locations locations) {
        this.locations = locations;
        this.platforms = platforms;
        this.games = games;
    }

}
