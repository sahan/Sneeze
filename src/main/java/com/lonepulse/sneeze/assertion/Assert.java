package com.lonepulse.sneeze.assertion;

/*
 * #%L
 * Sneeze
 * %%
 * Copyright (C) 2014 Lonepulse
 * %%
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
 * #L%
 */

public final class Assert {
	
	
	private final Fixture fixture;
	
	
	public static Assert that(Object target) {
		
		return new Assert(target);
	}
	
	private Assert(Object target) {
		
		fixture = new Fixture();
		fixture.addTarget(target);
	}
	
	public Assert and(Object target) {
		
		fixture.addTarget(target);
		return this;
	}
	
	public Criteria<?> is() {
		
		return new Is(fixture);
	}
}
