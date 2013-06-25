package se.su.it.signuptool

import se.su.it.sucard.client.ArrayOfCardOrderVO
import se.su.it.sucard.client.CardOrderFacadePortType
import se.su.it.sucard.client.CardOrderVO

import java.rmi.Remote

class SuCardService implements Serializable {
  /** Needed if we want to use this service in the flow. */
  static transactional = false

  def configService

  se.su.it.ws.commons.Axis1WSDL2JavaWSLocator wsLocatorFactory = null
  CardOrderFacadePortType cardOrderFacade = null

  public CardOrderVO[] getCardOrdersForUser(String uid) {
    CardOrderVO[] cardOrderVOs = []

    if (uid && (uid.length() > 0)) {
      try {
        CardOrderFacadePortType facade = getCardOrderFacade()
        ArrayOfCardOrderVO  arrayOfCardOrderVO = facade.getCardOrdersForUser(uid)
        cardOrderVOs = arrayOfCardOrderVO.getCardOrderVO()
      } catch (Throwable exception) {
        log.error("Problem getting cardorders: ${exception.getMessage()}",exception)
        cardOrderVOs = []
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
        cardOrdered = false
      }
    }

    return cardOrdered
  }

  private CardOrderFacadePortType getCardOrderFacade() {
    if(!cardOrderFacade) {
      se.su.it.ws.commons.Axis1WSDL2JavaWSLocator wsLocator = getWsLocator()
      Remote serviceFacade = wsLocator.getService(CardOrderFacadePortType.class)
      cardOrderFacade = (CardOrderFacadePortType) serviceFacade
    }
    return cardOrderFacade
  }

  private se.su.it.ws.commons.Axis1WSDL2JavaWSLocator getWsLocator() {
    if (!wsLocatorFactory) {
      wsLocatorFactory = se.su.it.ws.commons.Axis1WSDL2JavaWSLocator.instance(configService.getSectionAsProperties("WS"))
    }
    return wsLocatorFactory
  }
}
