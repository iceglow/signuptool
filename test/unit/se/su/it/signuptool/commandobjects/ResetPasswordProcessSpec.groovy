package se.su.it.signuptool.commandobjects

import spock.lang.Specification

class ResetPasswordProcessSpec extends Specification {

  /** Can't test constraints since command object constrains only works in controller tests. */

  def setup() {}
  def cleanup() {}

  def "ResetPasswordProcess extends FlowProcessBase"() {
    expect:
    ResetPasswordProcess.superclass == FlowProcessBase.class
  }
}
