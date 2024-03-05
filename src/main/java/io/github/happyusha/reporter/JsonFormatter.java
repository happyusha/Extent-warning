package io.github.happyusha.reporter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import io.github.happyusha.gson.GsonExtentTypeAdapterBuilder;
import io.github.happyusha.model.Test;
import io.github.happyusha.observer.ReportObserver;
import io.github.happyusha.observer.entity.ReportEntity;
import com.google.gson.Gson;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;

public class JsonFormatter extends AbstractFileReporter implements ReporterConfigurable, ReportObserver<ReportEntity> {
    private static final String FILE_NAME = "extent.json";

    public JsonFormatter(File file) {
        super(file);
    }

    public JsonFormatter(String filePath) {
        super(new File(filePath));
    }

    @Override
    public Observer<ReportEntity> getReportObserver() {
        return new Observer<ReportEntity>() {
            @Override
            public void onSubscribe(Disposable d) {
            }

            @Override
            public void onNext(ReportEntity value) {
                flush(value);
            }

            @Override
            public void onError(Throwable e) {
            }

            @Override
            public void onComplete() {
            }
        };
    }

    private void flush(ReportEntity value) {
        Gson gson = GsonExtentTypeAdapterBuilder.builder()
                .withGsonTypeAdapterFactory()
                .build();
        final String filePath = getFileNameAsExt(FILE_NAME, new String[]{".json"});
        try (FileWriter writer = new FileWriter(filePath)) {
            List<Test> list = value.getReport().getTestList();
            gson.toJson(list, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void loadJSONConfig(File jsonFile) {
    }

    @Override
    public void loadJSONConfig(String jsonString) {

    }

    @Override
    public void loadXMLConfig(File xmlFile) {
    }

    @Override
    public void loadXMLConfig(String xmlFile) {
    }
}
