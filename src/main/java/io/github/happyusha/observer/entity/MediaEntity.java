package io.github.happyusha.observer.entity;

import io.github.happyusha.model.Log;
import io.github.happyusha.model.Media;
import io.github.happyusha.model.Test;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@Builder
public class MediaEntity implements ObservedEntity {
    private Media media;
    private Test test;
    private Log log;
}
