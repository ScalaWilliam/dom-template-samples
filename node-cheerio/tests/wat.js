let cheerio = require('cheerio');
let chai = require('chai');
let expect = chai.expect;
let fs = require('fs');
let path = '../sample.html';
describe('Meh', function() {
  it('It works', function() {
    var file = fs.readFileSync(path, "utf8");
    let $ = cheerio.load(file)
    let q = $('h2').first().clone();
    q.children('a').text('Node.Js!');
    $('h2').first().after(q);
    fs.writeFileSync(path,$.html());
    // $('h2.title').text('Hello there!')
    // $('h2').addClass('welcome')
    expect($.html()).to.equal(1);
  });
});
