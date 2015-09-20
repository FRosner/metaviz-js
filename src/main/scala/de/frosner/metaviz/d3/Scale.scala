package de.frosner.metaviz.d3

import scala.scalajs.js

@js.native
trait Scale extends js.Function {

  def apply[T](original: T): Double = js.native

}
