package io.github.happyusha.observer;

import io.github.happyusha.observer.entity.LogEntity;
import io.github.happyusha.observer.entity.ObservedEntity;

import io.reactivex.rxjava3.core.Observer;

public interface LogObserver<T extends ObservedEntity> extends ExtentObserver<T> {
    Observer<LogEntity> getLogObserver();
}
