package com.makaryb.sampletester.sample.stage1;

import com.makaryb.sampletester.sample.stage1.PrimitiveFunctionFileReader;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FileReaderFunctionalityTest {

    private static final String TEXT = "Hello Технополис";

    private final PrimitiveFunctionFileReader pffr = new PrimitiveFunctionFileReader();
    private Path tempFile;

    /*
    Before/After hooks tests.
     */

    /**
     * Выполняется перед каждым тест-методом данного класса.
     *
     * @throws IOException
     */
    @BeforeEach
    void setup() throws IOException {
        tempFile = Files.createTempFile(
                "sample_tester_",
                ".tmp");
    }

    /**
     * Выполняется после каждого тест-метода.
     */
    @AfterEach
    void clean() {
        tempFile.toFile().delete();
    }

    @Test
    void checkReadFile() throws IOException {
        Files.write(
                tempFile,
                TEXT.getBytes());
        assertEquals(
                TEXT,
                pffr.read(tempFile));
    }
}
