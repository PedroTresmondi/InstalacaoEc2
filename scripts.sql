
create table maquina(
id INT PRIMARY KEY AUTO_INCREMENT,
hostName VARCHAR(45),
tipo VARCHAR(45),
sistemaOperacional VARCHAR(45),
ramTotal DOUBLE(5,2),
arquitetura VARCHAR(45),
processador VARCHAR(50),
disco INT,
Fk_EstMaq INT,
FOREIGN KEY (Fk_EstMaq) REFERENCES estabelecimento (id)
)AUTO_INCREMENT = 500;

create table medicoes(
id INT PRIMARY KEY AUTO_INCREMENT,
ram DOUBLE(6,2) NULL,
disco DOUBLE(5,2) not NULL,
cpuM DOUBLE(5,2) not NULL,
processos INT not NULL,
diaHorario DATETIME not NULL,
Fk_MaqRe INT NULL,
FOREIGN KEY (Fk_MaqRe) REFERENCES maquina (id)
)AUTO_INCREMENT = 1000;




