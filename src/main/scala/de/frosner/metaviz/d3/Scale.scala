package de.frosner.metaviz.d3

import scala.scalajs.js

@js.native
trait Scale extends js.Function {

  def apply(original: Double): Double = js.native

}
