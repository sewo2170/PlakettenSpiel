import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Auto {
	private String name;
	private Color farbe;
	private int posX;
	private int posY;
	private int geschwindigkeit;
	private Image img = null;
	
	public Auto(String name, int posY, int geschw) {
		this.name = name;
		this.posX = -200;
		this.posY = posY;
		this.geschwindigkeit = geschw;
		this.farbe = new Color((int) (Math.random() * 255.0), (int) (Math.random() * 255.0), (int) (Math.random() * 255.0));
		try {
			img = ImageIO.read(new File("auto.png"));
		} catch (IOException e) {
			System.out.println(e.toString());
			System.exit(0);
		}
		System.out.println("Auto erzeugt " + this.name);
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getPosX() {
		return this.posX;
	}
	
	public int getPosY() {
		return this.posY;
	}
	
	public int getGeschwindigkeit() {
		return this.geschwindigkeit;
	};
	
	public void updatePosition(int framerate) {
		// Umrechnung von Geschwindigkeit in Bildschirm-Bewegung: 130km/h --> 400px/s
		int posXAenderung = (int) (1.0 / framerate * (400.0 * this.geschwindigkeit / 130.0));
		this.posX = this.posX + posXAenderung;
		System.out.println("Auto " + this.name + " bei (" + this.posX + "," + this.posY + ")");
	}
	
	public void zeichne(Graphics g) {
		g.drawImage(img, this.posX, this.posY, null);
		g.setColor(this.farbe);
		g.fillOval(this.posX + 77, this.posY + 62, 40, 40);
		g.setFont(new Font("Dialog", Font.BOLD, 18));
		g.setColor(Color.black);
		g.drawString(this.name, this.posX + 50, this.posY + 145);
	}
}
