/*
 *   casmi examples
 *   http://casmi.github.com/
 *   Copyright (C) 2011, Xcoo, Inc.
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
 */
  
package casmi.graphics;

import casmi.Applet;
import casmi.AppletRunner;
import casmi.graphics.color.Color;
import casmi.graphics.color.ColorSet;
import casmi.graphics.element.Ellipse;

/**
 * Example of Graphics.
 * 
 * @author K. Nishimura
 * 
 */
public class EllipseExample extends Applet {
    
    Ellipse el = new Ellipse(500.0, 400.0, 400.0, 160.0);
        
    public void setup(){
        setSize(1024, 768);

        el.setFillColor(new Color(80, 180, 80));
        el.setStrokeColor(ColorSet.LIGHTCORAL);
        el.setStrokeWidth(3);
    }
    
    @Override
    public void draw(Graphics g) {
        g.render(el);
    }
    
    public static void main(String args[]) {
        AppletRunner.run( "casmi.graphics.EllipseExample", "Example");
    }
}
