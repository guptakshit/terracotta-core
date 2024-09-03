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

/**
 * @author vmad
 */
public class AnnotationOrDirectoryStrategyChecker implements CommonComponentChecker {
    /**
     * @param clazz to be checked
     * @return true if given class is a common component
     */
    @Override
    public boolean check(Class<?> clazz) {
        if(clazz.getClassLoader() instanceof ApiClassLoader) {
            return true;
        } else if(clazz.getAnnotation(CommonComponent.class) != null) {
            return true;
        } else {
            return false;
        }
    }
}