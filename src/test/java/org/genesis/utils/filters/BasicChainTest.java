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

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * 
 * BasicSynchChain test class
 *
 * @author jerdct
 */
public class BasicChainTest {

    private Function<Runnable, FilterResult> successfullDoIt;
    private Function<Runnable, FilterResult> failureDoIt;
    private Consumer<Runnable> onFailureAvailable;
    private Consumer<Runnable> onFailureForbidden;

    public BasicChainTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        successfullDoIt = (Runnable r) -> {
            r.run();
            Assert.assertTrue(true);
            return () -> {
                return true;
            };
        };
        failureDoIt = (Runnable r) -> {
            r.run();
            Assert.assertTrue(true);
            return () -> {
                return false;
            };
        };
        onFailureAvailable = (Runnable r) -> {
            Assert.assertTrue(true);
        };
        onFailureForbidden = (Runnable r) -> {
            Assert.fail();
        };
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of add method, of class Chain.
     */
    @Test
    public void testAdd() {
        System.out.println("add Test");
        Filter<Runnable> filter = new GenericFilter(successfullDoIt, onFailureAvailable);
        Chain<Runnable> instance = new BasicChain();
        Chain<Runnable> result = instance.add(filter);
        assertEquals(instance, result);
        assertEquals(filter, instance.toList().get(0));
    }

    /**
     * Test of addFirst method, of class Chain.
     */
    @Test
    public void testAddFirst() {
        System.out.println("addFirst Test");
        Filter<Runnable> filter1 = new GenericFilter(successfullDoIt, onFailureAvailable);
        Filter<Runnable> filter2 = new GenericFilter(failureDoIt, onFailureAvailable);
        Chain<Runnable> instance = new BasicChain();
        Chain<Runnable> result = instance.addFirst(filter1);
        assertEquals(instance, result);
        result = instance.addFirst(filter2);
        assertEquals(instance, result);
        assertEquals(filter2, instance.toList().get(0));
    }

    /**
     * Test of addLast method, of class Chain.
     */
    @Test
    public void testAddLast() {
        System.out.println("addLast Test");
        Filter<Runnable> filter1 = new GenericFilter(successfullDoIt, onFailureAvailable);
        Filter<Runnable> filter2 = new GenericFilter(failureDoIt, onFailureAvailable);
        Chain<Runnable> instance = new BasicChain();
        Chain<Runnable> result = instance.addLast(filter1);
        assertEquals(instance, result);
        result = instance.addLast(filter2);
        assertEquals(instance, result);
        assertEquals(filter1, instance.toList().get(0));
    }

    /**
     * Test of addBefore method, of class Chain.
     */
    @Test
    public void testAddBefore() {
        System.out.println("addBefore Test");
        Filter<Runnable> filter1 = new GenericFilter(successfullDoIt, onFailureAvailable);
        Filter<Runnable> filter2 = new GenericFilter(failureDoIt, onFailureAvailable);
        Chain<Runnable> instance = new BasicChain();
        Chain<Runnable> result = instance.add(filter1);
        assertEquals(instance, result);
        result = instance.addBefore(filter2, filter1);
        assertEquals(instance, result);
        assertEquals(filter2, instance.toList().get(0));
    }

    /**
     * Test of addAfter method, of class Chain.
     */
    @Test
    public void testAddAfter() {
        System.out.println("addAfter Test");
        Filter<Runnable> filter1 = new GenericFilter(successfullDoIt, onFailureAvailable);
        Filter<Runnable> filter2 = new GenericFilter(failureDoIt, onFailureAvailable);
        Chain<Runnable> instance = new BasicChain();
        Chain<Runnable> result = instance.add(filter1);
        assertEquals(instance, result);
        result = instance.addAfter(filter2, filter1);
        assertEquals(instance, result);
        assertEquals(filter2, instance.toList().get(1));
    }

    /**
     * Test of removeFirst method, of class Chain.
     */
    @Test
    public void testRemoveFirst() {
        System.out.println("removeFirst Test");
        Filter<Runnable> filter1 = new GenericFilter(successfullDoIt, onFailureAvailable);
        Filter<Runnable> filter2 = new GenericFilter(failureDoIt, onFailureAvailable);
        Chain<Runnable> instance = new BasicChain();
        instance.add(filter1);
        instance.add(filter2);
        Chain<Runnable> result = instance.removeFirst();
        assertEquals(instance, result);
        assertEquals(filter2, instance.toList().get(0));
    }

