barcode generator
=================

Simple playframework app rendering barcodes

Request parameters are (see conf/routes) :
  /{<[0-9]+>from}/{<[0-9]+>to}/{label}

eg.: http://localhost:9000/9000006001/9000006015/%My20Barcode

Dependencies
============
* Add the barbecue-1.5-beta1 jar to your /lib folder
  http://barbecue.sourceforge.net/
