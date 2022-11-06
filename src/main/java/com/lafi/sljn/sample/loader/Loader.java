package com.lafi.sljn.sample.loader;

import java.nio.file.Path;
import java.util.List;

public interface Loader<T> {
    List<T> loadData(Path path);
}
