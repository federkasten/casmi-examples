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
  
package casmi.graphics.color;

import casmi.Applet;
import casmi.AppletRunner;
import casmi.graphics.Graphics;
import casmi.graphics.color.Color;
import casmi.graphics.color.ColorSet;
import casmi.graphics.element.Rect;
import casmi.graphics.color.ColorMode;
import static casmi.graphics.color.ColorMode.*;

/**
 * Example of Graphics.
 * 
 * @author Y.Ban
 * 
 */
public class GraphicsExampleLerpColor extends Applet {
    
    //Rect r1 = new Rect(300, 700, 100, 300);
    //Rect r2 = new Rect(400, 700, 100, 300);
    //Rect r3 = new Rect(500, 700, 100, 300);
    //Rect r4 = new Rect(600, 700, 100, 300);
    int num = 5;
    Rect r[] = new Rect[num];
    Color from = new Color(204,152,0);
    Color to   = new Color(0,102,183);
        
    public void setup(){
        for(int i=0;i<num;i++){
            r[i] = new Rect(200+100*i, 700, 100, 300);
            r[i].setStrokeWidth(5);
            r[i].setStrokeColor(Color.color(ColorSet.WHITE));
        }
        setSize(1024, 768);
        Color fromto1 = Color.lerpColor(from, to, 0.25f);
        Color fromto2 = Color.lerpColor(from, to, 0.5f);
        Color fromto3 = Color.lerpColor(from, to, 0.75f); 
        
        r[0].setFillColor(from);
        r[1].setFillColor(fromto1);
        r[2].setFillColor(fromto2);
        r[3].setFillColor(fromto3);
        r[4].setFillColor(to);
    }
    
    @Override
    public void draw(Graphics g) {
        for(int i=0;i<num;i++)
            g.render(r[i]);
        }
    
    public static void main(String args[]) {
        AppletRunner.run( "casmi.graphics.GraphicsExampleLerpColor", "Example");
    }
}
