package com.lafi.sljn.sample.loaders;

import java.nio.file.Path;
import java.util.List;

public interface Loader<T> {
    List<T> loadData(Path path);
}
