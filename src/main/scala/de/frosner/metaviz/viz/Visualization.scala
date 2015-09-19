package de.frosner.metaviz.viz

import org.scalajs.dom

import scala.scalajs.js
import scala.scalajs.js.annotation.JSExport

trait Visualization {

  val container: dom.Node

  val title: String

  val config: js.Dictionary[String]

  @JSExport
  def draw(): Unit = {
    container.appendChild(content)
  }

  protected def content: dom.Node

}
