package se.su.it.signuptool

class UserFilters {
  def configService
  def authorizationService

  def filters = {
    all(controller: '*', action: '*') {
      before = {
        if (request.remoteUser && !session.user) {
          session.user = request.remoteUser?.toUid()
        }

        if (session.locale && ['sv_SE', 'en_US'].contains(session.locale)) {
          params['lang'] = session.locale
        } else {
          session.locale = 'sv_SE'
          params['lang'] = 'sv_SE'
        }
      }
      after = {

      }
      afterView = {

      }
    }

    doCheckAdminControllerAccessForUser(controller: "admin", action: '*') {
      before = {
        if (!authorizationService.hasRole(session.user, "editor") && !authorizationService.hasRole(session.user, "sysadmin") && request.remoteUser) {
          redirect(controller: 'croak', action: 'accessDenied')
          log.error "*** user ${session.user} tried to access ${controllerName} : ${actionName} but hasn't got access ***"
          return false
        }
      }
    }

    doCheckEditorAccessForUser(controller: "(info)", action: '*') {
      before = {
        if (!authorizationService.hasRole(session.user, "editor") && request.remoteUser) {
          redirect(controller: 'croak', action: 'accessDenied')
          log.error "*** user ${session.user} tried to access ${controllerName} : ${actionName} but hasn't got access ***"
          return false
        }
      }
    }

    doCheckSysAdminAccessForUser(controller: '(section|value|monitoring|feed)', action: '*') {
      before = {
        if (!authorizationService.hasRole(session.user, "sysadmin") && request.remoteUser) {
          redirect(controller: 'croak', action: 'accessDenied')
          log.error "*** user ${session.user} tried to access ${controllerName} : ${actionName} but hasn't got access ***"
          return false
        }
      }
    }
  }

}
