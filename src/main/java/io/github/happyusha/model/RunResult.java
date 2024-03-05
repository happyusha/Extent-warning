package io.github.happyusha.model;

import io.github.happyusha.Status;

@FunctionalInterface
public interface RunResult {
    Status getStatus();
}
