target (loadContext: 'Loads the db/context.xml to your .grails home' ) {
	projectDir = Ant.project.properties."base.dir"
	contextDir = "${Ant.project.properties.'user.home'}/.grails/${Ant.project.properties.'grails.version'}/projects/${Ant.project.properties.'base.name'}/resources/conf"

	echo(message: "Creating dir ${contextDir}") 
	Ant.mkdir(dir: "${contextDir}")

	echo(message: "Copying context.xml to ${contextDir}")
 	Ant.copy(file: "${projectDir}/db/context.xml", todir: "${contextDir}")
}

setDefaultTarget(loadContext)
