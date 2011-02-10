package se.su.it.signuptool

import java.rmi.Remote;
import se.su.it.ws.commons.WSLocatorFactory
import se.su.it.sukat.client.*

class WsAccessService {
    def configService

    def wsl                 = null
    def facadeMap           = [:]

    boolean transactional = false

    def getWsLocator() {
        if(wsl == null) {
        	wsl = WSLocatorFactory.instance(configService.getSectionAsProperties("WS"))
        }
        return wsl
    }

    def getEnrollmentFacade() {
        return getFacade(EnrollmentFacade.class)
    }


    def getFacade(Class clazz, String locator, String getter) {
        def wslocator = getWsLocator()
        def ret
        synchronized (facadeMap) {
        	if(!facadeMap.containsKey(clazz)) {
        		Remote facade = wslocator.getService(clazz, locator, getter);
        		facadeMap.put(clazz, facade)
        	}
            ret = facadeMap.get(clazz)
        }
        return ret
    }

    def getFacade(Class clazz) {
        def wslocator = getWsLocator()
        def ret
        synchronized (facadeMap) {
        	if(!facadeMap.containsKey(clazz)) {
        		Remote facade = wslocator.getService(clazz);
        		facadeMap.put(clazz, facade)
        	}
            ret = facadeMap.get(clazz);
        }
        return ret
    }

}
