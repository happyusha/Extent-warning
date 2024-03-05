package io.github.happyusha.config.external;

@FunctionalInterface
public interface ConfigLoadable<T> {
    void apply();
}
