package se.su.it.signuptool

import se.su.it.ws.commons.WSLocatorFactory

import java.rmi.Remote

class WsAccessService {
  def configService

  def wsl = null
  def facadeMap = [:]

  //TODO: should this be transactional?? cause this is just wrong...
  boolean transactional = false

  def getWsLocator() {
    if (wsl == null) {
      wsl = WSLocatorFactory.instance(configService.getSectionAsProperties("WS"))
    }
    return wsl
  }

  def getFacade(Class clazz) {
    def wslocator = getWsLocator()
    def ret
    synchronized (facadeMap) {
      if (!facadeMap.containsKey(clazz)) {
        Remote facade = wslocator.getService(clazz);
        facadeMap.put(clazz, facade)
      }
      ret = facadeMap.get(clazz);
    }
    return ret
  }

}
