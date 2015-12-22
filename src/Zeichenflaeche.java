import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class Zeichenflaeche extends JPanel {
	private static final long serialVersionUID = 1L;

	private List<Auto> elemente = new ArrayList<Auto>();
	private Graphics bufferImageGraphics;
	private Image bufferImage;
	private int breite;
	private int hoehe;

	public Zeichenflaeche(int breite, int hoehe) {
		this.breite = breite;
		this.hoehe = hoehe;
	}

	public void add(Auto element) {
		this.elemente.add(element);
	}

	public void remove(Auto element) {
		this.elemente.remove(element);
	}

	@Override
	public void paintComponent(Graphics g) {
		if (bufferImage == null) {
			bufferImage = this.createImage(this.breite, this.hoehe);
			bufferImageGraphics = bufferImage.getGraphics();
		}
		bufferImageGraphics.clearRect(0, 0, breite, hoehe);
		for (Auto element : elemente) {
			element.zeichne(bufferImageGraphics);
		}
		g.drawImage(bufferImage, 0, 0, this);
	}

	public void zeichne(Graphics g) {
		paint(g);
	}
}