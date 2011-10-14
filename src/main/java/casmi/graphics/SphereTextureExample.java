package casmi.graphics;

import casmi.Applet;
import casmi.AppletRunner;
import casmi.graphics.Graphics.MatrixMode;
import casmi.graphics.element.Sphere;
import casmi.graphics.element.Texture;
import casmi.matrix.Vertex;


public class SphereTextureExample  extends Applet {
    Sphere s;
    Texture earth;
    Vertex v;

   
    private int cx, cy;
    private double sx, sy;
    private double cq[] = {1.0, 0.0, 0.0, 0.0};
    private double tq[] = new double[4];
    private double rt[] = new double[16];
    
    private Vertex mousepoint;
    
    
	public void setup(){
		
		s = new Sphere(1);
        setSize(1024, 768);
        s.setStroke(false);
        earth = new Texture( getClass().getResource("/earthDiffuse.png") );
        v = new Vertex(0, 0, 10);
        rt[ 0] = rt[ 5] = rt[ 10] = rt[ 15] = 1.0;
        
          
        mousepoint = new Vertex(0,0);

	}
	
	
	@Override
	public void draw(Graphics g) {
		if(isMousePressed()==true){
			mousepoint.x=getMouseX();mousepoint.y=getMouseY();
//			System.out.println(mousepoint.x+" "+mousepoint.y);
		}
		
    	g.perspective(30,(double)getWidth()/(double)getHeight(),1.0,100);
    	sx = 1.0 / (double)getWidth();
    	sy = 1.0 / (double)getHeight();
    	g.camera(2.4, 3.2, 4.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0);
    	
    	g.matrixMode(MatrixMode.MODELVIEW);
    	g.pushMatrix();
    	{
    		trackball();
    		g.applyMatrix(rt);
    		
    		g.pushMatrix();
    		{
    			earth.enableTexture();
    			
    			g.pushMatrix();
    			{
    				g.rotateX(90);
    					g.render(s);
    			}
    			g.popMatrix();
    			
    			earth.disableTexture();

    		}
    		g.popMatrix();
    	}
    	g.matrixMode(MatrixMode.MODELVIEW);
    	g.popMatrix();
    	
	}
	
	
	private boolean track = false;
	private int fx, fy;
	private double dma,dmr;
	public void trackball(){
		if(isMouseDragged()==true){
		double dx, dy, a;
		dx = (getMouseX() - cx) * sx;
		dy = -(getMouseY() - cy) * sy;
		a = Math.sqrt(dx * dx + dy * dy);
		  if (a != 0.0) {
			    double ar = a * 2.0 * Math.PI * 0.5;
			    double as = Math.sin(ar) / a;
			    double dq[] = { Math.cos(ar), dy * as, dx * as, 0.0 }; 
			    qmul(tq, dq, cq);
			    qrot(rt, tq);
			  }
		}
		
		if(isMousePressed()==true){
			if(track == true){
				cq[0] = tq[0];
				cq[1] = tq[1];
				cq[2] = tq[2];
				cq[3] = tq[3];
				track = false;
				dma = 0;}
			cx = getMouseX();
			cy = getMouseY();
		}
		
		if(track == true && dma<0.5){
			cq[0] = tq[0];
			cq[1] = tq[1];
			cq[2] = tq[2];
			cq[3] = tq[3];
			track = false;
			dma = 0;
		}
		if(track == true){
			double dx, dy, a, dmx, dmy;
			
			dma -=0.5;
			dmx = dma*Math.cos(dmr);
			dmy = dma*Math.sin(dmr);
			
			fx+=dmx;
			fy+=dmy;
			dx = (fx - cx) * sx;
			dy = -(fy - cy) * sy;
			a = Math.sqrt(dx * dx + dy * dy);
			  if (a != 0.0) {
				    double ar = a * 2.0 * Math.PI * 0.5;
				    double as = Math.sin(ar) / a;
				    double dq[] = { Math.cos(ar), dy * as, dx * as, 0.0 }; 
				    qmul(tq, dq, cq);
				    qrot(rt, tq);
				  }
		}
		
		
		if(isMouseReleased()==true){
			double dmx,dmy;
			track = true;
			fx = getMouseX();
			fy = getMouseY();
			dmx = getPreMouseX() - getMouseX();
			dmy = getPreMouseY() - getMouseY();
			dma = Math.sqrt(dmx * dmx + dmy * dmy);
			dmr = Math.acos(dma/dmx);

			
		}
	}
	
	
	void qmul(double r[], double p[], double q[])
	{
	  r[0] = p[0] * q[0] - p[1] * q[1] - p[2] * q[2] - p[3] * q[3];
	  r[1] = p[0] * q[1] + p[1] * q[0] + p[2] * q[3] - p[3] * q[2];
	  r[2] = p[0] * q[2] - p[1] * q[3] + p[2] * q[0] + p[3] * q[1];
	  r[3] = p[0] * q[3] + p[1] * q[2] - p[2] * q[1] + p[3] * q[0];
	}
	
	void qrot(double r[], double q[])
	{
	  double x2 = q[1] * q[1] * 2.0;
	  double y2 = q[2] * q[2] * 2.0;
	  double z2 = q[3] * q[3] * 2.0;
	  double xy = q[1] * q[2] * 2.0;
	  double yz = q[2] * q[3] * 2.0;
	  double zx = q[3] * q[1] * 2.0;
	  double xw = q[1] * q[0] * 2.0;
	  double yw = q[2] * q[0] * 2.0;
	  double zw = q[3] * q[0] * 2.0;
	  
	  r[ 0] = 1.0 - y2 - z2;
	  r[ 1] = xy + zw;
	  r[ 2] = zx - yw;
	  r[ 4] = xy - zw;
	  r[ 5] = 1.0 - z2 - x2;
	  r[ 6] = yz + xw;
	  r[ 8] = zx + yw;
	  r[ 9] = yz - xw;
	  r[10] = 1.0 - x2 - y2;
	  r[ 3] = r[ 7] = r[11] = r[12] = r[13] = r[14] = 0.0;
	  r[15] = 1.0;
	}
	
	public static void main(String args[]) {
AppletRunner.run( "casmi.graphics.SphereTextureExample", "Example");
	}

}
