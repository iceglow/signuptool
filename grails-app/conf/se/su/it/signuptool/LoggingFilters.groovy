package se.su.it.signuptool

class LoggingFilters {

    def filters = {
        all(controller:'*', action:'*') {
            before = {
              log.error "Called: $controllerName, $actionName"
            }
        }
    }
}
