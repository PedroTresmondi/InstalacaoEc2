#!/bin/bash

usuario=$(whoami)
echo "Adicionando" $usuario echo " no grupo de sudoers "
sudo adduser $usuario sudo

echo "  ██████  ███    ███ ███    ██ ██ ██    ██ ██ ███████ ██     ██ "
echo " ██    ██ ████  ████ ████   ██ ██ ██    ██ ██ ██      ██     ██ "
echo " ██    ██ ██ ████ ██ ██ ██  ██ ██ ██    ██ ██ █████   ██  █  ██ "
echo " ██    ██ ██  ██  ██ ██  ██ ██ ██  ██  ██  ██ ██      ██ ███ ██ "
echo "  ██████  ██      ██ ██   ████ ██   ████   ██ ███████  ███ ███  "


which zip 
if [ $? = 0 ]
then echo "Descompactador ZIP já instalado"
else echo "Descompactador não encontrado "
while true; do
    read -p "Deseja Instalar esse programa? Digite yes ou no " yn
    case $yn in
        [Yy]* ) sudo apt install zip; echo "Instalando o ZIP"; break;;
        [Nn]* ) exit;;
        * ) echo "Por favor insira yes ou no.";;
    esac
done
fi

echo "Adicionando o caminho do SDK ao Curl"
curl -s "https://get.sdkman.io" | bash


echo "reiniciando terminal"
source "$HOME/.sdkman/bin/sdkman-init.sh"

sdk install java 11.0.12.7.1-amzn; 

echo "versao instalada: "
javac --version


echo "Atualizando pacotes"
sudo apt update && sudo apt upgrade -y

echo "procurando o docker"
which docker
if [ $? = 0 ]
then echo "Já possui docker instalado"
else echo "Instalando docker"
sudo apt install docker.io
fi
echo "iniciando o docker no sistema"
sudo systemctl start docker
sudo systemctl enable docker

echo "baixando mysql"
sudo docker pull mysql:8.0.16
echo "criando o banco de dados"
sudo docker build -t omniview_img:1.0 .
echo "executando mysql"
sudo docker run -d -p 3306:3306 --name omniview omniview_img:1.0


echo "Instalando protocolo RDP"
sudo apt-get install xrdp lxde-core lxde tigervnc-standalone-server -y;



echo " ███████ ██ ███    ███     ██████   █████      ██ ███    ██ ███████ ████████  █████  ██       █████   ██████  █████   ██████   "
echo " ██      ██ ████  ████     ██   ██ ██   ██     ██ ████   ██ ██         ██    ██   ██ ██      ██   ██ ██      ██   ██ ██    ██  "
echo " █████   ██ ██ ████ ██     ██   ██ ███████     ██ ██ ██  ██ ███████    ██    ███████ ██      ███████ ██      ███████ ██    ██  "
echo " ██      ██ ██  ██  ██     ██   ██ ██   ██     ██ ██  ██ ██      ██    ██    ██   ██ ██      ██   ██ ██      ██   ██ ██    ██  "
echo " ██      ██ ██      ██     ██████  ██   ██     ██ ██   ████ ███████    ██    ██   ██ ███████ ██   ██  ██████ ██   ██  ██████   "

cd ..

cd Desktop
sudo git clone https://github.com/PedroTresmondi/InstalacaoEc2.git
cd InstalacaoEc2/
cd ominiviewGUI/
cd target/
java -jar omniview-1.0-SNAPSHOT-jar-with-dependencies.jar


                                                                                        
                                                                                        
