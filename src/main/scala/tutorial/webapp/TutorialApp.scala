package tutorial.webapp

import scala.scalajs.js.JSApp
import org.scalajs.jquery.jQuery
import org.scalajs.dom
import dom.document

object TutorialApp extends JSApp {

  def appendPar(targetNode: dom.Node, text: String): Unit = {
    val parNode = document.createElement("p")
    val textNode = document.createTextNode(text)
    parNode.appendChild(textNode)
    targetNode.appendChild(parNode)
  }

  def addClickedMessage(): Unit = {
    appendPar(document.body, "You clicked the button!")
  }

  def setupUi(): Unit = {
    appendPar(document.body, "Hello World!")
    jQuery("#click-me-button").click(addClickedMessage _)
  }

  def main(): Unit = {
    jQuery(setupUi _)
  }

}
