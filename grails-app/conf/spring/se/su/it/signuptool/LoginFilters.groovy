package se.su.it.signuptool

class LoginFilters {

  def filters = {
    all(controllerExclude: 'dashboard|errorHandler', actionExclude: '*') {
      before = {
        log.info "before $controllerName, $actionName"
        log.info "remoteUser: ${request.remoteUser}"
        return true
        /**
         * Kolla om användaren har en
         */
      }
      after = { Map model ->
        log.info "after $controllerName, $actionName"
      }
      afterView = { Exception e ->
        log.info "afterview"
      }
    }
  }
}
