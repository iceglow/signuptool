package se.su.it.signuptool

import se.su.it.sucard.client.CardOrderFacadePortType
import se.su.it.sucard.client.CardOrderVO
import se.su.it.ws.commons.WSLocatorFactory

import java.rmi.Remote

class SuCardService {
  def configService

  WSLocatorFactory wsLocatorFactory = null
  Map<Class,Remote> facadeMap = [:]

  public CardOrderVO[] getCardOrdersForUser(String uid) {
    try {
      CardOrderFacadePortType facade = getFacade(CardOrderFacadePortType.class)
      return facade.getCardOrdersForUser(uid).getCardOrderVO()
    } catch (Throwable exception) {
      log.error("Problem getting cardorders: ${exception.getMessage()}",exception)
      return null
    }
  }

  public boolean orderCard(CardOrderVO cardOrderVO) {
    try {
      CardOrderFacadePortType facade = getFacade(CardOrderFacadePortType.class)
      facade.orderCard(cardOrderVO)
      return true
    } catch (Throwable exception) {
      log.error("Problem ordering card: ${exception.getMessage()}",exception)
      return false
    }
  }

  private WSLocatorFactory getWsLocator() {
    if (wsLocatorFactory == null) {
      wsLocatorFactory = WSLocatorFactory.instance(configService.getSectionAsProperties("WS"))
    }
    return wsLocatorFactory
  }

  private Remote getFacade(Class clazz) {
    Remote facade
    synchronized (facadeMap) {
      if (!facadeMap.containsKey(clazz)) {
        WSLocatorFactory wslocator = getWsLocator()
        Remote servicefacade = wslocator.getService(clazz);
        facadeMap.put(clazz, servicefacade)
      }
      facade = facadeMap.get(clazz);
    }
    return facade
  }
}
