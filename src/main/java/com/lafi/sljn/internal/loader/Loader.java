package com.lafi.sljn.internal.loader;

import java.nio.file.Path;
import java.util.List;

public interface Loader<T> {

    /**
     * Loads all objects as sample type or single type.
     *
     * @param path the location of the text resource
     * @return a list of samples or a list of singles
     */
    default List<T> loadData(Path path) {
        return null;
    }
}
