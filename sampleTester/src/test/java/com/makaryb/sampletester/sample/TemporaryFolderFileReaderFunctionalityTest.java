package com.makaryb.sampletester.sample;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(TemporaryFolderExtension.class)
public class TemporaryFolderFileReaderFunctionalityTest {

    private static final String TEXT = "Hello Технополис";

    private final PrimitiveFunctionFileReader pffr = new PrimitiveFunctionFileReader();
    private File testFile;

    /*
    Creating a temporary folder test.
     */

    @BeforeEach
    void temporaryFolderSetup(
            @TemporaryFolder File temporaryFolder) throws IOException {
        testFile = new File(
                temporaryFolder,
                "README.md");
        testFile.createNewFile();
    }

    @Test
    void temporaryFolderCheckReadFile() throws IOException {
        Files.write(
                testFile.toPath(),
                TEXT.getBytes());
        assertEquals(
                TEXT,
                pffr.read(testFile.toPath()));
    }
}
