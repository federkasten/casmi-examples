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

import java.net.URL;

import casmi.Applet;
import casmi.AppletRunner;
import casmi.KeyEvent;
import casmi.MouseButton;
import casmi.MouseEvent;
import casmi.graphics.element.Texture;
import casmi.graphics.group.Group;

/**
 * Example of Graphics.
 * 
 * @author Y. BAN
 */
public class TextureExample extends Applet {

    static final URL IMAGE_PATH = Applet.class.getResource("logo.png");
    Texture tex;
    TexObject texo;
    double rot = 0.0;
    
    class TexObject extends Group {

        private URL IMAGE_PATH = Applet.class.getResource("logo.png");
        private Texture tex;
        private double rot = 0.0;
        
        public TexObject() {
        	tex = new Texture(IMAGE_PATH);
            tex.setPosition(200, 500);
            tex.setWidth(tex.getWidth() / 1.2);
            tex.setRotation(rot, 0.0, 1.0, 0.0);

            add(tex);
        }
    	
		@Override
		public void update() {
	        rot += 2.0;
	        tex.setRotation(rot, 0.0, 1.0, 0.0);
			
		}
    	
    }

    public void setup() {
        setSize(1024, 768);
        System.out.println(IMAGE_PATH);
        texo = new TexObject();
        addObject(texo);
     //   tex = new Texture(IMAGE_PATH);
     //   tex.setPosition(200, 500);
      //  tex.setWidth(tex.getWidth() / 1.2);
      //  tex.setRotation(rot, 0.0, 1.0, 0.0);

       // addObject(tex);
    }

    @Override
    public void update() {
      //  rot += 2.0;
     //   tex.setRotation(rot, 0.0, 1.0, 0.0);
    }

    @Override
    public void mouseEvent(MouseEvent e, MouseButton b) {}

    @Override
    public void keyEvent(KeyEvent e) {}
    
    public static void main(String[] args) {
        AppletRunner.run("casmi.graphics.TextureExample", "Texture Example");
    }

}
