import $ivy.`org.jsoup:jsoup:1.10.1`, org.jsoup._
import java.nio.file._

val path = Paths.get("../sample.html")
val doc = Jsoup.parse(path.toFile, "UTF-8")
doc.outputSettings(new nodes.Document.OutputSettings().prettyPrint(false))
val firstheading = doc.select("h2").first()
val cloned = firstheading.clone()
cloned.select("a").first().text("From Ammonite Scala")
firstheading.after(cloned)
Files.write(path, doc.html().getBytes())
