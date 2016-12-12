<?php
$file = "../sample.html";
$domDoc = new DOMDocument;
$domDoc->preserveWhiteSpace =true;
$domDoc->formatOutput = false;
@$domDoc->loadHTMLFile($file);
$xpath = new DOMXPath($domDoc);
$h2 = $xpath->query('//h2')->item(0);
$newH2 = $h2->cloneNode(true);
$xpath->query('a', $newH2)->item(0)->nodeValue = "From PHP!";
$h2->parentNode->insertBefore($newH2, $h2->nextSibling);
$domDoc->saveHTMLFile($file);
?>
