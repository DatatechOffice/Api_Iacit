import psycopg2 as psycopg2
import pandas as pd
from unidecode import unidecode
import matplotlib.pyplot as plt
import json
import pandas as pd
import psycopg2
import datetime

# Função para criar conexão no banco
#from matplotlib.testing.conftest
def removeA(s):
    return unidecode(s.lower())

def conecta_db():
  con = psycopg2.connect(host='localhost',
                         database='Api_Iacit',
                         user='postgres',
                         password='123')
  return con

# Função para criar tabela no banco
def criar_db(sql):
  con = conecta_db()
  cur = con.cursor()
  cur.execute(sql)
  con.commit()
  con.close()

# Função para inserir dados no banco
def inserir_db(sql):
  con = conecta_db()
  cur = con.cursor()
  try:
      cur.execute(sql)
      con.commit()
  except (Exception, psycopg2.DatabaseError) as error:
      print("Error: %s" % error)
      con.rollback()
      cur.close()
      return 1
  cur.close()

# Função para consultas no banco
def consultar_db(sql):
  con = conecta_db()
  cur = con.cursor()
  cur.execute(sql)
  recset = cur.fetchall()
  registros = []
  for rec in recset:
    registros.append(rec)
  con.close()
  return registros

Brasilia = pd.read_csv('BRASILIA2020.CSV', sep=';', encoding='ISO-8859-1', skiprows=8)#on_bad_lines = False
#Brasilia2 = pd.DataFrame(Brasilia, index=[0,1,2,3,4,5,6,7])
#Brasilia2 = Brasilia.head(7)


BraD = Brasilia.loc[Brasilia["Data"]==("2020/10/10")]


# BraV = BraD.loc[BraD["RADIACAO GLOBAL (Kj/m²)"] == ("155,7")]


BraDR = Brasilia[Brasilia["Data"].between("2020/01/01", "2020/12/31")]

def FeedDB():
    sql = """INSERT INTO estado_e_regiao
    (eer_id, eer_regiao, eer_unidade_federativa) 
    values(1, 'CO', 'DF')

    INSERT INTO estacao
    (eer_id, est_codigo, est_nome_estacao, est_longitude, est_latitude, est_altitude, est_data_fundacao)
    values (1, 'A001', 'BRASILIA', -47.925756, -15.789343, 1160.96, '07/05/00')"""
    inserir_db(sql)

    for i in BraDR.index:
        
        sql = """
        INSERT into temperatura (tem_id, tem_ar_bulbo_seco, tem_data, tem_max, tem_min, tem_hora, est_codigo) 
        values(%s, '%s', %s, %s, '%s', %s, 'A001');
        """ % (f'{i}', BraDR['Data'][i],
        BraDR["TEMPERATURA MÁXIMA NA HORA ANT. (AUT) (°C)"].replace({',': '.'}, regex=True)[i],
        BraDR["TEMPERATURA MÍNIMA NA HORA ANT. (AUT) (°C)"].replace({',': '.'}, regex=True)[i],
        BraDR['Hora UTC'][i],
        BraDR["TEMPERATURA DO AR - BULBO SECO, HORARIA (°C)"].replace({',': '.'}, regex=True)[i])
        inserir_db(sql)






#for loop para o index ir de 1 até o 365

#inserirtemp= inserir_db(f'insert into temperatura(tem_data) values({BraDR2})')

