package com.makaryb.sampletester.sample.stage1;

import java.io.IOException;
import java.nio.file.Path;

public interface PrimitiveFileReader {

    String read(Path path) throws IOException;
}
