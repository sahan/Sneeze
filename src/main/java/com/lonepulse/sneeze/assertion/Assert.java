package com.lonepulse.sneeze.assertion;

import java.util.ArrayList;
import java.util.Collection;
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

public final class Assert {
	
	
	private List<Object> targets;
	
	
	public static Assert that(Object target) {
		
		return new Assert(target);
	}
	
	private Assert(Object target) {
		
		targets = new ArrayList<Object>();
		targets.add(target);
	}
	
	public Assert and(Object target) {
		
		targets.add(target);
		return this;
	}
	
	public Is is() {
		
		Fixture fixture = new Fixture();
		
		for (Object target : targets) {
			
			if(target instanceof Collection) {
				
				for (Object element : (Collection<?>)target) {
					
					fixture.addTarget(element);
				}
			}
			else {
				
				fixture.addTarget(target);
			}
		}
		
		return Is.with(fixture);
	}
	
	public Are are() {
		
		Fixture fixture = new Fixture();
		
		for (Object target : targets) {
		
			fixture.addTarget(target);
		}
		
		return Are.with(fixture);
	}
}
