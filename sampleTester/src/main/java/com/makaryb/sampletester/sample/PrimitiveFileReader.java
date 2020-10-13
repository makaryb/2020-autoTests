package com.makaryb.sampletester.sample;

import java.io.IOException;
import java.nio.file.Path;

public interface PrimitiveFileReader {

    String read(Path path) throws IOException;
}
