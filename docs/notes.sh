su - test # cambiar de usuario
cp file.txt destino # copiar un archivo
cp -r origen destino # copiar una carpeta
mv origen destido # mover un archivo(tambien renombra)
mv *.origen destido # mover varios archivos
rm file.txt # eleimminar un archivo
rmdir carpeta # eleimminar una carpeta vacia
rm -r carpeta # eleimminar una carpeta y subcarpetas

cat file.txt # ver el contenido
nl fil.txt # muestra con numeros cada linea
cat file.txt file2.txt > juntos.txt
less file.txt # para ver paginado el contenido del archivo
head file.txt # mostrar las diez primeros files
head -n 3 file.txt
tail -n 20 file.txt # mostrar las dos primeras filas
tail -f file.log # ver en timepo real

grep "buscar" file.txt # buscar en el archivo
grep -R "buscar" carpeta
grep -Ri "buscar" carpeta # no distingue mayusculas ni minusculas

find ~/carpeta -type f -name "*.txt" # buscar archivos
date # fecha y hora

df -h # ver disco en uso
du -sh carpeta # ver el uso de memoria de la carpeta
uname -a # ver la informacion basica del sistema(nombre y version)
free -h # ver la memoria ram

top # ver procesos del sistema

chmod 600 file.txt # dar permiso de lectura y escriura al usario
chmod 755 file.txt # rwx r-x r-x

sudo chown user script.sh # cambio de propietario
export VARIABLE=2333 # defini variable solo para la sesion actual

#!/bin/bash # en un file.sh al inicio simepre va

bash script.sh # ejecuacion directa

comamnd > col.log 2>&1 # si da un error igual escribira el contenido del error
wc file.tx # lineas, palabras y caracteres

ls -lS # ordenar por el tamaño de mayor a menor
ls nano*.txt
tar -czf destino.tar.gz carpeta # comprimir un carpeta
tar -xzf work.tar.gz

zip file.zip file.txt
zip -r carpeta.zip carpta/
unzip file.zip

ln -s file.txt file-simbol.txt

cat < vick.sh # envia a cat 
cat file.txt | wc -l # contar numero de lineas de la salida

sort file.txt | uniq # mostrar lineas unicas

lsblk # ver discos y particiones conectados

printenv # ver las variables 
env

whoami # para saber si esres usuario root o normal
df -h / # ver el sistema de arcchivos montado en /
hostname # nombre de la maquina