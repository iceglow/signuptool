package se.su.it.signuptool

class InfoController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    static final availableKeys = ['first_page', 'sidebar', 'degree_app']

    def defaultAction = 'list'

    def index = {
        redirect(action: "list", params: params)
    }

    def list = {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [infoInstanceList: Info.list(params), infoInstanceTotal: Info.count()]
    }

    def create = {
        def infoInstance = new Info()
        infoInstance.properties = params
        return [infoInstance: infoInstance, availableKeys:availableKeys]
    }

    def save = {
        def infoInstance = new Info(params)
        if (infoInstance.save(flush: true)) {
            flash.info = "${message(code: 'default.created.message', args: [message(code: 'info.label', default: 'Info'), infoInstance.id])}"
            redirect(action: "list")
        }
        else {
            render(view: "create", model: [infoInstance: infoInstance])
        }
    }

    def show = {
        def infoInstance = Info.get(params.id)
        if (!infoInstance) {
            flash.error = "${message(code: 'default.not.found.message', args: [message(code: 'info.label', default: 'Info'), params.id])}"
            redirect(action: "list")
        }
        else {
            [infoInstance: infoInstance]
        }
    }

    def edit = {
        def infoInstance = Info.get(params.id)
        if (!infoInstance) {
            flash.error = "${message(code: 'default.not.found.message', args: [message(code: 'info.label', default: 'Info'), params.id])}"
            redirect(action: "list")
        }
        else {
            return [infoInstance: infoInstance, availableKeys:availableKeys]
        }
    }

    def update = {
        def infoInstance = Info.get(params.id)
        if (infoInstance) {
            if (params.version) {
                def version = params.version.toLong()
                if (infoInstance.version > version) {

                    infoInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'info.label', default: 'Info')] as Object[], "Another user has updated this Info while you were editing")
                    render(view: "edit", model: [infoInstance: infoInstance])
                    return
                }
            }
            infoInstance.properties = params
            if (!infoInstance.hasErrors() && infoInstance.save(flush: true)) {
                flash.info = "${message(code: 'default.updated.message', args: [message(code: 'info.label', default: 'Info'), infoInstance.id])}"
                redirect(action: "list")
            }
            else {
                render(view: "edit", model: [infoInstance: infoInstance])
            }
        }
        else {
            flash.error = "${message(code: 'default.not.found.message', args: [message(code: 'info.label', default: 'Info'), params.id])}"
            redirect(action: "list")
        }
    }

    def delete = {
        def infoInstance = Info.get(params.id)
        if (infoInstance) {
            try {
                infoInstance.delete(flush: true)
                flash.info = "${message(code: 'default.deleted.message', args: [message(code: 'info.label', default: 'Info'), params.id])}"
                redirect(action: "list")
            }
            catch (org.springframework.dao.DataIntegrityViolationException e) {
                flash.error = "${message(code: 'default.not.deleted.message', args: [message(code: 'info.label', default: 'Info'), params.id])}"
                redirect(action: "list")
            }
        }
        else {
            flash.error = "${message(code: 'default.not.found.message', args: [message(code: 'info.label', default: 'Info'), params.id])}"
            redirect(action: "list")
        }
    }
}
