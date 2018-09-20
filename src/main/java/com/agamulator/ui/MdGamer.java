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

import org.cactoos.Text;
import org.cactoos.text.FormattedText;
import org.cactoos.text.JoinedText;
import org.cactoos.text.TextOf;

/**
 * Media for printing {@link com.agamulator.core.Gamer} objects.
 *
 * @since 1.0
 */
public final class MdGamer extends Console<com.agamulator.core.Gamer> {

    /**
     * Gamer name.
     */
    private final Text name;

    /**
     * Default constructor.
     * @param name Gamer name
     */
    public MdGamer(final Text name) {
        this.name = name;
    }

    /**
     * Returns text to be printed.
     * @return Text which will be printed
     */
    public Text text() {
        return
        new JoinedText(
            new TextOf("\n"),
            new TextOf("Gamer info"),
            new TextOf("-----------------------"),
            new FormattedText(
                "Name: %s",
                name
            )
        );
    }
}
