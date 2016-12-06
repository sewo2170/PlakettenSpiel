# Softwaretechnik Seminar

Ein Startpunkt für die Implementierung des im Seminar besprochenen Umweltplaketten-Spiels.
Vorgegeben ist die grafische Zeichenumgebung und eine minimale `Auto` Klasse.
Über einen Button kann ein von links nach rechts durchs Bild fahrendes Auto erschaffen werden.

## Ziel
Implementierung des Umweltplaketten-Spiels, so wie im Seminar besprochen.
Zusätzlich ist ein Punkte- und Level-Konzept umzusetzen.
Es sollte mindestens einen Punktestand, ein "GameOver" Kriterium und eine zunehmende Schwierigkeit geben.
Ein Highscore ist optional.
Weitere Funktionen sind Ihnen frei überlassen.

## Bewertung
Es werden nur eigenständig erstellte Lösungen bewertet.
Eine gute Lösung setzt die objektorientierten Entwurfsideen aus dem Seminar um und setzt diese bei weiteren Aspekten fort.
Der Quelltext sollte [ausreichend dokumentiert](https://de.wikipedia.org/wiki/Javadoc) sein.
Das Projekt ist innerhalb eines GitLab Repositories zu verwalten.
Eine Versionshistorie in Form von [git Commits](https://www.atlassian.com/git/tutorials/saving-changes/git-commit) wird ebenso bewertet.
Die Lösung ist inklusive eines Klassendiagramms (kann mit VisualParadigm [automatisch generiert](http://www.visual-paradigm.com/support/documents/vpuserguide/276/381/7530_generateorup.html) werden) als GitLab Repository einzureichen.
Achten Sie darauf, dass **ausschließlich** Sie und der Betreuer Leserechte auf Ihr Repository besitzen!
Es können bis zu vier Punkte verdient werden, die Lösung kann bis zum Beginn der Prüfungszeit eingereicht werden.

## Erste Schritte

1. Erstellen Sie einen Fork dieses Repositories in ihrem privaten Account. [Anleitung](https://docs.gitlab.com/ce/gitlab-basics/fork-project.html)
2. **Wichtig:** Setzen Sie die "Project Visibility" ihres Repositories auf "Private" (Zahnrad -> Edit Project -> Private -> Save changes)
3. Fügen Sie den Nutzer "thdi3787" als "Reporter" dem Projekt hinzu. [Anleitung](https://docs.gitlab.com/ce/workflow/add-user/add-user.html#add-a-user)
4. Installieren Sie git und eine git Benutzeroberfläche auf Ihrem Rechner.
  1. [git Installation](https://git-scm.com)
  2. [Mögliche git Clients](https://git-scm.com/downloads/guis), empfohlen: GitHub for Windows, GitKraken, SmartGit
5. Clonen Sie das git Repository auf Ihren Rechner. (Vorgehen abhängig von Client)

## Einrichtung der Entwicklungsumgebung

Das Projekt wurde in [eclipse](http://www.eclipse.org/downloads) vorbereitet und kann in diesem geöffnet, ausgeführt und weiterentwickelt werden.
Das geclonte Repository wird in eclipse über "File -> Import -> Existing Projects into Workspace" importiert und anschließend über "Run -> Run" ausgeführt.
Im Ergebnis sollte die oben beschriebene minimale Funktionalität nutzbar sein. 

Bei Fragen oder Problemen bitte erst Google und dann den Seminarleiter kontaktieren. Verbesserungen am Grundprojekt gern als Pull Request.

Viel Spaß!


##  Änderungen

| Datum      | Änderung      |
| ---------- | ------------- |
| 2015-12-11 | Erste Version |
| 2015-12-14 | Abhängigkeiten und Grafiken integriert |
| 2015-12-21 | MouseEvent zur Hilfe bereits beispielhaft implementiert, Quelltext aufgeräumt |
| 2016-12-06 | Umzug zu GitLab, Überarbeitete Readme |
