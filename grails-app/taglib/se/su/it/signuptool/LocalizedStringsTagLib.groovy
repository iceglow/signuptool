package se.su.it.signuptool

class LocalizedStringsTagLib {
  static namespace = 'su'

  def localizedString = { attrs ->
    if(session.locale.equalsIgnoreCase('sv_SE')){
      if(attrs.sv)
      out << attrs.sv
      else
      out << attrs.en
    }

    if(session.locale.equalsIgnoreCase('en_US')){
      if(attrs.en){
        if(attrs.en.trim().equalsIgnoreCase("no translation")){ // fall back to swedish
          out << attrs.sv
        }

        else if(attrs.en.trim().equalsIgnoreCase("No translation available") || attrs.en.trim().contains("No transl")){ // fall back to swedish
          out << attrs.sv
        }

        else{
          out << attrs.en
        }
      }
      else //fall back to swedish if null or empty
      out << attrs.sv
    }
    return out
  }
}
