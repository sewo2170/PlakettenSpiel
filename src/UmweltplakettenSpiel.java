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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

// Beachte: AutoSpiel erbt von JFrame
class UmweltplakettenSpiel extends JFrame {
	private static final long serialVersionUID = 1L;
	private static final int FENSTER_BREITE = 1024;
	private static final int FENSTER_HOEHE = 786;
	private static final int FRAMERATE = 25;
	
	private Zeichenflaeche zeichenflaeche;
	private Timer timer = new Timer();
	private List<Auto> elemente = Collections.synchronizedList(new ArrayList<Auto>());
	
	public UmweltplakettenSpiel() {
		// Zeichenfläche und Oberfläche initialisieren, bezieht sich auf die Funktionalität von JFrame
		super("Umweltplaketten-Spiel");
		setBounds(50, 50, FENSTER_BREITE, FENSTER_HOEHE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container container = this.getContentPane();
		
		// Zeichenfläche anlegen und dem Fenster hinzufügen
		zeichenflaeche = new Zeichenflaeche(FENSTER_BREITE, FENSTER_HOEHE);
		container.add(zeichenflaeche);
		
		// Einen Neues-Auto-Button anlegen und dem Fenster anfügen.
		// (Für das spätere Spiel nicht benötigt, da Autos nach dem
		// Zufallsprinzip erzeugt werden sollten)
		JButton buttonNeuesAuto = new JButton("Neues Auto");
		getContentPane().add(buttonNeuesAuto, BorderLayout.SOUTH);
		buttonNeuesAuto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				neuesAuto();
			}
		});
		
		// An den Container wird ein MouseListener angehangen.
		// Dieser registriert Mauseingaben und gibt die Informationen weiter
		container.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				KlickBeiKoord(e.getX(), e.getY());
			}
		});
		
		// darstellen
		setVisible(true);
		
		// Bäume bewegen sich nicht und können daher außerhalb vom Thread erstellt werden
		erzeugeBaeume(4);
		
		// Ein timer-gesteuerter regelmäßiger Thread zur Aktualisierung der Zeichenfläche
		timer.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				loescheAutosRechts();
				aktualisiereSzene();
				zeichenflaeche.repaint();
			}
		}, (1000 / FRAMERATE), (1000 / FRAMERATE));
	}
	
	// Hauptdialog anlegen
	public static void main(String arg[]) {
		new UmweltplakettenSpiel();
	}
	
	// Methode zum Erzeugen eines neuen Autos (mit Zufallswerten)
	private void neuesAuto() {
		String name = "IL-SSE " + String.format("%03d", elemente.size() + 1);
		int posY = (int) (Math.random() * (FENSTER_HOEHE - 200));
		int geschwindigkeit = (int) (30 + Math.random() * 100); // 30..130 km/h
		Auto neuesAuto = new Auto(name, posY, geschwindigkeit);
		synchronized (elemente) {
			elemente.add(neuesAuto);
			zeichenflaeche.add(neuesAuto);
		}
	}
	
	// Lösche Autos, die rechts den Bildschirmrand verlassen haben
	private void loescheAutosRechts() {
		synchronized (elemente) {
			Iterator<Auto> it = elemente.iterator();
			while (it.hasNext()) {
				Auto auto = it.next();
				if (auto.getPosX() > FENSTER_BREITE) {
					it.remove();
					elemente.remove(auto);
					zeichenflaeche.remove(auto);
					System.out.println("Auto gelöscht " + auto.getName());
				}
			}
		}
	}
	
	private void erzeugeBaeume(int anzahl) {
		// Möglicher Startpunkt: Definieren Sie eine Klasse Baum
		// Orientieren Sie sich an der Klasse Auto (Image "baum.png")
		// Erzeugen Sie hier 'anzah' entsprechend viele Baum-Objekte
		// und fügen Sie sie der Zeichenfläche hinzu
	}
	
	// Aktualisiere die Position aller Autos
	private void aktualisiereSzene() {
		synchronized (elemente) {
			for (Auto auto : elemente) {
				auto.updatePosition(FRAMERATE);
			}
		}
	}
	
	// Reaktion auf Mausklick
	private void KlickBeiKoord(int klickX, int klickY) {
		System.out.println("Mausklick bei: (" + klickX + "," + klickY + ")");
	}
}
