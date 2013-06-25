package se.su.it.signuptool

import se.su.it.sucard.client.ArrayOfCardOrderVO
import se.su.it.sucard.client.CardOrderFacadePortType
import se.su.it.sucard.client.CardOrderVO
import se.su.it.ws.commons.WSLocatorFactory

import java.rmi.Remote

class SuCardService implements Serializable {
  /** Needed if we want to use this service in the flow. */
  static transactional = false

  def configService

  WSLocatorFactory wsLocatorFactory = null
  CardOrderFacadePortType cardOrderFacade = null

  public CardOrderVO[] getCardOrdersForUser(String uid) {
    CardOrderVO[] cardOrderVOs = null

    if (uid && (uid.length() > 0)) {

      try {
        CardOrderFacadePortType facade = getCardOrderFacade()
        ArrayOfCardOrderVO  arrayOfCardOrderVO = facade.getCardOrdersForUser(uid)
        cardOrderVOs = arrayOfCardOrderVO.getCardOrderVO()

      } catch (Throwable exception) {
        log.error("Problem getting cardorders: ${exception.getMessage()}",exception)
        return null
      }
    }

    return cardOrderVOs
  }

  public boolean orderCard(CardOrderVO cardOrderVO) {
    boolean cardOrdered = false

    if (cardOrderVO) {

      try {
        CardOrderFacadePortType facade = getCardOrderFacade()
        facade.orderCard(cardOrderVO)
        cardOrdered = true

      } catch (Throwable exception) {
        log.error("Problem ordering card: ${exception.getMessage()}",exception)
        return false
      }
    }

    return cardOrdered
  }

  private CardOrderFacadePortType getCardOrderFacade() {
    if(!cardOrderFacade) {
      WSLocatorFactory wsLocator = getWsLocator()
      Remote serviceFacade = wsLocator.getService(CardOrderFacadePortType.class)
      cardOrderFacade = (CardOrderFacadePortType) serviceFacade
    }
    return cardOrderFacade
  }

  private WSLocatorFactory getWsLocator() {
    if (!wsLocatorFactory) {
      wsLocatorFactory = WSLocatorFactory.instance(configService.getSectionAsProperties("WS"))
    }
    return wsLocatorFactory
  }
}
