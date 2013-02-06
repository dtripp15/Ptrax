import sbt._
import Keys._
import PlayProject._

object ApplicationBuild extends Build {

    val appName         = "PitchTrax"
    val appVersion      = "1.0-SNAPSHOT"

    val appDependencies = Seq(
      // Add your project dependencies here,
      "mysql" % "mysql-connector-java" % "5.1.18"      
      
    )
	// Only compile the bootstrap bootstrap.less file and any other *.less file in the stylesheets directory 
	def customLessEntryPoints(base: File): PathFinder = ( 
	    (base / "app" / "assets" / "stylesheets" / "bootstrap" * "bootstrap.less") +++
	    (base / "app" / "assets" / "stylesheets" / "bootstrap" * "responsive.less") +++ 
	    (base / "app" / "assets" / "stylesheets" * "*.less")
	)

    val main = PlayProject(appName, appVersion, appDependencies, mainLang = JAVA).settings(
      // Add your own project settings here  
      lessEntryPoints <<= baseDirectory(customLessEntryPoints)    
    )

}
