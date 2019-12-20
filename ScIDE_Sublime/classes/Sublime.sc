Sublime {
	classvar <currentPath;
	// classvar docRoutine;
	classvar savedEnv;

	*initClass {
		Document.implementationClass = SublimeDocument;
		StartUp.add( { Document.implementationClass.startup;} );
	}

	*openHelpUrl { arg url;
		^HelpBrowser.instance.goTo(url);
	}

	*currentPath_ { arg path;
		savedEnv = currentEnvironment;
		if (Mod.all.at(path.asSymbol).notNil) {
			var module = Mod.all.at(path.asSymbol);
			module.printModule;
			currentEnvironment = module;
			} {
				currentEnvironment = topEnvironment;
			};
		currentPath = path;
	}
}




ScIDE : Sublime {}
