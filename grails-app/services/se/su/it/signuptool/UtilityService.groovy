package se.su.it.signuptool

import org.springframework.web.context.request.RequestContextHolder

class UtilityService {

  void logFailure(org.apache.commons.logging.Log alog, Map params, Throwable ex) {
    def webRequest = RequestContextHolder.currentRequestAttributes()
    alog.error "Failure for '${webRequest?.getRemoteUser()?.toUid()}'. Parameters: ${params}.", ex
  }
}
