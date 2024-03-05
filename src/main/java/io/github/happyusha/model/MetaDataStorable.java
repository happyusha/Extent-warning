package io.github.happyusha.model;

import java.util.Map;

@FunctionalInterface
public interface MetaDataStorable {
    Map<String, Object> getInfoMap();
}
