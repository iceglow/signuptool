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

package se.su.it.signuptool

import org.apache.cxf.endpoint.Client
import org.apache.cxf.frontend.ClientProxy
import org.apache.cxf.interceptor.LoggingInInterceptor
import org.apache.cxf.interceptor.LoggingOutInterceptor
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean
import spock.lang.Ignore
import spock.lang.IgnoreRest
import spock.lang.Specification

class WebServiceFactorySpec extends Specification {

  /** TODO: See if we can remove some metaClass overrides and replace with GroovySpy */

  void setup() {

  }

  void cleanup() {
    WebServiceFactory.metaClass = null
  }

  void "getInstance"() {
    expect:
    WebServiceFactory.getInstance() instanceof WebServiceFactory
  }

  void "getInstance: assert singleton instance"() {
    expect:
    WebServiceFactory.getInstance() == WebServiceFactory.getInstance()
  }

  void "getInstanceForClass: no class returns null."() {
    expect:
    null == WebServiceFactory.getInstance().getInstanceForClass(null, 'someUrl')
  }

  void "getInstanceForClass: no url returns null."() {
    expect:
    null == WebServiceFactory.getInstance().getInstanceForClass(Object, null)
  }

  void "getInstanceForClass: calls factory method and returns the result."() {
    given:
    WebServiceFactory.metaClass.static.getInstance = {
      return new WebServiceFactory()
    }
    WebServiceFactory.metaClass.getFactory = { Class arg1, String arg2 ->
      return 'someFactory'
    }
    expect:
    'someFactory' == WebServiceFactory.getInstance().getInstanceForClass(Object, 'someUrl')
  }

  void "getFactory: Test the cache."() {
    given:
    WebServiceFactory.instance.webServiceMap.put('java.lang.Object', 'foo')

    expect:
    'foo' == WebServiceFactory.getInstance().getFactory(Object, 'someUrl')
  }

  void "getFactory: Test creating a new factory."() {
    given:
    WebServiceFactory.metaClass.createNewFactory = { Class arg1, String arg2 ->
      return 'foo'
    }

    expect:
    'foo' == WebServiceFactory.getInstance().getFactory(Object, 'someUrl')
  }

  void "createNewFactory: when getFactoryInstance fails"() {
    given:
    WebServiceFactory.metaClass.getFactoryInstance = { Class arg1, String arg2 ->
      throw new RuntimeException('foo')
    }

    expect:
    null == WebServiceFactory.getInstance().createNewFactory(Object, 'someUrl')
  }

  void "createNewFactory: when configuring client fails"() {
    given:
    WebServiceFactory.metaClass.createNewFactory = { Class arg1, String arg2 ->
      return 'foo'
    }

    WebServiceFactory.metaClass.configureClientProxy = { Client arg1 ->
      throw new RuntimeException('runtimeException!')
    }

    expect:
    'foo' == WebServiceFactory.getInstance().getFactory(Object, 'someUrl')
  }

  void "getFactoryInstance: Check JaxWs bean factory method"() {
    when:
    def resp = WebServiceFactory.getInstance().getFactoryInstance(Object, 'someUrl')

    then:
    resp.getServiceClass() == Object
    resp.getAddress() == 'someUrl'
    resp.getInInterceptors().first() instanceof LoggingInInterceptor
    resp.getOutInterceptors().first() instanceof LoggingOutInterceptor
  }
}
