package de.frosner.metaviz.viz

import org.scalajs.dom
import org.scalajs.dom.document
import org.scalajs.jquery.jQuery

import scala.scalajs.js
import js.JSConverters._

import de.frosner.metaviz.d3.{LinearScale, OrdinalScale, D3}

import scala.scalajs.js.annotation.JSExport

@JSExport
case class ScatterPlot[X, Y](container: dom.Node,
                             title: String,
                             config: ScatterPlotConfig,
                             points: js.Array[Point2D[X, Y]])
                            (implicit numX: Numeric[X] = null,
                             numY: Numeric[Y] = null)
  extends Visualization {

  private val (width, height) = {
    val jQueryContainer = jQuery(container)
    (jQueryContainer.width(), jQueryContainer.height())
  }

  def content: dom.Node = {
    val xData = points.map(_.x)
    val xScale = if (numX != null) {
      val xDoubleData = xData.map(x => numX.toDouble(x))
      val xMin = xDoubleData.min
      val xMax = xDoubleData.max
      val dX = xMax - xMin
      D3.scale.linear().domain(js.Array(xMin - dX * 0.01, xMax + dX * 0.01)).range(js.Array(0, width));
    } else {
      val uniqueXData = xData.toSet
      D3.scale.ordinal().domain(uniqueXData.toJSArray).rangeBands(js.Array(width, 0));
    }

    val yData = points.map(_.y)
    val yScale = if (numY != null) {
      val yDoubleData = yData.map(y => numY.toDouble(y))
      val yMin = yDoubleData.min
      val yMax = yDoubleData.max
      val dY = yMax - yMin
      D3.scale.linear().domain(js.Array(yMin - dY * 0.02, yMax + dY * 0.02)).range(js.Array(0, height));
    } else {
      val uniqueYData = yData.toSet
      D3.scale.ordinal().domain(uniqueYData.toJSArray).rangeBands(js.Array(height, 0));
    }

    val svg = document.createElement("svg")
    val svgSelection = D3.select(svg)
      .attr("width", width)
      .attr("height", height)
      .attr("class", "c3")

    val xAxis = D3.svg.axis()
      .scale(xScale)
      .orient("bottom")

    svgSelection.append("g")
      .attr("transform", s"translate(0, $height)")
      .attr("class", "x axis")
      .call(xScale)

    val yAxis = D3.svg.axis()
      .scale(yScale)
      .orient("left")

    svgSelection.append("g")
      .attr("transform", s"translate(0, 0)")
      .attr("class", "y axis")
      .call(yScale)

    svgSelection.append("g")
      .selectAll("scatter-dots")
      .data(points)
      .enter()
      .append("svg:circle")
      .attr("cx", (point: Point2D[X, Y]) => {
        if (numX != null) {
          val linear = xScale.asInstanceOf[LinearScale]
          linear(point.x)
        } else {
          val ordinal = xScale.asInstanceOf[OrdinalScale]
          val jitter = if (config.jitterEnabled) ordinal.rangeBand() * (Math.random - 0.5) * 0.4 else 0
          ordinal(point.x) + (ordinal.rangeBand() / 2) + jitter
        }
      })
      .attr("cy", (point: Point2D[X, Y]) => {
        if (numY != null) {
          val linear = yScale.asInstanceOf[LinearScale]
          linear(point.y)
        } else {
          val ordinal = yScale.asInstanceOf[OrdinalScale]
          val jitter = if (config.jitterEnabled) ordinal.rangeBand() * (Math.random - 0.5) * 0.4 else 0
          ordinal(point.y) + (ordinal.rangeBand() / 2) + jitter
        }
      })
      .attr("r", 3)

    svg
  }

}
