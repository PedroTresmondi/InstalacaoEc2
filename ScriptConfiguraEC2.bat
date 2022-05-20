#!/bin/bash

which zip 
if [ $? = 0 ]
then echo "Descompactador ZIP já instalado"
else echo "Descompactador não encontrado "
while true; do
    read -p "Do you wish to install this program? " yn
    case $yn in
        [Yy]* ) sudo apt install zip; echo "Instalando o ZIP"; break;;
        [Nn]* ) exit;;
        * ) echo "Por favor insira yes ou no.";;
    esac
done
fi

echo "Adicionando o caminho do SDK ao Curl"
curl -s "https://get.sdkman.io" | bash


echo "Reiniciando o terminal para finalizar instalação"
$username = $(whoami)
source "/home/$username/.sdkman/bin/sdkman-init.sh"

sdk install java 11.0.12.7.1-amzn; 

echo "versao instalada: "
javac --version


echo "Instalando Interface Grafica"
while true; do
    read -p "Deseja instalar a interface grafica na sua EC2? " yn
    case $yn in
        [Yy]* ) sudo apt update && sudo apt upgrade -y";  echo "Atualizando os pacotes do sistema"; break;;
        [Nn]* ) exit;;
        * ) echo "Por favor insira yes ou no.";;
    esac
done


echo "Instalando protocolo RDP"
sudo apt-get install xrdp lxde-core lxde tigervnc-standalone-server -y

echo "Interface Grafica instalada!"
echo "Conecte-se com o protocolo RDP!"
fi