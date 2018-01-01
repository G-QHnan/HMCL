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

import com.google.gson.JsonParseException;

/**
 * Check if the json object's fields automatically filled by Gson are in right format.
 *
 * @author huangyuhui
 */
public interface Validation {

    /**
     * 1. Check some non-null fields and;
     * 2. Check strings and;
     * 3. Check generic type of lists <T> and maps <K, V> are correct.
     *
     * Will be called immediately after initialization.
     * Throw an exception when values are malformed.
     *
     * @throws JsonParseException if fields are filled in wrong format or wrong type.
     */
    void validate() throws JsonParseException;
}
