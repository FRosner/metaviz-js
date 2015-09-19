package de.frosner.metaviz.d3

import scala.scalajs.js

@js.native
trait OrdinalScale extends js.Object {

  def domain[D](domain: js.Array[D]): OrdinalScale = js.native

  def rangeBands(bands: js.Array[Double]): OrdinalScale = js.native

}
