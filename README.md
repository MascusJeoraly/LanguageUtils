Language Utils
=================

[![Gitter](https://badges.gitter.im/Join%20Chat.svg)](https://gitter.im/MeowInnovation/LanguageUtils?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge)

Bukkit/Spigot API designed to help get the name of an item.

Status: [![Build Status](https://snap-ci.com/MeowInnovation/LanguageUtils/branch/master/build_image)](https://snap-ci.com/MeowInnovation/LanguageUtils/branch/master)


----------


Progress: ![Progress](http://progressed.io/bar/67)

- API: ![Progress](http://progressed.io/bar/99)
- Language files: ![Progress](http://progressed.io/bar/100?title=75/75)
- Items: ![Progress](http://progressed.io/bar/1?title=7/556)

<strike>Lazy</strike>


----------
## Contribute to this Project

If you don't have [Gradle](http://gradle.org/ "Gradle") installed, you can download one or use `gradlew`(Windows) / `./gradlew`(Linux) instead of `gradle` in the commands.

If you don't have permission when using `./gradlew`, run `chmod +x gradlew` and run the command again.

### Build

	[Navigate to the project directory]
	$ gradle build

You can find the output in the `build/libs` folder.

### Run Bukkit/Spigot Test Server

Before you run the command, you need to build Bukkit/Spigot server using [BuildTools](https://hub.spigotmc.org/jenkins/job/BuildTools/ "BuildTools") or download it [here](http://www.spigotdl.com/ "here"). (Powered by [spigotdl.com](spigotdl.com))

You should get something like `spigot-1.8.7-R0.1-SNAPSHOT.jar`. Rename it to `Server.jar`, and put it in the `run/` folder.(if not existed, create one in the project directory)

Then:

	[Navigate to the project directory]
	$ gradle run

### Test

	[Navigate to the project directory]
	$ gradle test
If there are some problems, see `build\reports\tests\index.html` for more info.

### Setup Dev Environment

If you are using IntelliJ IDEA(recommended):

	[Navigate to the project directory]
	$ gradle idea

If you just want to create a Module instead of a Project, run `gradle ideaModule` instead.

If you are using Eclipse(not tested)

	[Navigate to the project directory]
	$ gradle eclipse

### Pull Request

If you want to contribute to this project, please send me PR.

----------

Donate:

- Dogecoin(Just for fun, actually): `DNfZ4MxdvTrP3DFWvGXBEMXu9wfUAR3pLh`

