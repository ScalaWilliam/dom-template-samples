from copy import deepcopy
import pytest
from lxml import html

tgt_file = '../sample.html'

def dtax():
    with open(tgt_file) as f:
        return f.read()

def test_it():
    dta = dtax()
    doc = html.fromstring(dta)
    h = doc.xpath("(//h2)[1]")[0]
    nh = deepcopy(h)
    nh.xpath("a")[0].text = "Yes this is indeed me!"
    h.addnext(nh)
    result = html.tostring(doc, method='html')
    with open(tgt_file, 'w') as f:
        f.write(result)
    assert result == dta
    assert 0
