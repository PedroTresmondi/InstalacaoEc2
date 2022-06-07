cd ..

cd Desktop
echo "procurando o repositorio"
which InstalacaoEc2/
if [ $? = 0 ]
then sudo git pull
else sudo git clone https://github.com/PedroTresmondi/InstalacaoEc2.git
fi
