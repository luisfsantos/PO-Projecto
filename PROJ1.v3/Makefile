PROJ=poof
all:
	javac `find $(PROJ) pt poof-support -name "*.java"` -encoding utf-8
	jar -cf pt.jar `find pt -name "*.class"` 

	jar -cfm $(PROJ).jar MANIFEST.MF pt.jar poof-support.jar `find $(PROJ) -name "*.class"`
run:
	java -jar $(PROJ).jar 
swing:
	java -Dui=swing -jar $(PROJ).jar
clean:
	rm -f `find $(PROJ) pt -name "*.class"`
