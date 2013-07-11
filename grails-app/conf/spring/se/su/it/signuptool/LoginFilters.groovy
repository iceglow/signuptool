package se.su.it.signuptool

class LoginFilters {

  def filters = {
    all(controllerExclude: 'dashboard|errorHandler', actionExclude: '*') {
      before = {
        log.debug "before $controllerName, $actionName"
        log.debug "remoteUser: ${request.remoteUser}"
        return true
        /**
         * Kolla om användaren har en
         */
      }
      after = { Map model ->
        log.debug "after $controllerName, $actionName"
      }
      afterView = { Exception e ->
        log.debug "afterview"
      }
    }
  }
}
