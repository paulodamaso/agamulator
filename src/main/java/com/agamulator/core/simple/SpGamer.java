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

import com.agamulator.core.Copy;
import com.agamulator.core.Gamer;
import com.agamulator.core.Release;
import java.util.ArrayList;
import java.util.Collection;
import org.cactoos.Text;
import org.cactoos.list.ListOf;

/**
 * Simple {@link Gamer} implementation which store its data in instance fields.
 *
 * @since 1.0
 */
public final class SpGamer extends Gamer.Envelope {

    /**
     * Gamer name.
     */
    private final Text gamer;

    /**
     * Gamer games.
     */
    private final Collection<Release> library;

    /**
     * Simple constructor with name.
     *
     * @param name Gamer name
     */
    public SpGamer(final Text name) {
        this(name, new Release[0]);
    }

    /**
     * Constructor with name and copies owned.
     *
     * @param name Gamer name
     * @param copies Releases owned
     */
    public SpGamer(final Text name, final Release...copies) {
        super();
        this.gamer = name;
        this.library = new ArrayList<>(new ListOf<>(copies));
    }

    /**
     * Gamer name.
     *
     * @return The name of the gamer
     */
    public Text name() {
        return this.gamer;
    }

    /**
     * Adds a {@link Gamer} to library.
     *
     * @param game Game to be added to the player's library.
     * @return Copy added
     */
    public Copy add(final Release game) {
        this.library.add(game);
        return new SpCopy(this, game);
    }

    /**
     * Gamer library.
     *
     * @return All the games of the gamer
     */
    public Collection<Release> games() {
        return this.library;
    }
}
