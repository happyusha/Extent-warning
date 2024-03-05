package io.github.happyusha.observer.entity;

import io.github.happyusha.model.Log;
import io.github.happyusha.model.Test;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@Builder
public class LogEntity implements ObservedEntity {
    private Log log;
    private Test test;
}
