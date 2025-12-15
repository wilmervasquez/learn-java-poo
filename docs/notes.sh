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

echo "hola" # imprimir texto
echo $VARIABLE # mostrar variable
echo "hola" > file.txt # sobrescribir archivo
echo "hola" >> file.txt # agregar al final

alias ll='ls -lah' # crear alias
unalias ll # eliminar alias

which ls # ruta del comando
whereis ls # binarios y manuales

stat file.txt # info detallada del archivo
file file.txt # tipo de archivo

passwd # cambiar contraseña
logout # cerrar sesión
exit # salir de shell

sleep 5 # esperar 5 segundos
watch -n 2 date # ejecutar comando cada 2 segundos

clear # limpiar pantalla
reset # reiniciar terminal

diff file1.txt file2.txt # comparar archivos
diff -u file1 file2 # comparación unificada

cut -d: -f1 /etc/passwd # cortar columnas
cut -c1-5 file.txt # cortar caracteres

tr 'a-z' 'A-Z' < file.txt # convertir a mayúsculas
tr -d ' ' < file.txt # eliminar espacios

sed 's/error/ERROR/g' file.txt # reemplazar texto
sed -n '1,5p' file.txt # mostrar líneas 1 a 5

awk '{print $1}' file.txt # imprimir primera columna
awk '{sum+=$1} END {print sum}' file.txt # sumar columna

yes # imprimir "y" infinitamente
yes | head -n 5 # limitar salida

xargs rm < lista.txt # ejecutar comandos con entrada

tee salida.txt # guardar salida y mostrarla
ls | tee lista.txt # guardar listado

mount # sistemas montados
umount /dev/sdb1 # desmontar dispositivo

who # usuarios conectados
w # usuarios y actividad
last # historial de sesiones

crontab -l # ver tareas programadas
crontab -e # editar cron

at now + 1 minute # tarea programada
atrm ID # borrar tarea at

service ssh status # estado de servicio
systemctl status ssh # estado (systemd)
systemctl start nginx # iniciar servicio
systemctl stop nginx # detener servicio
systemctl enable nginx # iniciar al arrancar

reboot # reiniciar sistema
shutdown now # apagar sistema
shutdown -h +10 # apagar en 10 minutos

nohup comando & # ejecutar en segundo plano
jobs # trabajos en segundo plano
bg %1 # enviar a segundo plano
fg %1 # traer a primer plano

screen # multiplexor de terminal
tmux # multiplexor moderno

scp file.txt user@host:/ruta # copiar por red
rsync -av origen destino # sincronizar

ssh user@host # conexión remota
ssh-keygen # generar claves SSH

locate archivo # búsqueda rápida (requiere updatedb)
updatedb # actualizar base locate

basename /ruta/archivo.txt # nombre del archivo
dirname /ruta/archivo.txt # ruta del archivo

expr 5 + 3 # operaciones básicas
bc # calculadora

history | grep ls # buscar en historial
!23 # ejecutar comando 23 del historial

lscpu            # info del CPU (arquitectura, núcleos, hilos)
lsmem            # info de memoria (si está disponible)
lsusb            # dispositivos USB
lspci            # dispositivos PCI (GPU, red, audio)
inxi -Fxz        # resumen completo del sistema (requiere instalación)
hwinfo           # info detallada del hardware (muy completo)

cat /proc/meminfo     # info detallada de RAM
vmstat                # memoria, procesos y CPU
arch                  # arquitectura (x86_64, arm, etc)

htop -d 10            # refresco personalizado
atop                  # rendimiento histórico
iostat                # uso de disco

which bash            # ruta real del binario

date # fecha y hora actual
date +"%d/%m/%Y" # fecha personalizada
date +"%H:%M:%S" # hora
date +"%Y-%m-%d %H:%M" # formato común
date -u # fecha y hora en UTC

uname -a # información del sistema y kernel
hostname # nombre del equipo
whoami # usuario actual
id # UID, GID y grupos
uptime # tiempo encendido

su # cambiar de usuario
sudo # ejecutar como superusuario
passwd # cambiar contraseña
logout # cerrar sesión
exit # salir del shell

pwd # mostrar ruta actual
ls # listar archivos
ls -lah # listar con detalles y ocultos
cd / # ir al directorio raíz
cd ~ # ir al home del usuario
cd .. # subir un nivel

mkdir carpeta # crear directorio
mkdir -p proyectos/2025/informes # crear estructura
rmdir carpeta # borrar directorio vacío

touch archivo.txt # crear archivo vacío
touch a.txt b.txt c.txt # crear varios archivos

cp archivo destino # copiar archivo
cp -r origen destino # copiar carpeta recursivamente
mv archivo destino # mover o renombrar
mv *.txt textos/ # mover varios archivos
rm archivo # eliminar archivo
rm -r carpeta # eliminar carpeta y contenido

cat archivo.txt # ver contenido completo
less archivo.txt # ver archivo grande paginado
more archivo.txt # paginado simple
head archivo.txt # primeras 10 líneas
head -n 5 archivo.txt # primeras 5 líneas
tail archivo.txt # últimas 10 líneas
tail -n 20 archivo.txt # últimas 20 líneas
tail -f log.txt # ver en tiempo real
nl archivo.txt # mostrar líneas numeradas

grep "error" archivo.txt # buscar texto
grep -R "usuario" carpeta # búsqueda recursiva
grep -i "error" archivo.txt # sin may/min

find /var -name "*.log" # buscar archivos

archivo.txt # redirección de salida

archivo.txt # agregar salida
< archivo.txt # redirección de entrada
| # tubería (pipe)

wc archivo.txt # contar líneas, palabras y caracteres
sort archivo.txt # ordenar
sort archivo.txt | uniq # líneas únicas
sort archivo.txt | uniq -c # contar repetidas

chmod 600 secreto.txt # permisos rw-------
chmod 755 programa # permisos rwxr-xr-x
chmod +x script.sh # hacer ejecutable

chown alumno script.sh # cambiar propietario
chown alumno:grupo archivo # propietario y grupo

export EDITOR=nano # variable de entorno
env # ver variables de entorno
printenv # ver variables
unset VARIABLE # borrar variable

alias ll='ls -lah' # crear alias
unalias ll # eliminar alias

history # historial de comandos
!25 # ejecutar comando del historial

#!/bin/bash # primera línea de script
bash script.sh # ejecutar con bash
./script.sh # ejecutar directamente

tar -czf proyecto.tar.gz proyecto/ # comprimir
tar -xzf archivos.tar.gz # descomprimir
zip archivo.zip archivo.txt # zip
unzip archivo.zip # descomprimir zip

ln -s informe.txt link_informe # enlace simbólico

date # fecha y hora
df -h # uso de disco
du -sh /home # tamaño de directorio
free -h # memoria RAM
top # procesos en tiempo real
htop # procesos (si está instalado)
lsblk # discos y particiones
mount # sistemas montados

apt update # actualizar paquetes (Debian/Ubuntu)
apt install paquete # instalar paquete
dnf install paquete # Fedora
yum install paquete # CentOS

clear # limpiar pantalla
reset # reiniciar terminal