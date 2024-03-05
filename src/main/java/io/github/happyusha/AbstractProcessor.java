package io.github.happyusha;

import java.io.File;
import java.io.IOException;

import io.github.happyusha.append.RawEntityConverter;
import io.github.happyusha.model.Author;
import io.github.happyusha.model.Category;
import io.github.happyusha.model.Device;
import io.github.happyusha.model.Log;
import io.github.happyusha.model.Media;
import io.github.happyusha.model.SystemEnvInfo;
import io.github.happyusha.model.Test;
import io.github.happyusha.model.service.MediaService;
import io.github.happyusha.model.service.TestService;

import lombok.Data;

@Data
public abstract class AbstractProcessor extends ReactiveSubject {
    private String[] mediaResolverPath;
    private boolean usingNaturalConf = true;
    protected boolean keepLastRetryOnly;

    @Override
    protected void onTestCreated(Test test) {
        if (keepLastRetryOnly) {
            getReport().findTest(test.getName())
                    .ifPresent(x -> getReport().removeTest(x));
        }
        getReport().getTestList().add(test);
        super.onTestCreated(test);
    }

    @Override
    protected void onTestRemoved(Test test) {
        TestService.deleteTest(getReport().getTestList(), test);
        getReport().getAuthorCtx().removeTest(test);
        getReport().getCategoryCtx().removeTest(test);
        getReport().getDeviceCtx().removeTest(test);
        super.onTestRemoved(test);
    }

    protected void onNodeCreated(Test node) {
        if (keepLastRetryOnly) {
            getReport().findTest(node.getName())
                    .ifPresent(x -> getReport().removeTest(x));
        }
        super.onTestCreated(node);
    }

    @Override
    protected void onLogCreated(Log log, Test test) {
        super.onLogCreated(log, test);
        if (log.hasException())
            getReport().getExceptionInfoCtx().addContext(log.getException(), test);
    }

    @Override
    protected void onMediaAdded(Media m, Test test) {
        tryResolvePath(m);
        super.onMediaAdded(m, test);
    }

    @Override
    protected void onMediaAdded(Media m, Log log, Test test) {
        tryResolvePath(m);
        super.onMediaAdded(m, log, test);
    }

    private void tryResolvePath(Media m) {
        MediaService.tryResolveMediaPath(m, mediaResolverPath);
    }

    protected void onAuthorAdded(Author x, Test test) {
        getReport().getAuthorCtx().addContext(x, test);
        super.onAuthorAssigned(x, test);
    }

    protected void onCategoryAdded(Category x, Test test) {
        getReport().getCategoryCtx().addContext(x, test);
        super.onCategoryAssigned(x, test);
    }

    protected void onDeviceAdded(Device x, Test test) {
        getReport().getDeviceCtx().addContext(x, test);
        super.onDeviceAssigned(x, test);
    }

    @Override
    protected void onFlush() {
        getReport().refresh();
        if (!usingNaturalConf) {
            getReport().applyOverrideConf();
        }
        super.onFlush();
    }

    protected void onReportLogAdded(String log) {
        getReport().getLogs().add(log);
    }

    protected void onSystemInfoAdded(SystemEnvInfo env) {
        getReport().getSystemEnvInfo().add(env);
    }

    protected void convertRawEntities(ExtentReports extent, File f) throws IOException {
        RawEntityConverter converter = new RawEntityConverter(extent);
        converter.convertAndApply(f);
    }
}
