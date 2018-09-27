package com.decorator;

import java.awt.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;

public class Camera {
    private Function<Color, Color> filter;

    public Camera() {
        setFilters();
    }

    public Color capture(Color inputColor) {
        return filter.apply(inputColor);
    }

    public void setFilters(Function<Color, Color> ... filters) {
        filter = Stream.of(filters)
            .reduce(Function.identity(), Function::compose);
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        final Camera camera = new Camera();
        final Consumer<String> printCaptured  = (filterInfo) ->
            System.out.println(String.format("with %s: %s", filterInfo, camera.capture(new Color(200, 100, 200))));

        printCaptured.accept("no input");

        camera.setFilters(Color::brighter);
        printCaptured.accept("brightness");
    }
}
