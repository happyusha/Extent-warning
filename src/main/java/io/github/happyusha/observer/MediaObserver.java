package io.github.happyusha.observer;

import io.github.happyusha.observer.entity.MediaEntity;
import io.github.happyusha.observer.entity.ObservedEntity;

import io.reactivex.rxjava3.core.Observer;

public interface MediaObserver<T extends ObservedEntity> extends ExtentObserver<T> {
    Observer<MediaEntity> getMediaObserver();
}
