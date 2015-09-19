package de.frosner.metaviz.d3

import scala.scalajs.js

@js.native
trait ScaleFactory extends js.Object {

  def linear(): LinearScale = js.native

  def ordinal(): OrdinalScale = js.native

}
