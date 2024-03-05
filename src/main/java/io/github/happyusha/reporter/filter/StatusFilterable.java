package io.github.happyusha.reporter.filter;

import java.util.Set;

import io.github.happyusha.Status;
import io.github.happyusha.model.Report;

@FunctionalInterface
public interface StatusFilterable {
    Report filterAndGet(Report report, Set<Status> set);
}
