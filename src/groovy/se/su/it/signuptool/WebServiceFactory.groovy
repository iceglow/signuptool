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

import com.googlecode.concurrentlinkedhashmap.ConcurrentLinkedHashMap
import groovy.time.TimeCategory
import groovy.util.logging.Slf4j
import org.apache.cxf.configuration.security.AuthorizationPolicy
import org.apache.cxf.endpoint.Client
import org.apache.cxf.frontend.ClientProxy
import org.apache.cxf.interceptor.LoggingInInterceptor
import org.apache.cxf.interceptor.LoggingOutInterceptor
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean
import org.apache.cxf.transport.http.HTTPConduit
import org.apache.cxf.transports.http.configuration.HTTPClientPolicy

@Slf4j
class WebServiceFactory {

  private static final int DEFAULT_CONNECTION_TIMEOUT = 10000
  private static final int DEFAULT_RECEIVE_TIMEOUT = 10000
  private static final String DEFAULT_AUTH_TYPE = "Negotiate"

  final private static WebServiceFactory instance = new WebServiceFactory()

  final private static ConcurrentLinkedHashMap<String, Object> webServiceMap =
    new ConcurrentLinkedHashMap.Builder<String, Object>().maximumWeightedCapacity(1000).build();

  public WebServiceFactory() {
  }

  public static WebServiceFactory getInstance() {
    return instance
  }

  /** This method is not unused, it's used from resources.groovy as factory method */
  private Object getInstanceForClass(Class cz, String url) {

    if (!cz) {
      log.error "No class defined."
      return null
    }

    if (!url) {
      log.error "No url defined."
      return null
    }

    return getFactory(cz, url)
  }

  private Object getFactory(Class cz, String url) {
    final Date startTime = new Date()

    def theFactory = webServiceMap.get(cz?.name)

    if (theFactory == null) {
      log.debug "factory not found in cache for class ${cz.name}, creating a new factory."
      theFactory = createNewFactory(cz, url)
    } else {
      log.info "Factory for ${cz.name} found in the cache map, returning cached instance."
    }

    log.debug("Getting clientproxy time (in sec) of ${TimeCategory.minus(new Date(), startTime)}")
    return theFactory
  }

  private createNewFactory(Class cz, String url) {

    log.debug "Starting factory creation."

    def theFactory = null
    Client client = null

    try {
      log.debug "Creating factory bean."
      JaxWsProxyFactoryBean factory = getFactoryInstance(cz, url)
      theFactory = factory.create()
      log.debug "Done creating factory bean."
    } catch (ex) {
      log.error "Failed when creating factory for class ${cz.name} with url: $url", ex
      return null
    }

    try {
      /** TODO: See if this is what we want.. If client fails to configure we just fail quietly and return the factory without a configured client. */
      log.debug "Creating client proxy."
      client = ClientProxy.getClient(theFactory)
      log.debug "Done creating client proxy."

      if (client) {
        log.debug "Configuring factory client proxy."
        configureClientProxy(client)
        log.debug "Done configuring client proxy."
      }
    } catch (ex) {
      log.error "Failed when creating proxy client for class ${cz.name} with url: $url", ex
    }

    try {
      webServiceMap.put(cz.name, theFactory)
      log.debug "Factory for class ${cz.name} put into cache."
    } catch (ex) {
      log.error "Failed when putting ${cz.name} into the cache", ex
    }

    return theFactory
  }

  private JaxWsProxyFactoryBean getFactoryInstance(Class cz, String url) {
    JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean()
    factory.setServiceClass(cz)
    factory.setAddress(url)
    factory.getInInterceptors().add(new LoggingInInterceptor())
    factory.getOutInterceptors().add(new LoggingOutInterceptor())
    return factory
  }

  /** TODO: Write tests */
  private void configureClientProxy(Client client) {
    HTTPConduit conduit = (HTTPConduit) client.getConduit()
    HTTPClientPolicy policy = new HTTPClientPolicy()
    policy.setConnectionTimeout(DEFAULT_CONNECTION_TIMEOUT)
    policy.setReceiveTimeout(DEFAULT_RECEIVE_TIMEOUT)

    conduit.setClient(policy)

    def auth = new AuthorizationPolicy()
    auth.setAuthorizationType(DEFAULT_AUTH_TYPE)
    conduit.setAuthorization(auth)
  }
}
