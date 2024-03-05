package io.github.happyusha.gson;

import io.github.happyusha.append.ScreenCaptureTypeAdapter;
import io.github.happyusha.model.Media;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonExtentTypeAdapterBuilder {

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        GsonBuilder builder = new GsonBuilder();

        public Builder withGsonTypeAdapterFactory() {
            builder.registerTypeAdapterFactory(new GsonTypeAdapterFactory());
            return this;
        }

        public Builder withScreenCaptureTypeAdapter() {
            builder.registerTypeAdapter(Media.class, new ScreenCaptureTypeAdapter());
            return this;
        }

        public Gson build() {
            return builder.create();
        }

    }

}
