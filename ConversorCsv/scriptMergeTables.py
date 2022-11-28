from fileinput import filename
from io import StringIO
import pandas as pd
import os
import csv
# encoding: iso-8859-1
dataFrame = pd.DataFrame()
firstTime = True
for fileName in os.listdir():
    if fileName.endswith(".CSV"):

        inp = open(fileName, "r",encoding='ISO-8859-1')
        lines = inp.readlines()

        i = 0
        lineToColumn = []

        for line in lines:
            
            line = line.replace(',','.')
            # SE FOR UMA DAS 8 PRIMEIRAS LINHAS SALVA PRA DEPOIS
            if i < 8:
                lineToColumn.append(line)
            i += 1

        # CRIA ARQUIVO INTERMEDIARIO SEM AS PRIMEIRAS 8 LINHAS
        # E COM '.' AO INVES DE ','
        out = StringIO("\n".join(lines[8:]))

        # LE O ARQUIVO INTER. E TRANSFORMA EM DATAFRAME
        dataFrameAuxiliar = pd.read_csv(out, encoding='ISO-8859-1',  sep=';')
        # dataFrameAuxiliar = dataFrameAuxiliar.drop(columns=["Unnamed: 19"])
        dataFrameAuxiliar = dataFrameAuxiliar.iloc[: , :-1]
        dataFrameAuxiliar.columns = ["Data","Hora UTC","PRECIPITAÇÃO TOTAL, HORÁRIO (mm)","PRESSAO ATMOSFERICA AO NIVEL DA ESTACAO, HORARIA (mB)","PRESSÃO ATMOSFERICA MAX.NA HORA ANT. (AUT) (mB)","PRESSÃO ATMOSFERICA MIN. NA HORA ANT. (AUT) (mB)","RADIACAO GLOBAL (Kj/m²)","TEMPERATURA DO AR - BULBO SECO, HORARIA (°C)","TEMPERATURA DO PONTO DE ORVALHO (°C)","TEMPERATURA MÁXIMA NA HORA ANT. (AUT) (°C)","TEMPERATURA MÍNIMA NA HORA ANT. (AUT) (°C)","TEMPERATURA ORVALHO MAX. NA HORA ANT. (AUT) (°C)","TEMPERATURA ORVALHO MIN. NA HORA ANT. (AUT) (°C)","UMIDADE REL. MAX. NA HORA ANT. (AUT) (%)","UMIDADE REL. MIN. NA HORA ANT. (AUT) (%)","UMIDADE RELATIVA DO AR, HORARIA (%)","VENTO, DIREÇÃO HORARIA (gr) (° (gr))","VENTO, RAJADA MAXIMA (m/s)","VENTO, VELOCIDADE HORARIA (m/s)"]

        # TRANSFORMA 8 PRIMEIRAS LINHAS EM COLUNAS DO DATAFRAME
        for line in lineToColumn:
            split = line.split(":;")
            columnName = split[0]
            columnValue = split[1]
            # print(columnName)
            dataFrameAuxiliar[columnName] = columnValue[:-1]

        # RETIRA COLUNA BUGADA
        # dataFrameAuxiliar = dataFrameAuxiliar.drop(columns=["Unnamed: 19"])
        # print(dataFrameAuxiliar)
        if firstTime:
            dataFrame = dataFrameAuxiliar
            firstTime = False
        else:
            dataFrame = dataFrame.append(dataFrameAuxiliar)
        
# print(dataFrame)  

dataFrame.to_csv('database.csv',encoding='ISO-8859-1',sep=';')