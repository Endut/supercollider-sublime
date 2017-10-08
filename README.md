# SuperCollider Sublime Text 3 Plugin

## Installation

- Either clone this repo into your `Sublime Text 3/Packages` folder, or install via Package Control
    - If you cloned the repo, make sure to rename the directory `SuperCollider`, full dir should be `Sublime Text 3/Packages/SuperCollider`
- I recommend *copying* `Packages/SuperCollider/SuperCollider.sublime-settings` to `Packages/User/SuperCollider.sublime-settings` this way you can overwrite any of the preferences easily.
- If you have installed SuperCollider into a non-standard location, set the path in Package Settings > SuperCollider > Settings - User

## Features

- Execute with multiple cursors
- Execution highlighting
- Open Help and Class files directly from Sublime Text
- Post window in a new tab, group, window, or output panel (see settings file)
- Fancy block evaluation, expands to lines containing brackets, e.g. executing with the cursor inside a SynthDef will evaluate it without the need for additional parentheses.
- Near parity with SCIDE commands, e.g. Open User Support Directory, and Open Startup File

## Options

See `Package Settings > SuperCollider > Settings - Default` for further options, including Post Window settings.

## Commands

All commands are available in the Tools > SuperCollider Menu, or via the Command Palette

If you want to set key bindings, add an entry to your `Preferences -> Package Settings -> SuperCollider -> Key Bindings - User` e.g.

    {
        "command": "super_collider_stop",
        "keys":    ["super+."],
        "context": [{
            "key":      "selector",
            "operator": "equal",
            "operand":  "source.supercollider"
        }]
    }

The available commands are:

- `super_collider_start_interpreter`
- `super_collider_stop_interpreter`
- `super_collider_evaluate`
- `super_collider_open_post_view`
- `super_collider_clear_post_view`
- `super_collider_boot_server`
- `super_collider_kill_server`
- `super_collider_reboot_server`
- `super_collider_toggle_mute`
- `super_collider_increase_volume`
- `super_collider_decrease_volume`
- `super_collider_restore_volume`
- `super_collider_start_recording`
- `super_collider_stop_recording`
- `super_collider_evaluate`
- `super_collider_stop`
- `super_collider_recompile`
- `super_collider_help`
- `super_collider_open_class`


## Credits

Rewritten for Sublime Text 3 based on ST2 plugin by [geoffroymontel](https://github.com/geoffroymontel/supercollider-package-for-sublime-text).

Also includes:
- sclang Syntax converted from TextMate syntax by [rfwatson](https://github.com/rfwatson/supercollider-tmbundle)
- Some snippets and mouse mapping from Thor Magnusson

## Testing TODO

- Windows
    - Communication with sclang
    - 'Open Startup File' command
    - 'Open User Support Directory' command
- Linux
    - 'Open Startup File' command
    - 'Open User Support Directory' command

## TODO

- Use system dialog to select SuperCollider application location
- Provide syntax error feedback in open document (e.g. highlight line with errors)
- command: show node tree
- command: dump node terminated
- command: dump node tree with controls
- command: look up references
- autocompletion
    - Make easy to do ctags
    - Include default symbol list from core
- add schelp syntax from [crucialfelix](https://github.com/crucialfelix)'s Atom plugin
- mini html for error logs with crucialfelix's parsing
    + probably use supercollider.js for this

## Future Work

### Multiple sclang instances

In theory this plugin could support multiple instances of sclang, however some
mechanism would be required to tell the commands (start, stop execute etc) which
instance to send the message to.

#### Possibile approaches:

- Selectable 'current sclang' menu item
