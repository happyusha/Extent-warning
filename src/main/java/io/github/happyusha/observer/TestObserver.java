package io.github.happyusha.observer;

import io.github.happyusha.observer.entity.ObservedEntity;
import io.github.happyusha.observer.entity.TestEntity;

import io.reactivex.rxjava3.core.Observer;

public interface TestObserver<T extends ObservedEntity> extends ExtentObserver<T> {
    Observer<TestEntity> getTestObserver();
}
