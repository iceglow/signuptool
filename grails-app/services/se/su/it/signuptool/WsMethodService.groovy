package se.su.it.signuptool

import se.su.it.sukat.client.*

class WsMethodService {
    static scope = "prototype"
    boolean transactional = false

    def wsAccessService


    def findEnrolledUserByNIN(String nin) {
        try {
            def facade = wsAccessService.getFacade(EnrollmentFacade.class)
            return facade.findEnrolledUserByNIN(nin);
        }

        catch (Exception e) {
            return null
        }
    }
}