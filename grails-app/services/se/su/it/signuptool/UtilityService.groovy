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

import se.su.it.signuptool.interfaces.UtilityServiceI

import java.util.regex.Matcher

class UtilityService implements UtilityServiceI {

  static transactional = false

  public String getScopeFromEppn(String eppn) throws Exception {
    Matcher matcher = (eppn =~ /^[_a-ö,A-Ö,0-9]+@([_a-ö,A-Ö,0-9\.]+)$/)
    String scope = (matcher.matches()) ? matcher.group(1) : null
    log.debug "scope: ${scope} found for eppn: $eppn"
    return scope
  }

  public EventLog getEventLog(long referenceId) throws Exception {
    def eventLog = EventLog.get((long) referenceId)
    if (!eventLog) {
      throw new IllegalArgumentException("Failed to get eventLog from referenceId: ${referenceId}")
    }
    return eventLog
  }

  public EventLog getEventLog() throws Exception {
    return new EventLog().save(flush:true)
  }

  public String chompNinToSsn(String ssn) throws Exception {
    (ssn?.length() == 12) ? ssn[2..11] : ssn
  }
}
