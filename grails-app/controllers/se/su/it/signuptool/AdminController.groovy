package se.su.it.signuptool

class AdminController {

    def index = {
      try {
        String fmt='EEE, d MMM yyyy HH:mm:ss Z';
        java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat(fmt);
        String apa='Fri, 25 Mar 2011 12:10:12 +0000'
        java.util.Date lisa = formatter.parse(apa);
        System.out.println(lisa);
      } catch (Exception e) {}
    }

}
