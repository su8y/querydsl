/*
 * Copyright 2015, The Querydsl Team (http://www.querydsl.com/team)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.querydsl.core.group;

import com.querydsl.core.types.Expression;
import java.io.Serial;
import java.util.ArrayList;
import java.util.List;

/**
 * GList
 *
 * @param <T> t
 */
public class GList<T> extends AbstractGroupExpression<T, List<T>> {

  @Serial private static final long serialVersionUID = -5613861506383727078L;

  public GList(Expression<T> expr) {
    super(List.class, expr);
  }

  @Override
  public GroupCollector<T, List<T>> createGroupCollector() {
    return new GroupCollector<>() {

      private final List<T> list = new ArrayList<>();

      @Override
      public void add(T o) {
        if (o != null) {
          list.add(o);
        }
      }

      @Override
      public List<T> get() {
        return list;
      }
    };
  }
}
