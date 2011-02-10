package se.su.it.signuptool

import java.lang.reflect.Constructor
import java.lang.reflect.Method
import ladok.lpw.service.register.facadeclient.RegVO
import ladok.lpw.service.register.facadeclient.PersonVO
import ladok.lpw.service.registrate.facadeclient.RegistrateVO
import ladok.lpw.service.registrate.facadeclient.CourseRegistrationVO

class LPWLadokVOService {

  Object getUserVO(String uid, String type,String userVOClassName) {
      Object user = null
      try {
          Class UserVOCL = Class.forName(userVOClassName);
          Constructor ct = UserVOCL.getConstructor();
          user = ct.newInstance();
          Method[] methlist = UserVOCL.getDeclaredMethods();
          for (int i = 0; i < methlist.length; i++)
          {
             Method m = methlist[i];
             if(m.getName() == "setPersonvo")
             {
                 Class PersonVOCL = m.getParameterTypes()[0];
                 Constructor ctp = PersonVOCL.getConstructor();
                 Object person = ctp.newInstance();
                 Object arglist = new Object[1];
                 arglist[0] = person;
                 m.invoke(user, arglist);
             }
             else if(m.getName() == "setAuthinfovo")
             {
                 Class AuthInfoVOCL = m.getParameterTypes()[0];
                 Constructor ctai = AuthInfoVOCL.getConstructor();
                 Object authinfo = ctai.newInstance();

                 Method[] authmethlist = AuthInfoVOCL.getDeclaredMethods();
                 for (int aii = 0; aii < authmethlist.length; aii++)
                 {
                      Method aim = authmethlist[aii];
                      if(aim.getName() == "setTicket")
                      {
                          Class TicketVOCL = aim.getParameterTypes()[0];
                          Constructor ctt = TicketVOCL.getConstructor();
                          Object ticket = ctt.newInstance();
                          ///
                          Method[] tickmethlist = TicketVOCL.getDeclaredMethods();
                          for (int tii = 0; tii < tickmethlist.length; tii++)
                          {
                              Method tim = tickmethlist[tii];
                              if(tim.getName() == "setTicket")
                              {
                                  Object targlist = new Object[1];
                                  targlist[0] = LPWTicketService.getTicket(uid);
                                  tim.invoke(ticket, targlist);
                              }
                          }
                          ///
                          Object targlist = new Object[1];
                          targlist[0] = ticket;
                          aim.invoke(authinfo, targlist);
                      }
                 }

                 Object arglist = new Object[1];
                 arglist[0] = authinfo;
                 m.invoke(user, arglist);
             }
             else if(m.getName() == "setUid")
             {
                 Object arglist = new Object[1];
                 arglist[0] = uid;
                 m.invoke(user, arglist);
             }
             else if(m.getName() == "setType")
             {
                 Object arglist = new Object[1];
                 arglist[0] = type;
                 m.invoke(user, arglist);
             }
          }

      } catch (Exception e) {
          log.error(e.toString())
          user = null
      }
      return user;
	}

  RegVO getRegVORegister(ssn){
    RegVO reg = new RegVO()
    PersonVO person = new PersonVO()
    person.setPnr(ssn)
    reg.setPerson(person)
    reg.setRegister(true)
    return reg
  }

  RegVO getRegVOResultat(ssn){
    RegVO reg = new RegVO()
    PersonVO person = new PersonVO()
    person.setPnr(ssn)
    reg.setPerson(person)
    reg.setResultat(true)
    return reg
  }

  RegVO getRegVOAsEmployee(ssn){
    RegVO reg = new RegVO()
    PersonVO person = new PersonVO()
    person.setPnr(ssn)
    reg.setPerson(person)
    reg.setResultat(true)
    reg.setRegister(true)
    return reg
  }

  RegistrateVO getRegistrateVO(ssn, semester, courseRegistrations) {
    RegistrateVO reg = new RegistrateVO()
    reg.setPnr(ssn)
    reg.setSemester(semester)
    reg.getCourseRegistrations().addAll(courseRegistrations as CourseRegistrationVO[])
    //reg.setCourseRegistrations(courseRegistrations as CourseRegistrationVO[])
    return reg
  }

}
