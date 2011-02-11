package se.su.it.signuptool

import org.springframework.web.context.request.RequestContextHolder

class UtilityService {

  String idp2domain(String idp) {
    if (idp =~ /studera.nu|antagning.se|umdac.se/) {
      return 'student.su.se'
    } else if (idp =~ /auth-prod-physto-idp/) {
      return 'fysik.su.se'
    }

    return null
  }

  void logFailure(org.apache.commons.logging.Log alog, Map params, Throwable ex) {
    def webRequest = RequestContextHolder.currentRequestAttributes()
    alog.error "Failure for '${webRequest?.getRemoteUser()?.toUid()}'. Parameters: ${params}.", ex
  }
}
