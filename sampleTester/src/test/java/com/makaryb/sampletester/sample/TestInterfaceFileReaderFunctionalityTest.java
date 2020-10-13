package com.makaryb.sampletester.sample;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestInterfaceFileReaderFunctionalityTest implements TemporaryFolderPrerequisite {

    private static final String TEXT = "Hello Технополис";

    private final PrimitiveFunctionFileReader pffr = new PrimitiveFunctionFileReader();
    private File testFile;

    /*
    Interface declaration and usage test.
    Хорошая практика - написание тестов с использованием интерфейсов.
    Интерфейс определяет отношение между клиентом и реализацией.
    Часто все реализации должны пройти одинаковые тесты.
    При том каждая реализация может иметь свои собственные тесты.
     */

    @BeforeEach
    void testInterfaceSetup(
            @TemporaryFolder File temporaryFolder) throws IOException {
        testFile = new File(
                temporaryFolder,
                "README.md");
        testFile.createNewFile();
    }

    @Test
    void testInterfaceCheckReadFile() throws IOException {
        Files.write(testFile.toPath(), TEXT.getBytes());
        assertEquals(TEXT, pffr.read(testFile.toPath()));
    }
}
