package se.su.it.signuptool.commandobjects

import grails.validation.Validateable
import groovy.transform.ToString
import groovy.util.logging.Slf4j

@Validateable
@ToString(includeNames = true, includeFields = true, excludes = ["password"])
@Slf4j
public class ResetPasswordProcess extends FlowProcessBase {}
