SublimeDocument : Document {
	classvar >current;
	var <thisdoc;
	var <>index;
	var <>path;

	// var <envir, savedEnvir;
	


	*new { | title, string, makelistener |
		^super.new.init(title, string, makelistener)
	}

	init { | title, string, makelistener |

		^this

	}


	*startup {
		var num, doc;
		num = this.numberOfOpen;
		num.do { | i |
			doc = this.newFromIndex(i);
		};
	}

	// invalid methods
	initByIndex { | idx |
		index = idx;
		^this
	}
	prinitByIndex {
		^this.shouldNotImplement(thisMethod)
	}
	*prnumberOfOpen {
		^allDocuments.size()
	}
	propen { | path, selectionStart=0, selectionLength=0 |
		format("/usr/local/bin/subl --add \'%\'", path).unixCmd;
		^this
	}

	// *open { | path, selectionStart=0, selectionLength=0, envir |
	// 	var doc = Document.implementationClass.prBasicNew.initFromPath(path, selectionStart, selectionLength);
	// 	if (envir.notNil and: { doc.notNil }) { doc.envir_(envir) };
	// 	^doc
	// }

	// *new { | title="Untitled", string="", makeListener=false, envir |
	// 	var doc = Document.implementationClass.new(title, string, makeListener);
	// 	if (envir.notNil and: { doc.notNil }) { doc.envir_(envir) };
	// 	^doc
	// }
	//actions:

	// didBecomeKey {
	// 	this.class.current = this;
	// 	this.saveCurrentEnvironment;
	// 	toFrontAction.value(this);
	// }

	// didResignKey {
	// 	endFrontAction.value(this);
	// 	this.restoreCurrentEnvironment;
	// }

	// closed {
	// 	onClose.value(this); // call user function
	// 	this.restoreCurrentEnvironment;
	// 	allDocuments.remove(this);
	// 	dataptr = nil;
	// }



// Environment handling  Document with its own envir must set and restore currentEnvironment on entry and exit.
// Requires alteration of *open, *new, closed, didBecomeKey, and didResignKey

	envir_ { | ev |
		envir = ev;
		if (this.class.current == this) {
			if(envir.isNil) {
				this.restoreCurrentEnvironment
			} {
				if (savedEnvir.isNil) {
					this.saveCurrentEnvironment
				}
			}
		}
	}

	restoreCurrentEnvironment {
		if (savedEnvir.notNil) {
			currentEnvironment = savedEnvir;
			savedEnvir = nil;
		}
	}

	saveCurrentEnvironment {
		if (envir.notNil) {
			savedEnvir = currentEnvironment;
			currentEnvironment = envir;
		}
	}

	*current {
		^Sublime.currentPath;
	}
}