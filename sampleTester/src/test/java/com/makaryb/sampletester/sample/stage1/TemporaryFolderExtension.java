package com.makaryb.sampletester.sample.stage1;

import org.junit.jupiter.api.extension.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;

public class TemporaryFolderExtension implements
        BeforeTestExecutionCallback,
        AfterTestExecutionCallback,
        ParameterResolver {

    private File folder;

    @Override
    public void beforeTestExecution(
            ExtensionContext context) {
        try {
            folder = createTemporaryDirectory();
        } catch (IOException ioException) {
            throw new RuntimeException(
                    "Не получилось создать временное хранилище", ioException);
        }
    }

    private File createTemporaryDirectory() throws IOException {
        File createdTemporaryDirectory = File.createTempFile(
                "sample_tester_",
                "");
        createdTemporaryDirectory.delete();
        createdTemporaryDirectory.mkdir();
        return createdTemporaryDirectory;
    }

    @Override
    public void afterTestExecution(
            ExtensionContext context) throws IOException {
        Path rootPath = folder.toPath();
        Files.walk(rootPath, FileVisitOption.FOLLOW_LINKS)
                .sorted(Comparator.reverseOrder())
                .map(Path::toFile)
                .peek(System.out::println)
                .forEach(File::delete);
    }

    @Override
    public boolean supportsParameter(
            ParameterContext parameterContext,
            ExtensionContext extensionContext) throws ParameterResolutionException {
        return parameterContext
                .getParameter()
                .isAnnotationPresent(TemporaryFolder.class);
    }

    @Override
    public Object resolveParameter(
            ParameterContext parameterContext,
            ExtensionContext extensionContext) throws ParameterResolutionException {
        return folder;
    }
}
