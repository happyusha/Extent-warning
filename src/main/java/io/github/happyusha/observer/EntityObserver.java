package io.github.happyusha.observer;

import io.github.happyusha.observer.entity.ObservedEntity;

public interface EntityObserver<T extends ObservedEntity>
        extends
            AttributesObserver<T>,
            LogObserver<T>,
            MediaObserver<T>,
            ReportObserver<T>,
            TestObserver<T> {
}
