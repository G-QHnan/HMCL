/*
 * Hello Minecraft! Launcher.
 * Copyright (C) 2017  huangyuhui <huanghongxun2008@126.com>
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see {http://www.gnu.org/licenses/}.
 */
package org.jackhuang.hmcl.util;

import java.util.Objects;
import java.util.function.Consumer;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

/**
 *
 * @author huangyuhui
 */
public class ImmediateStringProperty extends SimpleStringProperty {

    @Override
    public void set(String newValue) {
        super.get();
        super.set(newValue);
    }

    @Override
    public void bind(ObservableValue<? extends String> newObservable) {
        super.get();
        super.bind(newObservable);
    }

    @Override
    public void unbind() {
        super.get();
        super.unbind();
    }

    private Consumer<String> listener = Lang.EMPTY_CONSUMER;
    private final ChangeListener<String> changeListener = (a, b, newValue) -> listener.accept(newValue);

    public void setChangedListener(Consumer<String> listener) {
        this.listener = Objects.requireNonNull(listener);
    }

    public ImmediateStringProperty(Object bean, String name, String initialValue) {
        super(bean, name, initialValue);
        addListener(changeListener);
    }
}
