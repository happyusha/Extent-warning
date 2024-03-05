package io.github.happyusha.reporter.configuration;

import io.github.happyusha.reporter.AbstractReporter;

import lombok.Getter;
import lombok.experimental.Accessors;

@Getter
@Accessors(fluent = true)
public class EntityFilters<T extends AbstractReporter> {
    private final T reporter;
    private final StatusFilter<T> statusFilter;

    public EntityFilters(T reporter) {
        this.reporter = reporter;
        statusFilter = new StatusFilter<T>(this);
    }

    public T apply() {
        return reporter;
    }
}
