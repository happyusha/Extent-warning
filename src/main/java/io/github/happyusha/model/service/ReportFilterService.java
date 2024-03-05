package io.github.happyusha.model.service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import io.github.happyusha.Status;
import io.github.happyusha.model.Author;
import io.github.happyusha.model.Category;
import io.github.happyusha.model.Device;
import io.github.happyusha.model.Report;
import io.github.happyusha.model.Test;
import io.github.happyusha.model.context.NamedAttributeContext;
import io.github.happyusha.model.context.filter.NamedAttributeTestContextFilter;

public class ReportFilterService {
    public static Report filter(Report report, Set<Status> statusList) {
        if (report.getTestList().isEmpty())
            return report;
        Report filtered = Report.builder().build();
        filtered.getLogs().addAll(report.getLogs());
        filtered.setStartTime(report.getStartTime());
        filtered.setEndTime(report.getEndTime());
        List<Test> list = report.getTestList().stream()
                .filter(x -> statusList.contains(x.getStatus()))
                .collect(Collectors.toList());
        list.forEach(filtered.getTestList()::add);
        filtered.getStats().update(list);
        Set<NamedAttributeContext<Author>> authorCtx = new NamedAttributeTestContextFilter<Author>()
                .filter(report.getAuthorCtx(), statusList);
        authorCtx.stream().forEach(x -> filtered.getAuthorCtx().addContext(x.getAttr(), x.getTestList()));
        Set<NamedAttributeContext<Category>> categoryCtx = new NamedAttributeTestContextFilter<Category>()
                .filter(report.getCategoryCtx(), statusList);
        categoryCtx.stream().forEach(x -> filtered.getCategoryCtx().addContext(x.getAttr(), x.getTestList()));
        Set<NamedAttributeContext<Device>> deviceCtx = new NamedAttributeTestContextFilter<Device>()
                .filter(report.getDeviceCtx(), statusList);
        deviceCtx.stream().forEach(x -> filtered.getDeviceCtx().addContext(x.getAttr(), x.getTestList()));
        return filtered;
    }
}
