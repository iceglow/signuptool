package se.su.it.signuptool

/** TODO: Implement error specific logic for the handlers. */
class ErrorHandlerController {
  def on500() {
    return render(template:'genericError')
  }
  def on404() {
    return render(template:'genericError')
  }
  def on403() {
    return render(template:'genericError')
  }
  def on400() {
    return render(template:'genericError')
  }
}
