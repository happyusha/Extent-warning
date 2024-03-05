package io.github.happyusha.reporter;

import java.io.File;
import java.io.IOException;

public interface ReporterConfigurable {
    void loadJSONConfig(File jsonFile) throws IOException;
    void loadJSONConfig(String jsonString) throws IOException;
    void loadXMLConfig(File xmlFile) throws IOException;
    void loadXMLConfig(String xmlFile) throws IOException;
}
