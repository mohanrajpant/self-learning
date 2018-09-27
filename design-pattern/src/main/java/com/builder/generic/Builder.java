package com.builder.generic;

import java.util.function.Consumer;


public class Builder<T> {

    private T instance;

    public Builder (Class<T> clazz) {
        try {
            instance = clazz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public Builder<T> with(Consumer<T> setter){
        setter.accept(instance);
        return this;
    }



    public T get(){
        return instance;
    }

    public static <T> Builder<T> build(Class<T> clazz) {
        return new Builder<>(clazz);
    }
}
