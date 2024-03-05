package io.github.happyusha.reporter.configuration;

import io.github.happyusha.config.ConfigStore;
import io.github.happyusha.reporter.AbstractReporter;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
public abstract class AbstractConfiguration {
    protected AbstractReporter reporter;
    private final ConfigStore store = new ConfigStore();

    @Builder.Default
    private String timeStampFormat = "MMM d, yyyy hh:mm:ss a";
    @Builder.Default
    private String reportName = "";
}