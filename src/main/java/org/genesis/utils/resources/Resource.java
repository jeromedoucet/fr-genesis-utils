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
package org.genesis.utils.resources;

/**
 *
 * Dummy class that represents a generic resource.
 *
 *
 * @author jerdct
 * @param <I>
 * @param <R>
 */
public final class Resource<I, R> {

    private final ResourcesIdentifier<I> identifier;
    private final R resource;

    /*
     * private constructor. Must use buildResource() instead.
     */
    private Resource(I identifier, R resource) {
        this.identifier = ResourcesIdentifier.getIdentifier(identifier);
        this.resource = resource;
    }

    /**
     * 
     * Allow to get the immutable identifier identifier
     *
     * @return the identifier
     */
    public ResourcesIdentifier<I> getIdentifier() {
        return identifier;
    }
    
    /**
     * Allow to get the resourceData
     * @return the resourceData
     */
    public R getResourceData(){
        return resource;
    }
    
    /**
     * 
     * static factory method
     * 
     * @param <N> type of the identifier
     * @param <V> type of the resource data
     * @param identifier the Object that must identify the resource
     * @param resource the resources data
     * @return the Resource
     */
    public static <N, V> Resource<N, V> buildResource(N identifier, V resource) {
        return new Resource(identifier, resource);
    }
    
    

}
