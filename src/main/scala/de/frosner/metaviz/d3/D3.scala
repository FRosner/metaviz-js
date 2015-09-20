package de.frosner.metaviz.d3

import org.scalajs.dom

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

@JSName("d3")
@js.native
object D3 extends js.Object {

  val scale: ScaleFactory = js.native

  val svg: SVG = js.native

  def select(selector: String): Selection = js.native

  def select(selector: dom.Node): Selection = js.native

}
