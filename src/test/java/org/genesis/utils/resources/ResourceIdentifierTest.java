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

import org.genesis.utils.resources.ResourcesIdentifier;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * Units test for ResourceIdentifier class.
 *
 * @author jerdct
 */
public class ResourceIdentifierTest {

    @Test
    public void testIsTheSame() {
        
        //given
        ResourcesIdentifier stringIdentifier = ResourcesIdentifier.getIdentifier("toto");
        ResourcesIdentifier integerIdentifier = ResourcesIdentifier.getIdentifier(20);
        
        //when
        ResourcesIdentifier stringIdentifier2 = ResourcesIdentifier.getIdentifier("toto");
        ResourcesIdentifier integerIdentifier2 = ResourcesIdentifier.getIdentifier(20);
        
        //then
        Assert.assertEquals(stringIdentifier, stringIdentifier2);
        Assert.assertEquals(integerIdentifier, integerIdentifier2);
    }

    @Test
    public void testIsNotTheSame() {

        //given
        ResourcesIdentifier stringIdentifier = ResourcesIdentifier.getIdentifier("toto");
        
        //when
        ResourcesIdentifier stringIdentifier2 = ResourcesIdentifier.getIdentifier("titi");
        
        //then
        Assert.assertNotEquals(stringIdentifier, stringIdentifier2);
    }

}
