package io.github.happyusha.markuputils;

import io.github.happyusha.ExtentReports;
import io.github.happyusha.templating.FreemarkerTemplate;

class MarkupTemplate {
    protected static final FreemarkerTemplate ft = new FreemarkerTemplate(ExtentReports.class, "markup/", "UTF-8");
}
