package se.su.it.signuptool

class SignupToolTagLib {

  static namespace = 'su'

  def passSpell = { attrs ->
      String pwd = attrs?.pwd
      String lang = attrs?.lang
      Map mapSV = [a: 'adam',
        b: 'bertil',
        c: 'ceasar',
        d: 'david',
        e: 'erik',
        f: 'filip',
        g: 'gustav',
        h: 'helge',
        i: 'ivar',
        j: 'johan',
        k: 'kalle',
        l: 'ludvig',
        m: 'martin',
        n: 'niklas',
        o: 'olof',
        p: 'petter',
        q: 'qvintus',
        r: 'rudolf',
        s: 'sigurd',
        t: 'tore',
        u: 'urban',
        v: 'viktor',
        w: 'wilhelm',
        x: 'xerxes',
        y: 'yngve',
        z: 'zäta',
        "0": 'nolla',
        "1": 'etta',
        "2": 'tvåa',
        "3": 'trea',
        "4": 'fyra',
        "5": 'femma',
        "6": 'sexa',
        "7": 'sjua',
        "8": 'åtta',
        "9": 'nia',
        A: 'Adam',
        B: 'Bertil',
        C: 'Ceasar',
        D: 'David',
        E: 'Erik',
        F: 'Filip',
        G: 'Gustav',
        H: 'Helge',
        I: 'Ivar',
        J: 'Johan',
        K: 'Kalle',
        L: 'Ludvig',
        M: 'Martin',
        N: 'Niklas',
        O: 'Olof',
        P: 'Petter',
        Q: 'Qvintus',
        R: 'Rudolf',
        S: 'Sigurd',
        T: 'Tore',
        U: 'Urban',
        V: 'Viktor',
        W: 'Wilhelm',
        X: 'Xerxes',
        Y: 'Yngve',
        Z: 'Zäta']

      Map mapEN = [a: 'alpha',
        b: 'bravo',
        c: 'charlie',
        d: 'delta',
        e: 'echo',
        f: 'foxtrot',
        g: 'golf',
        h: 'hotel',
        i: 'india',
        j: 'juliet',
        k: 'kilo',
        l: 'lima',
        m: 'mike',
        n: 'november',
        o: 'oscar',
        p: 'papa',
        q: 'quebec',
        r: 'romeo',
        s: 'sierra',
        t: 'tango',
        u: 'uniform',
        v: 'victor',
        w: 'whiskey',
        x: 'xray',
        y: 'yankee',
        z: 'zulu',
        "0": 'zero',
        "1": 'one',
        "2": 'two',
        "3": 'three',
        "4": 'four',
        "5": 'five',
        "6": 'six',
        "7": 'seven',
        "8": 'eight',
        "9": 'nine',
        A: 'Alpha',
        B: 'Bravo',
        C: 'Charlie',
        D: 'Delta',
        E: 'Echo',
        F: 'Foxtrot',
        G: 'Golf',
        H: 'Hotel',
        I: 'India',
        J: 'Juliet',
        K: 'Kilo',
        L: 'Lima',
        M: 'Mike',
        N: 'November',
        O: 'Oscar',
        P: 'Papa',
        Q: 'Quebec',
        R: 'Romeo',
        S: 'Sierra',
        T: 'Tango',
        U: 'Uniform',
        V: 'Victor',
        W: 'Whiskey',
        X: 'Xray',
        Y: 'Yankee',
        Z: 'Zulu']

      pwd.each { pwdChar ->
        out << "<tr>"
        out << "<td>" + pwdChar + "</td>"
        String tmpString = ""

        if (lang.compareTo("en") == 0) {
          tmpString = mapEN.get(pwdChar) == null ? ("\"" + pwdChar + "\"") : mapEN.get(pwdChar)
        } else {
          tmpString = mapSV.get(pwdChar) == null ? ("\"" + pwdChar + "\"") : mapSV.get(pwdChar)
        }

        out << "<td>" + tmpString + "</td>"
        out << "</tr>"
      }
      out
    }

}
