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

import java.util.Objects;

/**
 *
 * Genericidentifier for REST resources.
 *
 * Note that this class is immutable.
 *
 * @author jerdct
 * @param <T>
 */
public final class ResourcesIdentifier<T> {

    private final T id;


    /**
     * The constructor.
     *
     * @param id the identifier value
     */
    private ResourcesIdentifier(T id) {
        this.id = id;
    }

    /**
     *
     * Static initializer for ResourcesIdentifier class. Allow to use a caching
     * strategy
     *
     * @param <V> the type wrapped by the identifier
     * @param id the value of the identifier itself.
     * @return
     */
    protected static <V> ResourcesIdentifier<V> getIdentifier(V id) {
        return new ResourcesIdentifier<>(id);
    }

    /**
     *
     * @return the underlying identifying value.
     */
    public T getUnderlyingValue() {
        return id;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.id);
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
        final ResourcesIdentifier<?> other = (ResourcesIdentifier<?>) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
