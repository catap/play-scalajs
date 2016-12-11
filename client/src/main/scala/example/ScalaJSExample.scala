package example

import org.scalajs.dom
import org.scalajs.dom.raw._

import scala.scalajs.js
import scala.scalajs.js.Dynamic.global
import shared.SharedMessages

object ScalaJSExample extends js.JSApp {
  def main(): Unit = {
    if (global.console != null) {
      global.console.log(s"Welcome to your Play application with Scala JS, your shared message is: ${SharedMessages.itWorks}")
    }
    val namespaceResolver: js.Function1[String, String] = null
    dom.document.evaluate("//div[@class='wrapper' and not(@id)]/h1/a",
      dom.document, namespaceResolver, XPathResult.ANY_TYPE, null).iterateNext() match {
      case null =>
        global.alert("Something strange, I can't found the header")

      case node: Node =>
        node.textContent = s"${node.textContent} ${SharedMessages.itWorks}"
    }
  }
}