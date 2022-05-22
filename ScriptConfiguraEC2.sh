usuario=$(whoami)

echo "procurando o zip Instalador zip"
which zip
if [ $? = 0 ]
then echo "Já possui zip instalado"
else echo "Instalando zip"
sudo apt install zip
echo "adicionando o caminho sdk ao curl"
curl -s"https://get.sdkman.io"|bash
fi
echo "reiniciando o terminal"

source "/home/$usuario/.sdkman/bin/sdkman-init.sh"
echo "Checando se Java ja esta instalado"
which java
if [ $? = 0 ]
then echo "Já possui java instalado"
else echo "Instalando java"
sdk install java 11.0.12.7.1-amzn
fi
echo "versão do instalada: "
java -version
echo "atualizando os pacotes"
sudo apt update && sudo apt upgrade.
echo "procurandoodocker"
which docker
if [ $? = 0 ]
then echo "Já possui docker instalado"
else echo "Instalando docker"
sudo apt install docker.io
fi
echo "iniciando o docker no sistema"
sudo systemctl start docker
echo "definindo para o serviço do docker sempre iniciar no sistema"
sudo systemctl enable dockerI
echo "baixando a imagem do mysql"
sudo docker pull mysql:8.0.16
echo "criando uma imagem customizada do mysql com o banco de dados"
sudo docker build -t omniviewBD_img:1.0.
echo "executando o container com mysql"
sudo docker run -d -p 3306:3306 --name omniviewBD -e "MYSQL_DATABASE=bd-omniview" -e "MYSQL_ROOT_PASSWORD=root" omniview_img:1.0
echo "executando o container com mysql"

sudo exec -it omniviewBD bash

echo"mostrando o status do container"
sudo docker stats omniviewBD
echo"instalação completa"