/**
 * Copyright (c) 2016 Robo Creative - https://robo-creative.github.io.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */
package com.robo.navigation.commands;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.robo.navigation.Command;

/**
 * Starts a certain activity on execution.
 * 
 * @author robo-admin
 * 
 */
public class StartActivity implements Command<StartActivity.Parameter>{

	@Override
	public void execute(Parameter parameter) {
		Intent intent = new Intent(parameter.source, parameter.target);
		if (null != parameter.extras) {
			intent.putExtras(parameter.extras);
		}
		parameter.source.startActivity(intent);
	}
	
	public static class Parameter {
		public Context source;
		public Bundle extras;
		public Class<?> target;

		public Parameter(Context source, Class<?> target) {
			this(source, target, null);
		}

		public Parameter(Context source, Class<?> target, Bundle extras) {
			this.source = source;
			this.target = target;
			this.extras = extras;
		}
	}
}
