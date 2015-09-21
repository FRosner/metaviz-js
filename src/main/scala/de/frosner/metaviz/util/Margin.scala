package de.frosner.metaviz.util

import scala.scalajs.js.annotation.JSExport

case class Margin(top: Int = 0, bottom: Int = 0, right: Int = 0, left: Int = 0) {

  val vertical = top + bottom

  val horizontal = right + left

}
