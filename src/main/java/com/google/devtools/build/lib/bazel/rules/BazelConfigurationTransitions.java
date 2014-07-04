// Copyright 2014 Google Inc. All rights reserved.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//    http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.devtools.build.lib.bazel.rules;

import com.google.devtools.build.lib.packages.Attribute;
import com.google.devtools.build.lib.packages.Attribute.ConfigurationTransition;
import com.google.devtools.build.lib.packages.Rule;
import com.google.devtools.build.lib.packages.Target;
import com.google.devtools.build.lib.view.config.BuildConfiguration;
import com.google.devtools.build.lib.view.config.BuildConfigurationCollection;
import com.google.devtools.build.lib.view.config.BuildConfigurationCollection.ConfigurationHolder;

import java.util.Map;

/**
 * A simple implementation of configuration transitions.
 */
public class BazelConfigurationTransitions extends BuildConfigurationCollection.Transitions {
  public BazelConfigurationTransitions(BuildConfiguration configuration,
      Map<ConfigurationTransition, ConfigurationHolder> transitionTable) {
    super(configuration, transitionTable);
  }

  @Override
  public BuildConfiguration configurationHook(Rule fromTarget,
      Attribute attribute, Target toTarget, BuildConfiguration toConfiguration) {
    return toConfiguration;
  }

  @Override
  public BuildConfiguration toplevelConfigurationHook(Target toTarget) {
    return configuration;
  }
}
