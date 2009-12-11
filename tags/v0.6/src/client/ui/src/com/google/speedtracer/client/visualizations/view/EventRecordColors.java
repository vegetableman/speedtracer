/*
 * Copyright 2009 Google Inc.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.google.speedtracer.client.visualizations.view;

import com.google.gwt.graphics.client.Color;
import com.google.speedtracer.client.model.DomBindingEvent;
import com.google.speedtracer.client.model.DomEvent;
import com.google.speedtracer.client.model.DomEventDispatch;
import com.google.speedtracer.client.model.EvalScript;
import com.google.speedtracer.client.model.GarbageCollectEvent;
import com.google.speedtracer.client.model.JavaScriptCompileEvent;
import com.google.speedtracer.client.model.JavaScriptExecution;
import com.google.speedtracer.client.model.LayoutEvent;
import com.google.speedtracer.client.model.MouseHoverStyleEvent;
import com.google.speedtracer.client.model.PaintEvent;
import com.google.speedtracer.client.model.ParseHtmlEvent;
import com.google.speedtracer.client.model.RecalcStyleEvent;
import com.google.speedtracer.client.model.TimerFiredEvent;
import com.google.speedtracer.client.model.XhrReadyStateChangeEvent;
import com.google.speedtracer.client.util.JsIntegerMap;

/**
 * Simple constants class to hold our EventRecord Type-> Color mappings for
 * charts and color coding.
 */
public class EventRecordColors {

  private static final JsIntegerMap<Color> colorMap = JsIntegerMap.<Color> create();
  private static final Color OTHER_COLOR = Color.LIGHTGREY;

  static {
    colorMap.put(DomEvent.TYPE, Color.ORANGE);
    colorMap.put(DomEventDispatch.TYPE, Color.YELLOW);
    colorMap.put(DomBindingEvent.TYPE, Color.PALE_GREEN);
    colorMap.put(JavaScriptExecution.TYPE, Color.PINK);
    colorMap.put(LayoutEvent.TYPE, Color.BLUEVIOLET);
    colorMap.put(PaintEvent.TYPE, Color.MIDNIGHT_BLUE);
    colorMap.put(ParseHtmlEvent.TYPE, Color.INDIAN_RED);
    colorMap.put(JavaScriptCompileEvent.TYPE, Color.CYAN);
    colorMap.put(TimerFiredEvent.TYPE, Color.BLUE);
    colorMap.put(XhrReadyStateChangeEvent.TYPE, Color.LIGHTGREEN);
    colorMap.put(RecalcStyleEvent.TYPE, Color.DARKGREEN);
    colorMap.put(EvalScript.TYPE, Color.PEACH);
    colorMap.put(GarbageCollectEvent.TYPE, Color.BROWN);
    colorMap.put(MouseHoverStyleEvent.TYPE, Color.LIMEGREEN);
  }

  public static Color getColorForType(int type) {
    if (colorMap.hasKey(type)) {
      return colorMap.get(type);
    } else {
      return OTHER_COLOR;
    }
  }
}