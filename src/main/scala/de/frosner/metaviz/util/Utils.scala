package de.frosner.metaviz.util

import org.scalajs.dom
import org.scalajs.dom.document

object Util {

  def generateElement(parent: dom.Node, id: String, tagName: String): dom.Element = {
    val element = document.createElement(tagName)
    element.id = id
    parent.appendChild(element)
    element
  }

  def generateDiv(parent: dom.Node, id: String): dom.Element = {
    generateElement(parent, id, "div")
  }

  def generateSpan(parent: dom.Node, id: String): dom.Element = {
    generateElement(parent, id, "span")
  }

  def generateTextInput(parent: dom.Node, id: String): dom.Element = {
    val input = generateElement(parent, id, "input")
    input.setAttribute("type", "text")
    input
  }

}
