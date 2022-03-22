/*
 * Copyright (c) 2022, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package io.ballerina.stdlib.graphql.compiler.schema.types;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Represents the {@code Schema} type in GraphQL schema.
 */
public class Schema {
    private final String description;
    private final Map<String, Type> types;
    private Type queryType;
    private Type mutationType;

    public Schema(String description) {
        this.description = description;
        this.types = new LinkedHashMap<>();
    }

    public Type addType(String typeName, Type type) {
        if (this.types.containsKey(typeName)) {
            return this.types.get(typeName);
        }
        this.types.put(typeName, type);
        return type;
    }

    public boolean containsType(String name) {
        return this.types.containsKey(name);
    }

    public Type getType(String name) {
        return this.types.get(name);
    }

    public Type getQueryType() {
        return this.queryType;
    }

    public void setQueryType(Type type) {
        this.queryType = type;
    }

    public void setMutationType(Type type) {
        this.mutationType = type;
    }
}
