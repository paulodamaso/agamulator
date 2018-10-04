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

import com.agamulator.core.Platform;
import com.agamulator.core.Platforms;
import java.util.ArrayList;
import java.util.Collection;
import org.cactoos.Text;
import org.cactoos.collection.CollectionOf;

/**
 * Simple {@link Platforms} ({@link Platform} repository) implementation with
 * the repository being stored in a {@link Collection}.
 *
 * @since 1.0
 */
public final class SpPlatforms implements Platforms {

    /**
     * A {@link Platform} {@link Collection}.
     */
    private final Collection<Platform> platforms;

    /**
     * Constructor accepting a platform list.
     *
     * @param platforms Platforms already in repository
     */
    public SpPlatforms(final Platform...platforms) {
        this.platforms = new ArrayList<>(new CollectionOf<>(platforms));
    }

    @Override
    public Platform find(final Text name) {
        return
            this.platforms.stream().filter(
                plat -> name.equals(plat.name())
            ).findFirst().get();
    }

    @Override
    public Platform add(final Text name) {
        final Platform added = new SpPlatform(name);
        this.platforms.add(added);
        return added;
    }

    @Override
    public Iterable<Platform> iterate() {
        return this.platforms;
    }
}
