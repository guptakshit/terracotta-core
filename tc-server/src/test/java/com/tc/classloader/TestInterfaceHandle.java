/*
 *  Copyright Terracotta, Inc.
 *  Copyright Super iPaaS Integration LLC, an IBM Company 2024
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */
package com.tc.classloader;

import com.tc.util.Assert;
import java.util.List;

/**
 *
 * @author mscott
 */
public class TestInterfaceHandle implements Runnable {
  public void run() {
    List<Class<? extends TestInterface>> list = new ServiceLocator(Thread.currentThread().getContextClassLoader()).getImplementations(TestInterface.class);
     Assert.assertEquals(list.size(), 1);
     Assert.assertEquals(list.get(0).getName(), "com.tc.classloader.TestInterfaceImpl");
     Assert.assertTrue(list.get(0).getClassLoader() instanceof ComponentURLClassLoader);
     System.out.println(list.get(0).getInterfaces()[0].getClassLoader());
     Assert.assertTrue(list.get(0).getInterfaces()[0].getClassLoader() instanceof ApiClassLoader);
     Assert.assertEquals(list.get(0).getInterfaces()[0].getName(), "com.tc.classloader.TestInterface");
  }
}