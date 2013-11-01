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

import grails.test.MockUtils
import grails.test.mixin.TestFor
import grails.test.mixin.TestMixin
import groovy.sql.Sql
import se.su.it.signuptool.mock.UseCase
import spock.lang.Specification

import javax.sql.DataSource

@TestFor(MockService)
class MockServiceSpec extends Specification {

  def setup() {
  }

  def cleanup() {
  }

  def "findAllByType finds all of a given type"() {
    given:
    service.addUseCase(new UseCase(type: UseCase.Type.ACCOUNT))
    service.addUseCase(new UseCase(type: UseCase.Type.ACCOUNT))
    service.addUseCase(new UseCase(type: UseCase.Type.CARD))
    service.addUseCase(new UseCase(type: UseCase.Type.CARD))

    when:
    def ret = service.findAllByType(UseCase.Type.CARD)

    then:
    ret.size() == 2
    ret*.type.unique().size() == 1
    ret*.type.contains(UseCase.Type.CARD)
  }

  def "findByType finds one of a given type"() {
    given:
    service.addUseCase(new UseCase(type: UseCase.Type.ACCOUNT))
    service.addUseCase(new UseCase(type: UseCase.Type.ACCOUNT))
    service.addUseCase(new UseCase(type: UseCase.Type.CARD))
    service.addUseCase(new UseCase(type: UseCase.Type.CARD))

    when:
    def ret = service.findByType(UseCase.Type.CARD)

    then:
    ret.type == UseCase.Type.CARD
  }

  def "get gets the correct usecase"() {
    given:
    service.addUseCase(new UseCase(id: 0))
    service.addUseCase(new UseCase(id: 1))
    service.addUseCase(new UseCase(id: 2))

    when:
    def ret = service.get(1)

    then:
    ret.id == 1
  }

  def "getUseCases gets all usecases"() {
    given:
    service.addUseCase(new UseCase(id: 0))
    service.addUseCase(new UseCase(id: 1))
    service.addUseCase(new UseCase(id: 2))

    when:
    def ret = service.useCases

    then:
    ret.size() == 3
  }

  def "addUseCase sets a id on the UseCase"() {
    when:
    service.addUseCase(new UseCase())

    then:
    service.useCases.size() == 1
    service.useCases.first().id != null
  }

  def "setupUseCases creates UseCases"() {
    given:
    MockUtils.mockCommandObject UseCase

    when:
    service.setupUseCases()

    then:
    service.useCases.size() > 0
  }
}
