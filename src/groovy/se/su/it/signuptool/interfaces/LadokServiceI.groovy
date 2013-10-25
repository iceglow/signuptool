package se.su.it.signuptool.interfaces

public interface LadokServiceI {
  Map findStudentInLadok(String nin)
  String findForwardAddressSuggestionForPnr(String nin)
  Map getAddressFromLadokByPnr(String nin)
}