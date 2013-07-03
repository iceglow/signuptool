package se.su.it.signuptool

class AdminController {
  def sukatService

  def index() {
    return render(view:'index')
  }

  def foo() {
    sukatService.findAllCardOrdersForUid("mool3234")
  }
}
