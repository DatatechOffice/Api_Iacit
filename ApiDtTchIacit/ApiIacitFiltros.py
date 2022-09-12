import psycopg2 as psycopg2
import pandas as pd
#from unidecode import unidecode
import matplotlib.pyplot as plt
import requests
import json
import pandas as pd
import psycopg2
import datetime

# Função para criar conexão no banco
#from matplotlib.testing.conftest

def conecta_db():
  con = psycopg2.connect(host='localhost',
                         database='Jorge',
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


BraV = BraD.loc[BraD["RADIACAO GLOBAL (Kj/m²)"] == ("155,7")]


BraDR = Brasilia[Brasilia["Data"].between("2020/01/01", "2020/12/31")]

Replace = BraDR["TEMPERATURA MÁXIMA NA HORA ANT. (AUT) (°C)"].replace({',': '.'}, regex=True), \
          BraDR["TEMPERATURA MÍNIMA NA HORA ANT. (AUT) (°C)"].replace({',': '.'}, regex=True), \
          BraDR["TEMPERATURA DO AR - BULBO SECO, HORARIA (°C)"].replace({',': '.'}, regex=True)

print(Replace)

for i in BraDR.index:
    sql = """
    INSERT into public.temperatura (tem_id, tem_data, tem_max, tem_min, tem_hora, tem_ar_bulbo_seco, est_codigo) 
    values(%s, '%s', %s, %s, '%s', %s, 'A001');
    """ % (f'{i}', BraDR['Data'][i], BraDR["TEMPERATURA MÁXIMA NA HORA ANT. (AUT) (°C)"].replace({',': '.'}, regex=True)[i], BraDR["TEMPERATURA MÍNIMA NA HORA ANT. (AUT) (°C)"].replace({',': '.'}, regex=True)[i],
           BraDR['Hora UTC'][i], BraDR["TEMPERATURA DO AR - BULBO SECO, HORARIA (°C)"].replace({',': '.'}, regex=True)[i])
    inserir_db(sql)


#for loop para o index ir de 1 até o 365

#inserirtemp= inserir_db(f'insert into temperatura(tem_data) values({BraDR2})')