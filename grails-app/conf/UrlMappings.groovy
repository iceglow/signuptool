class UrlMappings {

  static mappings = {
    "/$controller/$action?/$id?" {
      constraints {
        // apply constraints here
      }
    }

    "/"(view: "/index")
    "500"(controller:'errorHandler', action:'on500')
    "404"(controller:'errorHandler', action:'on404')
    "403"(controller:'errorHandler', action:'on403')
    "400"(controller:'errorHandler', action:'on400')
  }
}
