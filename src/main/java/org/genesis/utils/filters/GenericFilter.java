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
package org.genesis.utils.filters;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 *
 * Generic filter implementation.
 *
 * @author jerdct
 * @param <I>
 * @param <M>
 * @since 0.1
 */
public class GenericFilter<I, M> implements Filter<I, M> {

    private final Function<InputWrapper<I, M>, FilterResult> doIt;
    private final Consumer<InputWrapper<I, M>> onFailure;

    /**
     *
     * The constructor.
     *
     * @param doIt
     * @param onFailure
     */
    public GenericFilter(Function<InputWrapper<I, M>, FilterResult> doIt, Consumer<InputWrapper<I, M>> onFailure) {
        Objects.requireNonNull(doIt);
        this.doIt = doIt;
        this.onFailure = onFailure;
    }

    @Override
    public FilterResult doIt(InputWrapper<I, M> input) {
        if (input != null) {
            return doIt.apply(input);
        } else {
            return () -> {
                return false;
            };
        }
    }

    @Override
    public void onFailure(InputWrapper<I, M> input) {
        if (onFailure != null && input != null) {
            onFailure.accept(input);
        }
    }

    @Override
    public String toString() {
        return "GenericFilter{" + "doIt=" + doIt + ", onFailure=" + onFailure + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + Objects.hashCode(this.doIt);
        hash = 41 * hash + Objects.hashCode(this.onFailure);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final GenericFilter<?, ?> other = (GenericFilter<?, ?>) obj;
        if (!Objects.equals(this.doIt, other.doIt)) {
            return false;
        }
        if (!Objects.equals(this.onFailure, other.onFailure)) {
            return false;
        }
        return true;
    }

}
