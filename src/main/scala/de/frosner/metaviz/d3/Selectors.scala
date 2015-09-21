package de.frosner.metaviz.d3

import org.scalajs.dom

import scala.scalajs.js

@js.native
trait Selectors extends js.Object {

  def select(selector: String): Selection = js.native

  def select(selector: dom.Node): Selection = js.native

  def selectAll(selector: String): Selection = js.native

  def selectAll(selector: js.Array[dom.Node]): Selection = js.native

}
