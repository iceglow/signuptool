package se.su.it.signuptool.stubs

import groovy.util.logging.Slf4j
import se.su.it.signuptool.interfaces.ActivateAccountAndCardServiceI
import se.su.it.svc.SvcSuPersonVO

@Slf4j
class ActivateAccountAndCardServiceStub implements ActivateAccountAndCardServiceI {

  @Override
  boolean validateForwardAddress(String forwardAddress) {
    log.info "validateForwardAddress: intercepting request for $forwardAddress"
    boolean valid = true
    log.info "validateForwardAddress: returning response => $valid"
    return valid
  }

  @Override
  Map fetchLadokData(String socialSecurityNumber) {
    log.info "fetchLadokData: Intercepted request for $socialSecurityNumber"
    Map response = [:]
    switch(socialSecurityNumber) {
      case "BROKEN_STUB":
        response = [tnamn:'a', enamn:'b']
        break
      case "NEW_USER_FROM_STUB":
        response = [tnamn:'a', enamn:'b']
        break
      case "NEW_USER_FROM_SCRATCH":
        response = [tnamn:'tnamn', enamn:'enamn']
        break
      default:
        break
    }

    log.info "fetchLadokData: Returning response => $response"
    return response
  }

  @Override
  Map getCardOrderStatus(SvcSuPersonVO user) {
    log.info "getCardOrderStatus: Intercepted request for $user.uid"
    Map response = null

    final Map genericLadokAddr = [gatadr:'Testgatan 1', coadr:'Box 1', postnr:'100 00', ort:'Stockholm' ]

    if (user) {
      switch(user.uid) {
        case "MISSING_ADDRESS":
          response = [canOrderCard: false, hasAddress:false, suCards: true, cardOrders: true]
          break
        case "HAS_ACTIVE_CARDS":
          response = [canOrderCard: false, hasAddress:true, suCards: false, cardOrders: true]
          break
        case "HAS_CARD_ORDERS":
          response = [canOrderCard: false, hasAddress:true, suCards:true, cardOrders: false]
          break
        case "CARD_ORDER_FAILS":
          response = [canOrderCard: true, hasAddress:true, suCards:true, cardOrders: true,
              ladokAddress:genericLadokAddr]
          break
        case "CARD_ORDER_SUCCEEDS":
          response = [canOrderCard: true, hasAddress:true, suCards:true, cardOrders: true,
              ladokAddress:genericLadokAddr]
          break
        default:
          log.info "Unhandled uid: $user.uid"
      }
    }

    log.info "getCardOrderStatus: Returning => $response"
    return response
  }
}
