/*
 *   Copyright 2016 the original author or authors.
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 *
 */

package org.powermock.utils;

import java.util.Arrays;
import java.util.List;

public class StringJoiner {
    
    private static final String LINE_SEPARATOR = System.getProperty("line.separator");
    private static final String EMPTY_STRING = "";
    
    
    public static String join(Object... linesToBreak) {
        StringBuilder out = new StringBuilder(LINE_SEPARATOR);
        return join(out, Arrays.asList(linesToBreak), LINE_SEPARATOR);
    }
    
    public static <T> String join(List<T> list) {
        StringBuilder out = new StringBuilder(LINE_SEPARATOR);
        return join(out, list, LINE_SEPARATOR);
    }
    
    public static String join(String separator, Object... linesToBreak) {
        StringBuilder out = new StringBuilder();
        return join(out, linesToBreak, separator);
    }
    
    private static String join(StringBuilder out, Iterable linesToBreak, final String separator) {
        for (Object line : linesToBreak) {
            out.append(line.toString()).append(separator);
        }
        int lastBreak = out.lastIndexOf(separator);
        return out.replace(lastBreak, lastBreak + 1, EMPTY_STRING).toString();
    }
    
}
