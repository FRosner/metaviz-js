package de.frosner.metaviz.d3

import scala.scalajs.js

@js.native
trait Selection extends js.Object {

  def append(toAppend: String): Selection = js.native

  def attr[T](attr: String, value: T): Selection = js.native

  def call(callback: js.Function, args: js.Any*): Selection = js.native

}
