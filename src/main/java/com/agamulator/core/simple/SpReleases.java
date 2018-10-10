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

import com.agamulator.core.Games;
import com.agamulator.core.Locations;
import com.agamulator.core.Platforms;
import com.agamulator.core.Release;
import com.agamulator.core.Releases;
import java.util.ArrayList;
import java.util.Collection;
import org.cactoos.Text;
import org.cactoos.list.ListOf;

/**
 * Simple {@link Releases} implementation with data stored in memory.
 *
 * @since 1.0
 */
public final class SpReleases implements Releases {

    /**
     * Releases storage.
     */
    private final Collection<Release> releases;

    /**
     * Game storage.
     */
    private final Games games;

    /**
     * Location storage.
     */
    private final Locations locations;

    /**
     * Platform storage.
     */
    private final Platforms platforms;

    /**
     * Constructor.
     * @param games Game repository
     * @param platforms Platform repository
     * @param locations Location repository
     */
    public SpReleases(final Games games, final Platforms platforms,
        final Locations locations) {
        this(games, platforms, locations, new Release[0]);
    }

    /**
     * Constructor.
     * @param games Game repository
     * @param platforms Platform repository
     * @param locations Location repository
     * @param releases Releases
     * @checkstyle ParameterNumberCheck (10 lines)
     */
    public SpReleases(final Games games, final Platforms platforms,
        final Locations locations, final Release...releases) {
        this.games = games;
        this.platforms = platforms;
        this.locations = locations;
        this.releases = new ArrayList<>(new ListOf<>(releases));
    }

    @Override
    public Release add(final Text game, final Text platform,
        final Text location) {
        final Release release = new SpRelease(
            this.games.find(game),
            this.platforms.find(platform),
            this.locations.find(location)
        );
        this.releases.add(release);
        return release;
    }

    @Override
    public Iterable<Release> iterate() {
        return this.releases;
    }
}
