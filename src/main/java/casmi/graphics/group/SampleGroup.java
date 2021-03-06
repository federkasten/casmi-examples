/*
 *   casmi examples
 *   http://casmi.github.com/
 *   Copyright (C) 2011-2012, Xcoo, Inc.
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

package casmi.graphics.group;

import casmi.graphics.color.ColorSet;
import casmi.graphics.element.Line;
import casmi.graphics.element.Rect;
import casmi.graphics.element.Text;
import casmi.graphics.element.TextBox;
import casmi.graphics.element.Triangle;
import casmi.graphics.font.Font;
import casmi.graphics.font.FontStyle;
import casmi.tween.Tween;
import casmi.tween.TweenElement;
import casmi.tween.TweenManager;
import casmi.tween.TweenParallelGroup;
import casmi.tween.equations.Quint;
import casmi.tween.simpletweenables.TweenFloat;

/**
 * @author Y. Ban
 */
public class SampleGroup extends Group {

    Rect     r1, r2;
    Line     l1;
    Triangle t1;
    Font     f;
    Text 	 t;
    TextBox tb;
    
    TweenElement te;
    
    TweenManager manager = new TweenManager();
    
    boolean    tweenstart;
    TweenFloat tf;
    double     tx, ty;

    public SampleGroup() {
        super();
        setup();
    }

    @Override
    public void setup() {
        
        r1 = new Rect(420, 210);
        r1.setStroke(false);
        r1.setFillColor(ColorSet.LIGHT_GOLDENROD_YELLOW);
        add(r1);
        
        r2 = new Rect(420, 90);
        r2.setStroke(false);
        r2.setFillColor(ColorSet.BLACK);
        add(r2);
        
        l1 = new Line(-90, 0, 210, 0);
        l1.setStrokeColor(ColorSet.LIGHT_GOLDENROD_YELLOW);
        l1.setStrokeWidth(2);
        add(l1);
        
        t1 = new Triangle(-90, 0, -70, 0, -80, 8);
        t1.setStroke(false);
        t1.setFillColor(ColorSet.LIGHT_GOLDENROD_YELLOW);
        add(t1);
        
        f = new Font("COPPERPLATE", FontStyle.PLAIN, 14);
        
        tf = new TweenFloat(0);
        
        tx = t1.getX();
        ty = t1.getY();
        
        t1.setPosition(tx + tf.getValue(), ty);
        
        l1.set((-90 + tf.getValue()), 0, 210, 0);
        
        t = new Text("test",f);
        t.setStrokeColor(ColorSet.WHITE);
      //  add(t);
        tb = new TextBox(t,400,300);
        add(t);
    }

    @Override
    public void update() {
        
        if (isTweenstart()) {
            tf.setValue(280);
            setTweenstart(false);
            manager = new TweenManager();
            addTweenManager(manager);

            TweenParallelGroup tpg = 
                TweenParallelGroup.create(
                    Tween.to(tf, 3500, Quint.OUT).target(0)
                    );
            manager.add(tpg);

        }
        t1.setPosition(tx + tf.getValue(), ty);
        l1.set((-90 + tf.getValue()), 0, 210, 0);
    }

    public boolean isTweenstart() {
        return tweenstart;
    }

    public void setTweenstart(boolean tweenstart) {
        this.tweenstart = tweenstart;
    }
}
