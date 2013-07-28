# Repp
**R**ead **E**valuate **P**rint **P**rofit

Repp stands on the shoulders of [zxing](https://code.google.com/p/zxing/) and [tesseract-ocr](https://code.google.com/p/tesseract-ocr/).

While there are native mobile apps that provide barcode scanning and/or OCR, 
Repp is a web app hence is not tied to any particular mobile OS and can be used by both: 
mobile and anything else that has a browser (i.e. potentially be a service).

## Repp in Action

Since "tesseract-ocr" is platform dependent, it needs to be [installed](https://code.google.com/p/tesseract-ocr/wiki/Compiling) 
so Repp can call into it.

Running Repp can be as simple as:
```bash
lein ring server
```

### Scan Them Barcodes

#### Phone
Take a Picture with Barcode    => Barcode Value
![Barcode Scan with a Phone](https://github.com/tolitius/repp/blob/master/doc/mobile-barcode-scan.gif?raw=true)

#### Browser
Select a Picture with Barcode  => Barcode Value
![Barcode Scan with a Browser](https://github.com/tolitius/repp/blob/master/doc/browser-barcode-scan.gif?raw=true)

### OCR That Text

#### Phone
Take a Picture with Text    => OCR it
![OCR with a Phone](https://github.com/tolitius/repp/blob/master/doc/mobile-ocr.gif?raw=true)

#### Browser
Select a Picture with Text  => OCR it
![OCR with a Browser](https://github.com/tolitius/repp/blob/master/doc/browser-ocr.gif?raw=true)

## License

Copyright © 2013 tolitius

Distributed under the Eclipse Public License, the same as Clojure.

