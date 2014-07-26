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
 * Wrapper used for input Object in a {@ref Filter Filter }.
 *
 * @author jerdct
 * @param <I> the input type
 * @param <M> the metadata type
 */
public class InputWrapper <I, M>{
    
    private final I input;
    private final M metadata;
    
    /**
     * Basically the constructor.
     * 
     * @param input 
     * @param metadata 
     */
    public InputWrapper(I input, M metadata){
        this.input = input;
        this.metadata = metadata;
    }
    
    /**
     * 
     * Get the wrapped Input.
     * 
     * @return the wrapped input
     */
    public I getInput(){
        return input;
    }
    
    
    /**
     * 
     * Get the wrapped Metadata.
     * 
     * @return 
     */
    public M getMetadata(){
        return metadata;
    }
    
}
