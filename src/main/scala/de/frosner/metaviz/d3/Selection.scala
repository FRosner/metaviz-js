package de.frosner.metaviz.d3

import scala.scalajs.js

@js.native
trait Selection extends js.Array[js.Any] with Selectors {

  def append(toAppend: String): Selection = js.native

  def attr(attr: String, value: js.Any): Selection = js.native

  def attr[S, T](attr: String, value: js.Function1[S, T]): Selection = js.native

  def call(callback: js.Function, args: js.Any*): Selection = js.native

  def data[T](data: js.Array[T]): Selection = js.native

  def enter(): Selection = js.native

}
