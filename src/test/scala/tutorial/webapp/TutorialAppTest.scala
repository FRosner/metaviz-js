package tutorial.webapp

import utest._

import org.scalajs.jquery.jQuery

object TutorialAppTest extends TestSuite {

  // Initialize App
  TutorialApp.setupUi()

  def tests = TestSuite {
    'HelloWorld {
      assert(jQuery("p:contains('Hello World')").length == 1)
    }
  }



}
