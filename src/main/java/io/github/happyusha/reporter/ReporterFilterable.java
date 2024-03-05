package io.github.happyusha.reporter;

import io.github.happyusha.reporter.configuration.EntityFilters;

@FunctionalInterface
public interface ReporterFilterable<T extends AbstractReporter> {
    EntityFilters<T> filter();
}
