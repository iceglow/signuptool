package se.su.it.signuptool.interfaces

import se.su.it.signuptool.commandobjects.AccountAndCardProcess

public interface ActivateAccountAndCardServiceI {
  boolean validateForwardAddress(String forwardAddress)
  public Map fetchLadokData(String socialSecurityNumber)
  public Map getCardOrderStatus(AccountAndCardProcess acp)
}
