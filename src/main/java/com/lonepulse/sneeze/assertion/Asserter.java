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

public final class Asserter {

	
	private Fixture fixture;
	
	
	Asserter(Fixture fixture) {
		
		this.fixture = fixture;
	}
	
	protected Fixture fixture() {
		
		return this.fixture;
	}
	
	public boolean run() {
		
		for(Object target : fixture.getTargets()) {
			
			for(Assertion assertion : fixture.getAssertions()) {
				
				if(!assertion.on(target)) {
					
					return false;
				}
			}
		}
		
		return true;
	}
}
