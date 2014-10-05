/*
 * Copyright 2014 jerdct.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package fr.genesis.utils.filters;

/**
 *
 * The result of a {@link Filter#filter(java.lang.Object) filter()} call.
 *
 * @author jerdct
 * @since 0.1
 */
@FunctionalInterface
public interface FilterResult {

    /**
     *
     * Allow to simply get the result.
     *
     * @return true if success, false otherwise
     */
    public boolean isSuccess();

}
