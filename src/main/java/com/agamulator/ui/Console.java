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
package com.agamulator.ui;

import com.agamulator.core.AGamulator;
import java.util.Scanner;
import java.util.logging.Logger;

/**
 * Console {@link Face}.
 *
 * Provides input via {@link java.util.Scanner} and output via {@link Logger}
 * wrapping the {@link AGamulator} application.
 *
 * @since 1.0
 */
public final class Console implements Face {

    /**
     * Logger for printing things.
     */
    private static final Logger LOGGER =
        Logger.getLogger(Console.class.getName());

    /**
     * Scanner for reading keyboard input.
     */
    private final Scanner scanner;

    /**
     * The wrapped {@link AGamulator} core.
     */
    private final AGamulator core;

    /**
     * Basic constructor.
     * @param core The {@link AGamulator} core
     */
    public Console(final AGamulator core) {
        this.core = core;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void run() {
        Console.LOGGER.fine("Started");
    }
}
