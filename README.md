# MineJ9
Running MC on OpenJ9

## Setup

Download the jar file, use Fabric mod loader, insert the jar into mods, letsgooo.  
The mod disables Java Flight Recorder if it detects that jfr won't work. It shouldn't do anything on HotSpot JVM.  

Enjoy your slightly slower Minecraft with less memory usage!  

The mod can be ported to forge, but I don't want to play with forge mixins again... 


Anyway, if you need memory, you're probably better off with Java 24 and `-XX:+UnlockExperimentalVMOptions -XX:+UseCompactObjectHeaders` flags.

## License

This template is available under the CC0 license. Feel free to learn from it and incorporate it in your own projects.