    /**
     * Test of removeLast method, of class Chain.
     */
    @Test
    public void testRemoveLast() {
        System.out.println("removeLast Test");
        Filter<Runnable> filter1 = new GenericFilter(successfullDoIt, onFailureAvailable);
        Filter<Runnable> filter2 = new GenericFilter(failureDoIt, onFailureAvailable);
        Chain<Runnable> instance = new BasicChain();
        instance.add(filter1);
        instance.add(filter2);
        Chain<Runnable> result = instance.removeLast();
        assertEquals(instance, result);
        assertEquals(filter1, instance.toList().get(0));
    }

    /**
     * Test of remove method, of class Chain.
     */
    @Test
    public void testRemove() {
        System.out.println("remove Test");
        Filter<Runnable> filter1 = new GenericFilter(successfullDoIt, onFailureAvailable);
        Filter<Runnable> filter2 = new GenericFilter(failureDoIt, onFailureAvailable);
        Chain<Runnable> instance = new BasicChain();
        instance.add(filter1);
        instance.add(filter2);
        Chain<Runnable> result = instance.remove(0);
        assertEquals(instance, result);
        assertEquals(filter2, instance.toList().get(0));
    }

    /**
     * Test of run method, of class Chain.
     */
    @Test
    public void testRunSuccessFullAndIgnoreFailure() {
        System.out.println("RunSuccessFullAndIgnoreFailure test");
        Filter<Runnable> filter1 = new GenericFilter(successfullDoIt, onFailureForbidden);
        Filter<Runnable> filter2 = new GenericFilter(successfullDoIt, onFailureForbidden);
        Chain<Runnable> instance = new BasicChain();
        instance.add(filter1);
        instance.add(filter2);
        List<Object> count = new ArrayList<>();
        instance.run(ChainBehavior.IGNORE_FAILURE, () -> count.add(new Object()));
        Assert.assertTrue(count.size() == 2);
    }

    /**
     *
     */
    @Test
    public void testRunFailureAndIgnoreFailure() {
        System.out.println("RunFailureAndIgnoreFailure test");
        Filter<Runnable> filter1 = new GenericFilter(failureDoIt, onFailureForbidden);
        Filter<Runnable> filter2 = new GenericFilter(successfullDoIt, onFailureForbidden);
        Chain<Runnable> instance = new BasicChain();
        instance.add(filter1);
        instance.add(filter2);
        List<Object> count = new ArrayList<>();
        instance.run(ChainBehavior.IGNORE_FAILURE, () -> count.add(new Object()));
        Assert.assertTrue(count.size() == 2);
    }
    
    
    /**
     * Test of run method, of class Chain.
     */
    @Test
    public void testRunSuccessFullAndStopOnFailure() {
        System.out.println("RunSuccessFullAndIgnoreFailure test");
        Filter<Runnable> filter1 = new GenericFilter(successfullDoIt, onFailureAvailable);
        Filter<Runnable> filter2 = new GenericFilter(successfullDoIt, onFailureAvailable);
        Chain<Runnable> instance = new BasicChain();
        instance.add(filter1);
        instance.add(filter2);
        List<Object> count = new ArrayList<>();
        instance.run(ChainBehavior.STOP_ON_FAILURE, () -> count.add(new Object()));
        Assert.assertTrue(count.size() == 2);
    }

    /**
     *
     */
    @Test
    public void testRunFailureAndStopOnFailure() {
        System.out.println("RunFailureAndIgnoreFailure test");
        Filter<Runnable> filter1 = new GenericFilter(failureDoIt, onFailureAvailable);
        Filter<Runnable> filter2 = new GenericFilter(successfullDoIt, onFailureAvailable);
        Chain<Runnable> instance = new BasicChain();
        instance.add(filter1);
        instance.add(filter2);
        List<Object> count = new ArrayList<>();
        instance.run(ChainBehavior.STOP_ON_FAILURE, () -> count.add(new Object()));
        Assert.assertTrue(count.size() == 1);
    }

}
