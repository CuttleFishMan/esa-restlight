/*
 * Copyright 2020 OPPO ESA Stack Project
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
 */
package esa.restlight.springmvc.resolver.arg;

import esa.restlight.core.method.Param;
import esa.restlight.core.resolver.ArgumentResolverFactory;
import esa.restlight.core.resolver.arg.AbstractRequestBodyArgumentResolver;
import esa.restlight.springmvc.annotation.shaded.RequestBody0;

/**
 * Implementation of {@link ArgumentResolverFactory} for resolving argument that annotated by the RequestBody.
 */
public class RequestBodyArgumentResolver extends AbstractRequestBodyArgumentResolver {

    public RequestBodyArgumentResolver() {
        super();
    }

    public RequestBodyArgumentResolver(boolean negotiation, String paramName) {
        super(negotiation, paramName);
    }

    @Override
    public boolean supports(Param param) {
        return super.supports(param) || param.hasAnnotation(RequestBody0.shadedClass());
    }

    @Override
    protected boolean required(Param param) {
        return param.hasAnnotation(RequestBody0.shadedClass())
                && RequestBody0.fromShade(param.getAnnotation(RequestBody0.shadedClass())).required();
    }


    @Override
    public int getOrder() {
        return 1000;
    }
}
