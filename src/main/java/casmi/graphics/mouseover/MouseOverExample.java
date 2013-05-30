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

package casmi.graphics.mouseover;

import casmi.Applet;
import casmi.AppletRunner;
import casmi.CursorMode;
import casmi.KeyEvent;
import casmi.MouseButton;
import casmi.MouseEvent;
import casmi.graphics.color.ColorSet;
import casmi.graphics.element.Arc;
import casmi.graphics.element.Element;
import casmi.graphics.element.Ellipse;
import casmi.graphics.element.MouseClickCallback;
import casmi.graphics.element.MouseOverCallback;
import casmi.graphics.element.Quad;
import casmi.graphics.element.Rect;
import casmi.graphics.element.RoundRect;
import casmi.graphics.element.Triangle;

/**
 * Example of MouseOver and MouseClick.
 *
 * @author Y. Ban
 *
 * @see casmi.graphics.element.MouseOverCallback
 * @see casmi.graphics.element.MouseClickCallback
 * @see casmi.graphics.element.Element#addMouseEventCallback(casmi.graphics.element.MouseEventCallback)
 */
public class MouseOverExample extends Applet {

    Rect rect;
    Ellipse ellipse;
    Triangle triangle1, triangle2;
    Quad quad;
    Arc arc;
    RoundRect roundRect;

    @Override
    public void setup() {
        setSize(1024, 768);

        MouseOverCallback mouseover = new MouseOverCallback() {

            @Override
            public void run(MouseOverTypes eventtype, Element element) {
                switch (eventtype) {
                case ENTERED:
                    if (element == rect)
                        setCursor(CursorMode.HAND);
                    else if (element == ellipse)
                        setCursor(CursorMode.CROSS);
                    else if (element == triangle1)
                        setCursor(CursorMode.CROSS);
                    else if (element == triangle2)
                        setCursor(CursorMode.TEXT);
                    else if (element == arc || element == quad)
                        setCursor(CursorMode.WAIT);
                    else if (element == roundRect)
                        setCursor(CursorMode.HAND);
                    break;
                case EXITED:
                    setCursor(CursorMode.DEFAULT);
                    break;
                default:
                    break;
                }
            }
        };

        MouseClickCallback mouseclick = new MouseClickCallback() {

            @Override
            public void run(MouseClickTypes eventtype, Element element) {
                if (eventtype == MouseClickTypes.DRAGGED) {
                    element.setPosition(element.getX() + getMouseX() - getPrevMouseX(),
                        element.getY() + getMouseY() - getPrevMouseY());
                }
            }
        };

        rect = new Rect(800, 500, 200, 150);
        rect.setFillColor(ColorSet.ORANGE);
        rect.setStroke(false);
        rect.addMouseEventCallback(mouseover);
        rect.addMouseEventCallback(mouseclick);
        addObject(rect);

        ellipse = new Ellipse(150, 300, 100, 150);
        ellipse.setStrokeColor(ColorSet.LIGHT_BLUE);
        ellipse.setFill(false);
        ellipse.addMouseEventCallback(mouseover);
        ellipse.addMouseEventCallback(mouseclick);
        addObject(ellipse);

        triangle1 = new Triangle(500, 100, 600, 250, 650, 50);
        triangle1.setFillColor(ColorSet.LAVENDER);
        triangle1.setStroke(false);
        triangle1.addMouseEventCallback(mouseover);
        triangle1.addMouseEventCallback(mouseclick);
        addObject(triangle1);

        triangle2 = new Triangle(400, 500, 500, 700, 550, 550);
        triangle2.setFillColor(ColorSet.LEMON_CHIFFON);
        triangle2.addMouseEventCallback(mouseover);
        triangle2.addMouseEventCallback(mouseclick);
        addObject(triangle2);

        quad = new Quad(20, 600, 70, 550, 200, 630, 80, 680);
        quad.setStrokeColor(ColorSet.AQUA);
        quad.setFill(false);
        quad.addMouseEventCallback(mouseover);
        quad.addMouseEventCallback(mouseclick);
        addObject(quad);

        arc = new Arc(800, 100, 70, 30, 100, 30);
        arc.setStroke(false);
        arc.setFillColor(ColorSet.OLIVE_DRAB);
        arc.addMouseEventCallback(mouseover);
        arc.addMouseEventCallback(mouseclick);
        addObject(arc);

        roundRect = new RoundRect(10, 200, 100, 100, 60);
        roundRect.setStroke(false);
        roundRect.setFillColor(ColorSet.GOLD);
        roundRect.setRadius(20);
        roundRect.addMouseEventCallback(mouseover);
        roundRect.addMouseEventCallback(mouseclick);
        addObject(roundRect);
    }

    @Override
    public void update() {}

    @Override
    public void mouseEvent(MouseEvent e, MouseButton b) {}

    @Override
    public void keyEvent(KeyEvent e) {}

    public static void main(String[] args) {
        AppletRunner.run("casmi.graphics.mouseover.MouseOverExample", "MouseOverExample");
    }
}
