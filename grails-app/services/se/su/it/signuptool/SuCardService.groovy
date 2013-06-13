package se.su.it.signuptool

import se.su.it.sucard.client.CardOrderFacadePortType
import se.su.it.sucard.client.CardOrderVO
import se.su.it.ws.commons.WSLocatorFactory

import java.rmi.Remote

class SuCardService {
  def configService

  WSLocatorFactory wsLocatorFactory = null
  CardOrderFacadePortType cardOrderFacade = null

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
      getCardOrderFacade().orderCard(cardOrderVO)
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

  private CardOrderFacadePortType getCardOrderFacade() {
    synchronized (cardOrderFacade) {
      if(!cardOrderFacade) {
        WSLocatorFactory wsLocator = getWsLocator()
        Remote serviceFacade = wsLocator.getService(clazz)
        cardOrderFacade = (CardOrderFacadePortType) serviceFacade
      }
    }
    return cardOrderFacade
  }

}
