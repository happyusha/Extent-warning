package io.github.happyusha.reporter;

import java.util.Set;

import io.github.happyusha.Status;
import io.github.happyusha.model.Report;
import io.github.happyusha.model.service.ReportFilterService;
import io.github.happyusha.reporter.filter.StatusFilterable;
import io.github.happyusha.util.Assert;

import lombok.Getter;

@Getter
public class AbstractFilterableReporter extends AbstractReporter implements StatusFilterable {
    @Override
    public Report filterAndGet(Report report, Set<Status> set) {
        Assert.notNull(report, "Report must not be null");
        if (set != null)
            return ReportFilterService.filter(report, set);
        return report;
    }
}
