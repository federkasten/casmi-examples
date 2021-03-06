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
import casmi.KeyEvent;
import casmi.MouseButton;
import casmi.MouseEvent;
import casmi.graphics.element.Quad;
import casmi.graphics.element.Texture;
import casmi.graphics.element.TextureRotationMode;

/**
 * Example of Graphics.
 * 
 * @author Y.Ban
 * 
 */
public class QuadTextureExample extends Applet {

    static final String IMAGE_PATH = Applet.class.getResource("logo.png").getPath();
    
    Texture tex = null;
    Quad q1 = new Quad(500, 300, 400, 500, 600, 500, 700, 300);

    @Override
    public void setup() {
        setSize(1024, 768);
        
        tex = new Texture(IMAGE_PATH);
        q1.setStroke(false);
        q1.setTexture(tex);

        addObject(q1);
    }

    @Override
    public void update() {}

    @Override
    public void mouseEvent(MouseEvent e, MouseButton b) {
        if (e == MouseEvent.PRESSED) {
            tex.rotation(TextureRotationMode.CLOCKWIZE);
        }
    }

    @Override
    public void keyEvent(KeyEvent e) {}

    public static void main(String[] args) {
        AppletRunner.run("casmi.graphics.QuadTextureExample", "QuadTextureExample");
    }

}
