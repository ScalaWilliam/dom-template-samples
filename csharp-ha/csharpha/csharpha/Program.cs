using System;
using HtmlAgilityPack;

namespace csharpha
{
	class MainClass
	{
		public static void Main(string[] args)
		{
			var doc = new HtmlDocument();
			var file = "../../sample.html";
			doc.Load(file);
			var h2 = doc.DocumentNode.SelectSingleNode("//h2");
			var clonedNode = h2.CloneNode(true);
			clonedNode.SelectSingleNode("a").RemoveAll();
			clonedNode.SelectSingleNode("a").AppendChild(HtmlTextNode.CreateNode("From C#"));
			h2.ParentNode.InsertAfter(clonedNode, h2);
			doc.Save(file);
		}
	}
}
