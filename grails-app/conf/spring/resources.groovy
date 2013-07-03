import org.springframework.jndi.JndiObjectFactoryBean
import se.su.it.signuptool.WebServiceFactory
import se.su.it.svc.AccountServiceImpl
import se.su.it.svc.CardInfoServiceImpl
import se.su.it.svc.EnrollmentServiceImpl
import se.su.it.svc.Status
import se.su.it.svc.WebServiceAdminImpl
//import se.su.it.svc.CardOrderServiceImpl

// Place your Spring DSL code here
beans = {
  ladokDataSource(JndiObjectFactoryBean) {
    jndiName = "java:comp/env/jdbc/ladok"
  }

  webServiceFactory(WebServiceFactory) { bean ->
    bean.singleton = true
    bean.factoryMethod = 'getInstance'
  }

/*  cardOrderWS(webServiceFactory) { bean ->
    bean.factoryMethod = 'getInstanceForClass'
    bean.constructorArgs = [CardOrderServiceImpl.class, grailsApplication.config.sukatsvc.cardorderservice]
  }
*/
  accountWS(webServiceFactory) { bean ->
    bean.factoryMethod = 'getInstanceForClass'
    bean.constructorArgs = [AccountServiceImpl.class, grailsApplication.config.sukatsvc.accountservice]
  }

  cardInfoServiceImpl(webServiceFactory) { bean ->
    bean.factoryMethod = 'getInstanceForClass'
    bean.constructorArgs = [CardInfoServiceImpl.class, grailsApplication.config.sukatsvc.cardinfoservice]
  }

  enrollmentWS(webServiceFactory) { bean ->
    bean.factoryMethod = 'getInstanceForClass'
    bean.constructorArgs = [EnrollmentServiceImpl.class, grailsApplication.config.sukatsvc.enrollmentservice]
  }

  statusWS(webServiceFactory) { bean ->
    bean.factoryMethod = 'getInstanceForClass'
    bean.constructorArgs = [Status.class, grailsApplication.config.sukatsvc.statusservice]
  }

  webAdminWS(webServiceFactory) { bean ->
    bean.factoryMethod = 'getInstanceForClass'
    bean.constructorArgs = [WebServiceAdminImpl.class, grailsApplication.config.sukatsvc.webserviceadmin]
  }
}