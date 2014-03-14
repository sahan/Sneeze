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

public final class Is implements Criteria<Is> {

	
	private Asserter asserter;
	
	
	static Is with(Fixture fixture) {
		
		return new Is(new Asserter(fixture));
	}
	
	private Is(Asserter asserter) {
	
		this.asserter = asserter;
	}
	
	@Override
	public Is notNull() {
		
		asserter.fixture().addAssertion(new Assertion() {
			
			@Override
			public boolean on(Object target) {
			
				return target == null;
			}
		});
		
		return this;
	}
	
	@Override
	public Is valid(Assertion assertion) {
		
		asserter.fixture().addAssertion(assertion);
		
		return this;
	}
	
	public Is assignable(final Class<?> type) {
	
		asserter.fixture().addAssertion(new Assertion() {
			
			@Override
			public boolean on(Object target) {
				
				return type.isAssignableFrom(target.getClass());
			}
		});
		
		return this;
	}
	
	public Is equalTo(final Object object) {
		
		asserter.fixture().addAssertion(new Assertion() {
			
			@Override
			public boolean on(Object target) {
				
				return target.equals(object);
			}
		});
		
		return this;
	}

	@Override
	public boolean go() {
		
		return asserter.run();
	}
}
