use strict;
use warnings;
use HTML::TreeBuilder;
# http://search.cpan.org/~cjm/HTML-Tree-5.03/lib/HTML/Element.pm#delete_content

my $filename = "../sample.html";
my $root = HTML::TreeBuilder->new_from_file($filename);
$root->elementify;
my ($e) = ($root->look_down(_tag => 'h2'));
my $n = $e->clone();
my ($na) = ($n->look_down(_tag => 'a'));
$na->delete_content();
$na->push_content("From Perl!");
$e->postinsert($n);
print $n->as_HTML;
# print $e->parent->as_HTML;
# print $root->as_HTML;
