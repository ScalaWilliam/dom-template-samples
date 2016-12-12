using NUnit.Framework;
using System;
namespace cstest
{
	[TestFixture()]
	public class Test
	{
		[Test()]
		public void TestCase()
		{
			Assert.AreEqual(5, 2 + 2);
		}
	}
}
