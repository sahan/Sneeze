package com.lonepulse.sneeze.assertion;

import java.util.ArrayList;
import java.util.List;

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

final class TestSuite {

	
	private List<Test> tests;
	private Fixture fixture;
	private Results results;
	
	
	TestSuite(Fixture fixture) {
	
		this.fixture = fixture;
		this.tests = new ArrayList<Test>();
	}

	void prepare() {
		
		for (Object target : fixture.getTargets()) {
			
			for (Assertion assertion : fixture.getAssertions()) {
				
				tests.add(new Test(target, assertion));
			}
		}
	}
	
	void execute() {
		
		Results results = new Results();
		
		for (Test test : tests) {
			
			if(test.run()) {
				
				results.addPassed(test);
			}
			else {
				
				results.addFailed(test);
			}
		}
	}
	
	Results getResults() {
		
		return results;
	}
}
