package io.github.happyusha.observer;

import io.github.happyusha.observer.entity.ObservedEntity;
import io.github.happyusha.observer.entity.ReportEntity;

import io.reactivex.rxjava3.core.Observer;

public interface ReportObserver<T extends ObservedEntity> extends ExtentObserver<T> {
    Observer<ReportEntity> getReportObserver();
}
