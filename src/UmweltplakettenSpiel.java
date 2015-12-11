import java.awt.Container;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

// Beachte: AutoSpiel erbt von JFrame
class UmweltplakettenSpiel extends JFrame {
	private static final long serialVersionUID = 1L;

	Zeichenflaeche zeichenflaeche;	// Zeichenfl�che, auf der gezeichnet wird
	Timer timer = new Timer();		// Timer zur regelm��igen Aktualisierung der Zeichenfl�che
	
	List<Auto> elemente = Collections.synchronizedList(new ArrayList<Auto>());

	private static final int FENSTER_BREITE = 1024;
	private static final int FENSTER_HOEHE = 786;
	private static final int FRAMERATE = 35;

	public UmweltplakettenSpiel()
	{
		// Zeichenfl�che und Oberfl�che initialisieren, bezieht sich auf die Funktionalit�t von JFrame
		super("Umweltplaketten-Spiel");
		setBounds(50, 50, FENSTER_BREITE, FENSTER_HOEHE);
		Container container = this.getContentPane();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Zeichenfl�che anlegen und dem Fenster hinzuf�gen
		zeichenflaeche = new Zeichenflaeche(FENSTER_BREITE, FENSTER_HOEHE);
		container.add(zeichenflaeche);

		// Ein erstes Beispiel. F�r das sp�tere Spiel nicht ben�tigt: 
		// Einen Neues-Auto-Button anlegen und dem Fenster anf�gen
		JButton buttonNeuesAuto = new JButton("Neues Auto");
		getContentPane().add(buttonNeuesAuto, BorderLayout.SOUTH);
		buttonNeuesAuto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				neuesAuto();
			}
		});
		
		// darstellen
		setVisible(true);

		// Ein timer-gesteuerter regelm��iger Thread zur Aktualisierung der Zeichenfl�che
		timer.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				synchronized (elemente) {
					Iterator<Auto> it = elemente.iterator();
					while (it.hasNext()) {
						Auto element = it.next();
						element.updatePosition(FRAMERATE);
						if (element.getPosX() > FENSTER_BREITE) {
							System.out.println("Auto gel�scht " + element.getName());
							it.remove();
							elemente.remove(element);
							zeichenflaeche.remove(element);
						}
					}
					zeichenflaeche.repaint();
				}
			}
		}, 1000 / FRAMERATE, 1000 / FRAMERATE);
	}
	
	// Hauptdialog anlegen
	public static void main(String arg[]) {
		new UmweltplakettenSpiel();
	}

	// Methode zum Erzeugen eines neuen Autos
	private void neuesAuto() {
		String name = "IL-SSE " + String.format("%03d", elemente.size() + 1);
		int posY = (int) (Math.random() * (FENSTER_HOEHE - 200));
		int geschwindigkeit = (int) (30 + Math.random() * 100); // 30..130 km/h
		Auto neuesAuto = new Auto(name, posY, geschwindigkeit);
		elemente.add(neuesAuto);
		zeichenflaeche.add(neuesAuto);
	}
	
	private void erzeugeBaeume(int anzahl) {
	// M�glicher Startpunkt: Definieren Sie eine Klasse Baum
	// Orientieren Sie sich an der Klasse Auto (Image "baum.png")
	// Erzeugen Sie hier 0 bis 4 Baum-Objekte und f�gen Sie sie der Zeichenfl�che hinzu
	}
}
