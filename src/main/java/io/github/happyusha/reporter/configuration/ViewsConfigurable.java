package io.github.happyusha.reporter.configuration;

@FunctionalInterface
public interface ViewsConfigurable<T> {
    ViewConfigurer<?> viewConfigurer();
}
