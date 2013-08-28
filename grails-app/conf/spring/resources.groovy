/*
 * Copyright (c) 2013, IT Services, Stockholm University
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice, this
 * list of conditions and the following disclaimer.
 *
 * Redistributions in binary form must reproduce the above copyright notice,
 * this list of conditions and the following disclaimer in the documentation
 * and/or other materials provided with the distribution.
 *
 * Neither the name of Stockholm University nor the names of its contributors
 * may be used to endorse or promote products derived from this software
 * without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */

import org.springframework.jndi.JndiObjectFactoryBean
import se.su.it.signuptool.WebServiceFactory
import se.su.it.svc.AccountServiceImpl
import se.su.it.svc.CardInfoServiceImpl
import se.su.it.svc.EnrollmentServiceImpl
import se.su.it.svc.Status
import se.su.it.svc.WebServiceAdminImpl
import se.su.it.svc.CardOrderServiceImpl

// Place your Spring DSL code here
beans = {
  ladokDataSource(JndiObjectFactoryBean) {
    jndiName = "java:comp/env/jdbc/ladok"
  }

  webServiceFactory(WebServiceFactory) { bean ->
    bean.singleton = true
    bean.factoryMethod = 'getInstance'
  }

  cardOrderWS(webServiceFactory) { bean ->
    bean.factoryMethod = 'getInstanceForClass'
    bean.constructorArgs = [CardOrderServiceImpl.class, grailsApplication.config.sukatsvc.cardorderservice]
  }

  accountWS(webServiceFactory) { bean ->
    bean.factoryMethod = 'getInstanceForClass'
    bean.constructorArgs = [AccountServiceImpl.class, grailsApplication.config.sukatsvc.accountservice]
  }

  cardInfoWS(webServiceFactory) { bean ->
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
