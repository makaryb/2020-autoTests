package com.makaryb.sampletester.sample;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.extension.ExtendWith;

@Tag("uses-temporary-dir")
@ExtendWith(TemporaryFolderExtension.class)
public interface TemporaryFolderPrerequisite {
    // ..
}
