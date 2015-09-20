package de.frosner.metaviz.d3

import scala.scalajs.js

@js.native
trait Axis extends js.Function1[Selection, Unit] {

  def apply(selection: Selection): Unit = js.native

  def scale(scale: Scale): Axis = js.native

  def orient(orient: String): Axis = js.native

}
