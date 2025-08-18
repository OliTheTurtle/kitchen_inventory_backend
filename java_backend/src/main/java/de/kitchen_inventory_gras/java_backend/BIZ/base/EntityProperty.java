package de.kitchen_inventory_gras.java_backend.BIZ.base;

import java.util.function.Consumer;

public class EntityProperty<T> {
    private T value;
    private Consumer<T> onChange;

    public EntityProperty(T initialValue, Consumer<T> onChange) {
        this.value = initialValue;
        this.onChange = onChange;
    }

    public T get() {
        return value;
    }

    public void set(T newValue) {
        this.value = newValue;
        if (onChange != null) {
            onChange.accept(newValue);
        }
    }
}
