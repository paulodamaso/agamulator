package com.agamulator.core.fake;

import com.agamulator.core.Release;
import com.agamulator.core.Releases;
import org.cactoos.Text;
import org.cactoos.list.ListOf;
/**
 * Fake {@link Releases} implementation for tests.
 */
public final class FkReleases implements Releases {
    @Override
    public Release add(final Text game, final Text platform,
                       final Text location) {
        return new FkRelease();
    }

    @Override
    public Iterable<Release> iterate() {
        return new ListOf<>(
            new FkRelease()
        );
    }
}
