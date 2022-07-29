/*
 * Copyright 2022 Miroslav Pokorny (github.com/mP1)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package walkingkooka.tree.expression.function.engineering;

import walkingkooka.tree.expression.ExpressionEvaluationContext;
import walkingkooka.tree.expression.ExpressionPurityContext;
import walkingkooka.tree.expression.FunctionExpressionName;
import walkingkooka.tree.expression.function.ExpressionFunction;

import java.util.Optional;

/**
 * Base class for many {@link ExpressionFunction} returning {@link String} within this package.
 */
abstract class StringExpressionFunction<C extends ExpressionEvaluationContext> implements ExpressionFunction<String, C> {

    /**
     * Package private to limit sub classing.
     */
    StringExpressionFunction(final String name) {
        super();
        this.name = Optional.of(
                FunctionExpressionName.with(name)
        );
    }

    @Override
    public final Optional<FunctionExpressionName> name() {
        return this.name;
    }

    private final Optional<FunctionExpressionName> name;

    /**
     * All string functions are pure. Does not assume anything about any parameters.
     */
    @Override
    public final boolean isPure(final ExpressionPurityContext context) {
        return true;
    }

    @Override
    public final Class<String> returnType() {
        return String.class;
    }

    @Override
    public final String toString() {
        return this.name()
                .get()
                .toString();
    }
}
