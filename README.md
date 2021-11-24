# Jungenschaft auf der Mauer

Das ist das Repository der Speerjungenlagerjungenschaft auf der Mauer 2020+2021.

## Inhalte bearbeiten

Alle Texte befinden sich im Ordner [texte](texte). Bearbeitet dort `.md`-Dateien, haltet euch an das Markdown-Format und die Seite wird dann auch schön aussehen.
Ihr könnt die Datei, die ihr editiert, im Browser auch direkt voranschauen, indem ihr auf `Preview` klickt.

## Entwicklung

Für das Projekt wird [babashka](https://github.com/borkdude/babashka), [bootleg](https://github.com/retrogradeorbit/bootleg) und [npm](https://www.npmjs.com/) benötigt.

### Abhängigkeiten herunterladen

Die JS / CSS Abhängigkeiten werden mit folgendem Befehl installiert:

    npm install

### Projekt bauen

Die HTML Dateien werden mit folgendem Befehl erzeugt:

    bb site.clj

Danach stehen HTML-Dateien zur Verfügung, die direkt im Browser oder per Webserver (bspw. NGINX) angeschaut werden können:

    docker run --rm -p 8080:80 -v "$PWD:/usr/share/nginx/html" nginx:alpine

Danach steht die Seite unter http://localhost:8888 zur Verfügung.

### REPL

Basbashka kann einen nREPL-Server starten, mit der man sich bspw. per VSCode / VSCodium verbinden kann:

    bb --nrepl-server

## Deployment

Die Seite baut für jede Änderung im main-Branch ein neues Docker-Image, welches automatisch nach wenigen Minuten auf dem Produktivserver online gestellt wird.