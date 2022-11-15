package com.lafi.sljn.internal.loader;

import java.nio.file.Path;
import java.util.List;

public interface Loader<T> {
    default List<T> loadData(Path path) {
        return null;
    }
}
