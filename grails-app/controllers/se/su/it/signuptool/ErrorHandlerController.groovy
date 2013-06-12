package se.su.it.signuptool

/** TODO: Implement error specific logic for the handlers. */
class ErrorHandlerController {
  /**
   * Internal Server Error
   * @return
   */
  def on500() {
    return render(template:'genericError')
  }
  /**
   * Method Not Allowed
   * @return
   */
  def on405() {
    return render(template:'genericError')
  }
  /**
   * Not Found
   * @return
   */
  def on404() {
    return render(template:'genericError')
  }
  /**
   * Forbidden
   * @return
   */
  def on403() {
    return render(template:'genericError')
  }
  /**
   * Bad Request
   * @return
   */
  def on400() {
    return render(template:'genericError')
  }
}
