package io.github.happyusha.observer;

import io.github.happyusha.observer.entity.AttributeEntity;
import io.github.happyusha.observer.entity.ObservedEntity;

import io.reactivex.rxjava3.core.Observer;

public interface AttributesObserver<T extends ObservedEntity> extends ExtentObserver<T> {
    Observer<AttributeEntity> getAttributesObserver();
}
