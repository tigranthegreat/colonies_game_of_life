# this is for mac and linux only

SRC_DIR="src/main/java"

cd src/main/java
javac **/*.java Main.java

echo $@
java Main $@
