# DCEVM Scala reloading

Problem - Scala classes are not being reloaded.

How to reproduce (assuming you've installed DCEVM and have hotswap agent locally):

1. Run `sbt "~;compile;copy-resources"` in a separate terminal
2. Run the app itself
    
    ```bash
    sbt 'set fork := true' 'set javaOptions in run ++= Seq("-Xms2G", "-XXaltjvm=dcevm", "-javaagent:hotswap-agent.jar=autoHotswap=true")' 'run-main bla.Main'
    ```

Then modify `JavaClass.java`. You'll see a message

```
[info] Java can do Cubing plus one 1. Scala can do Squaring: 0
[info] Java can do Cubing plus one -4095. Scala can do Squaring: 256
[info] Java can do Cubing plus one -3374. Scala can do Squaring: 225
[info] Java can do Cubing plus one -124. Scala can do Squaring: 25
[info] HOTSWAP AGENT: 13:12:51.828 RELOAD (org.hotswap.agent.config.PluginManager) - Reloading classes [bla.JavaClass] (autoHotswap)
[info] Java can do Cubing plus two 3377. Scala can do Squaring: 225
[info] Java can do Cubing plus two 1333. Scala can do Squaring: 121
```

Now, modify `ScalaClass.scala`. Nothing happens.
