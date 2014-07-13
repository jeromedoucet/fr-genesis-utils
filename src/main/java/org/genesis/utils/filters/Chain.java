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

import java.util.List;

/**
 *
 * This class represents a chain of treatment using {@link Filter Filter} class
 * to represents treaments.
 *
 * @author jerdct
 * @param <I> the type of input for treatment
 * @since 0.1
 */
public interface Chain<I> {

    /**
     *
     * @param filter
     * @return
     */
    public Chain<I> add(Filter<I> filter);

    /**
     *
     * @param filter
     * @return
     */
    public Chain<I> addFirst(Filter<I> filter);

    /**
     *
     * @param filter
     * @return
     */
    public Chain<I> addLast(Filter<I> filter);

    /**
     *
     * Add the given filter param before the given referenceElement if it exist.
     * If not, the Filter is add at the end of the chain.
     *
     * @param filter
     * @param referenceElement
     * @return
     */
    public Chain<I> addBefore(Filter<I> filter, Filter<I> referenceElement);

    /**
     *
     * Add the given filter param after the given referenceElement if it exist.
     * If not, the Filter is add at the end of the chain.
     *
     * @param filter
     * @param referenceElement
     * @return
     */
    public Chain<I> addAfter(Filter<I> filter, Filter<I> referenceElement);

    /**
     *
     * Remove the first Element of the chain.
     *
     * @return
     */
    public Chain<I> removeFirst();

    /**
     *
     * Remove the last element of the chain.
     *
     * @return
     */
    public Chain<I> removeLast();

    /**
     *
     * Remove the element at the sepcified index if it exist. Otherwise, nothing
     * append.
     *
     * @param index
     * @return
     */
    public Chain<I> remove(int index);

    /**
     *
     * Execute the FilterChain synchronously
     *
     * @param behavior
     * @param input
     */
    public void run(ChainBehavior behavior, I input);

    /**
     * Allow to get the underlying List.
     *
     * @return the underlying List.
     */
    public List<Filter<I>> toList();

}
