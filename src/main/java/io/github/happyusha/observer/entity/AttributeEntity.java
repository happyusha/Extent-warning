package io.github.happyusha.observer.entity;

import io.github.happyusha.model.Author;
import io.github.happyusha.model.Category;
import io.github.happyusha.model.Device;
import io.github.happyusha.model.Test;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@Builder
public class AttributeEntity implements ObservedEntity {
    private Test test;
    private Author author;
    private Category category;
    private Device device;
}
