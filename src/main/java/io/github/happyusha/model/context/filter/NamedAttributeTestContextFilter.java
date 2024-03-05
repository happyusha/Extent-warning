package io.github.happyusha.model.context.filter;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import io.github.happyusha.Status;
import io.github.happyusha.model.NamedAttribute;
import io.github.happyusha.model.Test;
import io.github.happyusha.model.context.NamedAttributeContextManager;
import io.github.happyusha.model.context.NamedAttributeContext;

public class NamedAttributeTestContextFilter<T extends NamedAttribute> {
    public Set<NamedAttributeContext<T>> filter(NamedAttributeContextManager<T> mgr, Set<Status> status) {
        NamedAttributeContextManager<T> newmgr = new NamedAttributeContextManager<T>();
        mgr.getSet().stream()
                .forEach(x -> newmgr.addContext(x.getAttr(), x.getTestList()));
        List<Test> unwantedList = newmgr.getSet().stream()
                .flatMap(x -> x.getTestList().stream())
                .filter(x -> !status.contains(x.getStatus()))
                .collect(Collectors.toList());
        unwantedList.forEach(newmgr::removeTest);
        return newmgr.getSet();
    }
}
