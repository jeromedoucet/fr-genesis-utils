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
package org.genesis.utils.creation;

import java.util.Objects;
import java.util.function.Supplier;

/**
 *
 * Builder pattern implementation.
 *
 * @author jerdct
 * @param <T> the Buildable
 * @since 0.2
 */
public class Builder<T extends Buildable> {

    /**
     *
     * Used the given supplier for getting a Buildable a build it. The
     * Supplier will permit to add some operation before calling
     * {@link Buildable#build() build()}.
     *
     * @param supplier
     * @return the Buildable
     */
    public T build(Supplier<T> supplier) {
        Objects.requireNonNull(supplier);
        T configurable = supplier.get();
        configurable.build();
        return configurable;
    }

}
