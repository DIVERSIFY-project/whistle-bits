# yajta (Yet Another Java Tracing Agent)

Java agent tracing methods calls.

Argument must belong to the following list (and be separated by |)
	- includes=org.package(,org.package2)* Default: Empty
	- excludes=org.package(,org.package2)* Default: fr.inria.yajta
	- isotopes=org.package(,org.package2)* Default:Empty
	- print=(list,tree) Default: tree
	- strict-includes Default: false
	- follow=File Default: null
	- output=File Default: null

Usage:
```
java -javaagent:path/to/yajta/target/yajta-1.0-SNAPSHOT-jar-with-dependencies.jar="Args" myApp 
```

Ex:
```
java javaagent:path/to/yajta/target/yajta-1.0-SNAPSHOT-jar-with-dependencies.jar="strict-includes|includes=org.myorg.myapp|excludes=fr.inria.yalta|output=oupout.json" -cp myJar.jar org.myorg.myapp.AppMainClass
```

## Check that an App follows the same execution path than a previous one

Ex:
```
java javaagent:path/to/yajta/target/yajta-1.0-SNAPSHOT-jar-with-dependencies.jar="strict-includes|includes=org.myorg.myapp|excludes=fr.inria.yalta|follow=oupout.json" -cp myJar.jar org.myorg.myapp.AppMainClass
```

## Known Limitations

Does not log native methods yet.

# tie (Test Impact Explorer)


## Run test with traces

```
mvn -DargLine="-javaagent:path/to/yajta/target/yajta-1.0-SNAPSHOT-jar-with-dependencies.jar=\"strict-includes|print=list|includes=org.myApp|excludes=fr.inria.yalta\"" test > testLog
```

## Organize the output as a map of methods / set of test

```
java -cp path/to/yajta/target/yajta-1.0-SNAPSHOT-jar-with-dependencies.jar fr.inria.tie.Cleaner -i testLog -o methodsImpact.json -l method
```
