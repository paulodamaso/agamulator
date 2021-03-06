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
package com.agamulator.core.fake;

import com.agamulator.core.Game;
import com.agamulator.core.Location;
import com.agamulator.core.Platform;
import com.agamulator.core.Release;

/**
 * Fake {@link Release} for tests.
 *
 * @since 1.0
 */
public final class FkRelease extends Release.Envelope {

    /**
     * Game.
     */
    private final Game gam;

    /**
     * Platform.
     */
    private final Platform plat;

    /**
     * Location.
     */
    private final Location loc;

    /**
     * Empty constructor.
     */
    public FkRelease() {
        this(new FkGame(), new FkPlatform(), new FkLocation());
    }

    /**
     * Primary constructor.
     *
     * @param game Game
     * @param platform Platform
     * @param location Location
     */
    public FkRelease(final Game game, final Platform platform,
        final Location location) {
        super();
        this.gam = game;
        this.plat = platform;
        this.loc = location;
    }

    /**
     * Game constructor.
     *
     * @param game Game
     */
    public FkRelease(final Game game) {
        this(game, new FkPlatform(), new FkLocation());
    }

    /**
     * Platform constructor.
     *
     * @param platform Platform
     */
    public FkRelease(final Platform platform) {
        this(new FkGame(), platform, new FkLocation());
    }

    /**
     * Platform constructor.
     *
     * @param location Location
     */
    public FkRelease(final Location location) {
        this(new FkGame(), new FkPlatform(), location);
    }

    @Override
    public Platform platform() {
        return this.plat;
    }

    @Override
    public Location location() {
        return this.loc;
    }

    @Override
    public Game game() {
        return this.gam;
    }
}
