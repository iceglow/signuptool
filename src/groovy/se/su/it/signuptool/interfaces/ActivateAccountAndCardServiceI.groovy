package se.su.it.signuptool.interfaces

import se.su.it.svc.SvcSuPersonVO

public interface ActivateAccountAndCardServiceI {
  boolean validateForwardAddress(String forwardAddress)
  public Map fetchLadokData(String socialSecurityNumber)
  public Map getCardOrderStatus(SvcSuPersonVO user)
}
