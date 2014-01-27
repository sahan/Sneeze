package com.lonepulse.sneeze.assertion;

import java.util.ArrayList;
import java.util.Collections;
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

public final class Results {

	
	private List<Test> passed;
	private List<Test> failed;
	
	
	Results() {
		
		this.passed = new ArrayList<Test>();
		this.failed = new ArrayList<Test>();
	}
	
	void addPassed(Test test) {
		
		passed.add(test);
	}
	
	void addFailed(Test test) {

		failed.add(test);
	}
	
	public boolean isSuccessful() {
		
		return failed.isEmpty();
	}
	
	public List<Test> getPassed() {
		
		return Collections.unmodifiableList(passed);
	}
	
	public List<Test> getFailed() {
		
		return Collections.unmodifiableList(failed);
	}
}
