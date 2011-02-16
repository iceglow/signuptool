package se.su.it.signuptool

class UserFilters {

  def filters = {
    all(controller: '*', action: '*') {
      before = {
        if (!params.lang) {
          params["lang"] = session.locale
        }
        def availLangs = ["sv_SE","en_US"]
        if(!availLangs.contains(params["lang"]))
        {
          params["lang"] = "sv_SE"
        }
      }
      after = {

      }
      afterView = {

      }
    }
  }

}
