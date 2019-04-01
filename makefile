JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class: ; $(JC) $(JFLAGS) $*.java

CLASSES = \
CalculatorFrame.java\
CalculatorTest.java\
AlignFrame.java\
AlignTest.java

default: classes

classes: $(CLASSES:.java=.class)

clean: ; $(RM) *.class
