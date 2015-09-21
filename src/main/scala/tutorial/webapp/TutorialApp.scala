package tutorial.webapp

import de.frosner.metaviz.viz.{Point2D, ScatterPlotConfig, ScatterPlot}

import scala.scalajs.js
import scala.scalajs.js.JSApp
import org.scalajs.jquery.jQuery
import org.scalajs.dom
import dom.document

object TutorialApp extends JSApp {

  def main(): Unit = {
    jQuery { () =>
      val data = js.Array((1 to 10).map(v => Point2D(v, v)):_*)
      ScatterPlot(
        container = document.getElementById("container"),
        title = "Scatter Plot",
        config = ScatterPlotConfig(jitterEnabled = false),
        points = data
      ).draw()
    }
  }

}
