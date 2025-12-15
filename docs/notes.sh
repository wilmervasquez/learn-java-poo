su - test # cambiar de usuario
sudo comando # ejecutar como superusuario
whoami # usuario actual
id # UID, GID y grupos
groups # grupos del usuario

pwd # ruta actual
ls # listar archivos
ls -lah # listado detallado y ocultos
cd ruta # cambiar de directorio
cd .. # subir un nivel
mkdir carpeta # crear carpeta
mkdir -p a/b/c # crear carpetas anidadas
touch file.txt # crear archivo vacío

cp file.txt destino # copiar un archivo
cp -r origen destino # copiar una carpeta
mv origen destino # mover archivo (también renombra)
mv *.origen destino # mover varios archivos
rm file.txt # eliminar archivo
rmdir carpeta # eliminar carpeta vacía
rm -r carpeta # eliminar carpeta y subcarpetas
rm -rf carpeta # eliminar sin confirmación (cuidado)

cat file.txt # ver contenido
nl file.txt # mostrar con números cada línea
less file.txt # ver paginado
more file.txt # paginado simple
head file.txt # primeras 10 líneas
head -n 3 file.txt # primeras 3 líneas
tail file.txt # últimas 10 líneas
tail -n 20 file.txt # últimas 20 líneas
tail -f file.log # ver en tiempo real

cat file1.txt file2.txt > juntos.txt # redirección
comando > out.log 2>&1 # stdout y stderr
cat < script.sh # redirección de entrada
cat file.txt | wc -l # contar líneas

grep "buscar" file.txt # buscar texto
grep -R "buscar" carpeta # búsqueda recursiva
grep -Ri "buscar" carpeta # sin distinguir may/min

find ~/carpeta -type f -name "*.txt" # buscar archivos

wc file.txt # líneas, palabras y caracteres
sort file.txt # ordenar
sort file.txt | uniq # líneas únicas
sort file.txt | uniq -c # contar repetidos

chmod 600 file.txt # rw-------
chmod 755 file.txt # rwxr-xr-x
chmod +x script.sh # hacer ejecutable

chown user script.sh # cambiar propietario
chown user:group file.txt # propietario y grupo

export VARIABLE=2333 # variable de sesión
printenv # ver variables de entorno
env # ver variables
unset VARIABLE # borrar variable

#!/bin/bash # siempre primera línea del script
bash script.sh # ejecutar script
./script.sh # ejecutar directamente

tar -czf destino.tar.gz carpeta # comprimir
tar -xzf work.tar.gz # extraer
zip file.zip file.txt # zip
zip -r carpeta.zip carpeta/ # zip recursivo
unzip file.zip # descomprimir

ln -s file.txt file-simbolico.txt # enlace simbólico

date # fecha y hora
uname -a # información del sistema
hostname # nombre de la máquina
uptime # tiempo encendido

df -h # uso de disco
df -h / # uso del sistema raíz
du -sh carpeta # tamaño de carpeta
free -h # memoria RAM
lsblk # discos y particiones

top # procesos en tiempo real
htop # top mejorado (si está instalado)
ps aux # procesos
kill PID # terminar proceso
kill -9 PID # forzar proceso

ip a # interfaces de red
ip r # rutas
ping host # conectividad
curl url # peticiones HTTP
wget url # descargar

man comando # manual
comando --help # ayuda rápida
history # historial
clear # limpiar pantalla
