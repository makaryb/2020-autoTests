package com.makaryb.sampletester.sample;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class PrimitiveFunctionFileReader implements PrimitiveFileReader {

    @Override
    public String read(Path path) throws IOException {
        return new String(
                Files.readAllBytes(path));
    }
}
