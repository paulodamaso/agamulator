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

import com.agamulator.ui.Action;
import com.agamulator.ui.MdGamer;
import com.agamulator.ui.Media;
import org.cactoos.Text;

/**
 * An aGamulator instance. Holds all the core objects and serves as entrypoint
 * for user interaction with aGamulator. Receives {@link Action} objects and
 * act according to them printing the result in an {@link Media} object.
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
     * Provider repository.
     */
    private final Providers providers;

    /**
     * Front end for {@link Gamer}.
     */
    private final MdGamer fatgamer;

    /**
     * Constructor.
     * @param platforms Platform repository
     * @param games Game repository
     * @param providers Providers repository
     * @param face MdGamer repository
     */
    public AGamulator(final Platforms platforms, final Games games,
        final Providers providers, final MdGamer face) {
        this.providers = providers;
        this.platforms = platforms;
        this.fatgamer = face;
        this.games = games;
    }

    /**
     * Executes a command with some params and prints the result in some media.
     * @param command Action to be executed
     * @param params Value to the command params to the command
     * @return Media with the result printed
     */
    public Media exec(final Action command, final String[] params) {
        try {
            return null;
        } catch (final Exception err) {
            throw new IllegalStateException(err);
        }
    }

    /**
     * Adds a {@link Game}.
     * @param name Game name
     * @param platform Game platform
     * @param provider Game provider
     * @return Return of game addition to media
     */
    private Media add(final Text name, final Platform platform,
        final Provider provider) {
        final Game added = this.games.add(name, platform, provider);
        return null;
    }

    /**
     * Lists all the games games.
     * @return Return of game list
     */
    private Media list() {
        this.games.iterate();
        return null;
    }

}
