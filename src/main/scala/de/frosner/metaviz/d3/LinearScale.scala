package de.frosner.metaviz.d3

import scala.scalajs.js

@js.native
trait LinearScale extends Scale {

  def domain(domain: js.Array[Double]): LinearScale = js.native

  def range(range: js.Array[Double]): LinearScale = js.native

}
