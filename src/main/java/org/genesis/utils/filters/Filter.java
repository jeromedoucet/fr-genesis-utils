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

/**
 *
 * A filter is a generic class design to perform actions chained in a
 * {@link  Chain Chain}.
 *
 * @author jerdct
 * @param <I> the type of input
 * @param <M> the type of metadata
 * @since 0.1
 */
public interface Filter<I, M> {

    /**
     *
     * @param input
     * @return
     */
    public FilterResult doIt(InputWrapper<I, M> input);
    
    /**
     * 
     * @param input
     */
    public void onFailure(InputWrapper<I, M> input);


}
