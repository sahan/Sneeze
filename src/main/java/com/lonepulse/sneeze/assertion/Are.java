package com.lonepulse.sneeze.assertion;

import java.util.Collection;

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

public final class Are implements Criteria<Are> {

	
	private Asserter asserter;
	
	
	static Are with(Fixture fixture) {
		
		return new Are(new Asserter(fixture));
	}
	
	private Are(Asserter asserter) {
	
		this.asserter = asserter;
	}
	
	@Override
	public Are notNull() {
		
		asserter.fixture().addAssertion(new Assertion() {
			
			@Override
			public boolean on(Object target) {
			
				return target == null;
			}
		});
		
		return this;
	}
	
	public Are notEmpty() {
	
		asserter.fixture().addAssertion(new Assertion() {
			
			@Override
			public boolean on(Object target) {
				
				return target instanceof Collection && ((Collection<?>)target).isEmpty();
			}
		});
		
		return this;
	}

	@Override
	public boolean go() {
		
		return asserter.run();
	}
}
