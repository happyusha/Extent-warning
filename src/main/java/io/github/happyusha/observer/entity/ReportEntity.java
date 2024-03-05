package io.github.happyusha.observer.entity;

import io.github.happyusha.model.Report;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@Builder
public class ReportEntity implements ObservedEntity {
    private Report report;
}