def Escolher():
    x = str(input(
        "\033[0;34mDigite:(1) para Temp_Maxima, (2) Temp_Miníma, (3) Temp_Bulbo_Seco e (X) para finalizar pesquisa: \033[m")).lower()
    while x != "x":
        if x == "1":

            #colTemMax = BraDR.loc[BraDR["TEMPERATURA MÁXIMA NA HORA ANT. (AUT) (°C)"].replace({',': '.'}, regex=True) == True]

            XX = input("\033[0;34mData 1 - digite a data nesse formato(yyyy-dd-mm): \033[m")

            XXX = input("\033[0;34mData 2 - digite a data nesse formato(yyyy-dd-mm): \033[m")

            S1 = BraDR[BraDR["Data"].between(f"{XX}", f"{XXX}")]

            while S1.empty:
                print("\033[0;31mData(s) inválida(s)\nDigite novamente\033[m")

                XX = input(

                    "\033[0;34mData 1 - digite a data nesse formato(yyyy-mm-dd): \033[m")

                XXX = input("\033[0;34mData 2 - digite a data nesse formato(yyyy-mm-dd): \033[m")

                S1 = BraDR[BraDR["Data"].between(f"{XX}", f"{XXX}")]

            plt.plot(S1['Data'], S1['TEMPERATURA MÁXIMA NA HORA ANT. (AUT) (°C)'], label='Temp_Max', color='r', ls='--',
                     lw='2')  # Caso queira grafico de barras colocar - plt.bar()
            plt.legend(loc=2, fontsize='15')  # Personalização da legenda
            plt.ylabel('Temperatura Maxima')  # Nome do Eixo Y
            plt.xlabel('Datas')  # Nome do Eixo X
            plt.title('Gráfico da temperatura maxima no período')  # Título do gráfico
            plt.show()

            break
        elif x == "2":
            XX = input("\033[0;34mData 1 - digite a data nesse formato(yyyy-dd-mm): \033[m")

            XXX = input("\033[0;34mData 2 - digite a data nesse formato(yyyy-dd-mm): \033[m")

            S1 = BraDR[BraDR["Data"].between(f"{XX}", f"{XXX}")]

            while S1.empty:
                print("\033[0;31mData(s) inválida(s)\nDigite novamente\033[m")

                XX = input(

                    "\033[0;34mData 1 - digite a data nesse formato(yyyy-mm-dd): \033[m")

                XXX = input("\033[0;34mData 2 - digite a data nesse formato(yyyy-mm-dd): \033[m")

                S1 = BraDR[BraDR["Data"].between(f"{XX}", f"{XXX}")]

            plt.plot(S1['Data'], S1['TEMPERATURA MÍNIMA NA HORA ANT. (AUT) (°C)'], label='Temp_Min', color='b', ls='--',
                     lw='2')  # Caso queira grafico de barras colocar - plt.bar()
            plt.legend(loc=2, fontsize='15')  # Personalização da legenda
            plt.ylabel('Temperatura Maxima')  # Nome do Eixo Y
            plt.xlabel('Datas')  # Nome do Eixo X
            plt.title('Gráfico da temperatura maxima no período')  # Título do gráfico
            plt.show()

            break
        elif x == "3":
            XX = input("\033[0;34mData 1 - digite a data nesse formato(yyyy-dd-mm): \033[m")

            XXX = input("\033[0;34mData 2 - digite a data nesse formato(yyyy-dd-mm): \033[m")

            S1 = BraDR[BraDR["Data"].between(f"{XX}", f"{XXX}")]

            while S1.empty:
                print("\033[0;31mData(s) inválida(s)\nDigite novamente\033[m")

                XX = input(

                    "\033[0;34mData 1 - digite a data nesse formato(yyyy-mm-dd): \033[m")

                XXX = input("\033[0;34mData 2 - digite a data nesse formato(yyyy-mm-dd): \033[m")

                S1 = BraDR[BraDR["Data"].between(f"{XX}", f"{XXX}")]

            plt.plot(S1['Data'], S1["TEMPERATURA DO AR - BULBO SECO, HORARIA (°C)"], label='Temp_Bulbo_Seco', color='g', ls='--',
                     lw='2')  # Caso queira grafico de barras colocar - plt.bar()
            plt.legend(loc=2, fontsize='15')  # Personalização da legenda
            plt.ylabel('Temperatura Maxima')  # Nome do Eixo Y
            plt.xlabel('Datas')  # Nome do Eixo X
            plt.title('Gráfico da temperatura maxima no período')  # Título do gráfico
            plt.show()

            break
        else:
            break


al_filtrar = input("Digite 1 para alimentar o banco, 2 para filtrar os dados(Gráficos)"
                   " e x para fechar o programa: ")
while al_filtrar != "x":
    if al_filtrar == "1":
        FeedDB()
        break
    elif al_filtrar == "2":
        Escolher()
        break