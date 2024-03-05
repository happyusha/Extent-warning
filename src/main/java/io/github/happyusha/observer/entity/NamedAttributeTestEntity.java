package io.github.happyusha.observer.entity;

import io.github.happyusha.model.NamedAttribute;
import io.github.happyusha.model.Test;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class NamedAttributeTestEntity implements ObservedEntity {
    private NamedAttribute attribute;
    private Test test;
}
