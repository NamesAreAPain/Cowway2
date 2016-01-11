dir /s/b *.java >FileIndex.txt

for /F "tokens=*" %%A in (FileIndex.txt) do javac -cp libjcsi.jar;. %%A