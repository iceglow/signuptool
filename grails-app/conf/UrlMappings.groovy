class UrlMappings {
    static mappings = {
      "/$controller/$action?/$id?"{
	      constraints {
			 // apply constraints here
		  }
	  }
      "/"(controller: "signup", action:"signuptool")
	  "500"(view:'/error')
	}
}
