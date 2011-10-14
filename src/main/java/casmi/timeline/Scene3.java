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

package casmi.timeline;

import casmi.graphics.Graphics;
import casmi.graphics.color.Color;
import casmi.graphics.color.ColorSet;
import casmi.graphics.element.Bezier;
import casmi.graphics.element.Text;
import casmi.graphics.font.Font;

/**
 * Example of Timeline.
 * 
 * @author Y. Ban
 * 
 */

public class Scene3 extends Scene{

    Bezier b1 = new Bezier(100,200,200,400,300,300,400,200);
    Bezier b2 = new Bezier(400,200,500,100,700,300,800,600);
    Bezier b3 = new Bezier(300.0,300.0,-20.0, 800.0,800.0,-100.0,
                           300.0,600.0,-50.0, 700.0,500.0,-70.0);
    
    Font f = null;
    Text t;
	
	public Scene3(int id,double time){
		setId(id);
		setTime(time);
		setup();
	}
	
	
	
	public void setup(){
			b1.setFill(false);
	        b2.setFill(false);
	        b3.setFill(false);
	        b1.setStrokeColor(new Color(200, 80, 80));
	        b2.setStrokeColor(new Color(200, 80, 80));
	        b3.setStrokeColor(new Color(80, 80, 200));
	        b1.setStrokeWidth(3);
	        b2.setStrokeWidth(3);
	        b3.setStrokeWidth(3);
	        b3.setDetail(b3.getDetail()*2);
	        
	        f = new Font("San-Serif");
	        f.setSize(70);
	        t = new Text("Bezier", f, 750, 150);
	        t.setStrokeColor(Color.color(ColorSet.WHITE));
	}
	
	public void draw(Graphics g){
		g.render(b1);
        g.render(b2);
        g.render(b3);
        g.render(t);
	}
}
