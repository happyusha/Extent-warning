package io.github.happyusha;

import io.github.happyusha.model.Author;
import io.github.happyusha.model.Category;
import io.github.happyusha.model.Device;
import io.github.happyusha.model.Log;
import io.github.happyusha.model.Media;
import io.github.happyusha.model.Report;
import io.github.happyusha.model.Test;
import io.github.happyusha.observer.AttributesObserver;
import io.github.happyusha.observer.ExtentObserver;
import io.github.happyusha.observer.LogObserver;
import io.github.happyusha.observer.MediaObserver;
import io.github.happyusha.observer.ReportObserver;
import io.github.happyusha.observer.TestObserver;
import io.github.happyusha.observer.entity.AttributeEntity;
import io.github.happyusha.observer.entity.LogEntity;
import io.github.happyusha.observer.entity.MediaEntity;
import io.github.happyusha.observer.entity.ReportEntity;
import io.github.happyusha.observer.entity.TestEntity;

import io.reactivex.rxjava3.subjects.PublishSubject;
import lombok.Getter;

@Getter
abstract class ReactiveSubject {
    private final Report report = Report.builder().build();
    private final PublishSubject<ReportEntity> reportSubject = PublishSubject.create();
    private final PublishSubject<TestEntity> testSubject = PublishSubject.create();
    private final PublishSubject<LogEntity> logSubject = PublishSubject.create();
    private final PublishSubject<MediaEntity> mediaSubject = PublishSubject.create();
    private final PublishSubject<AttributeEntity> attribSubject = PublishSubject.create();

    @SuppressWarnings({"rawtypes", "unchecked"})
    protected void attachReporter(ExtentObserver... observers) {
        for (ExtentObserver o : observers) {
            if (o instanceof ReportObserver)
                reportSubject.subscribe(((ReportObserver) o).getReportObserver());
            if (o instanceof TestObserver)
                testSubject.subscribe(((TestObserver) o).getTestObserver());
            if (o instanceof LogObserver)
                logSubject.subscribe(((LogObserver) o).getLogObserver());
            if (o instanceof MediaObserver)
                mediaSubject.subscribe(((MediaObserver) o).getMediaObserver());
            if (o instanceof AttributesObserver)
                attribSubject.subscribe(((AttributesObserver) o).getAttributesObserver());
        }
    }

    protected void onTestCreated(Test test) {
        testSubject.onNext(TestEntity.builder().test(test).build());
    }

    protected void onTestRemoved(Test test) {
        testSubject.onNext(TestEntity.builder().test(test).removed(true).build());
    }

    protected void onLogCreated(Log log, Test test) {
        logSubject.onNext(LogEntity.builder().log(log).test(test).build());
    }

    protected void onAuthorAssigned(Author x, Test test) {
        attribSubject.onNext(AttributeEntity.builder().author(x).test(test).build());
    }

    protected void onCategoryAssigned(Category x, Test test) {
        attribSubject.onNext(AttributeEntity.builder().category(x).test(test).build());
    }

    protected void onDeviceAssigned(Device x, Test test) {
        attribSubject.onNext(AttributeEntity.builder().device(x).test(test).build());
    }

    protected void onMediaAdded(Media m, Test test) {
        mediaSubject.onNext(MediaEntity.builder().media(m).test(test).build());
    }

    protected void onMediaAdded(Media m, Log log, Test test) {
        mediaSubject.onNext(MediaEntity.builder().media(m).test(test).log(log).build());
    }

    protected void onFlush() {
        reportSubject.onNext(ReportEntity.builder().report(report).build());
    }
}
