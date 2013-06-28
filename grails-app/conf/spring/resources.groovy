import org.springframework.jndi.JndiObjectFactoryBean
import se.su.it.signuptool.AuditFactory
import se.su.it.signuptool.WebServiceFactory
import se.su.it.svc.AccountServiceImpl
import se.su.it.svc.EnrollmentServiceImpl
import se.su.it.svc.Status
import se.su.it.svc.WebServiceAdminImpl

// Place your Spring DSL code here
beans = {
  ladokDataSource(JndiObjectFactoryBean) {
    jndiName = "java:comp/env/jdbc/ladok"
  }

  webServiceFactory(WebServiceFactory) { bean ->
    bean.singleton = true
    bean.factoryMethod = 'getInstance'
  }

  accountWS(webServiceFactory) { bean ->
    bean.factoryMethod = 'getInstanceForClass'
    bean.constructorArgs = [AccountServiceImpl.class, grailsApplication.config.sukatsvc.accountservice]
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