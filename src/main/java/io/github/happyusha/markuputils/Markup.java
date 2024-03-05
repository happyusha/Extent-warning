package io.github.happyusha.markuputils;

import java.io.Serializable;

@FunctionalInterface
public interface Markup extends Serializable {
    String getMarkup();
}