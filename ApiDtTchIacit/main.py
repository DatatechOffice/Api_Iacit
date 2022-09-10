import pandas as pd
#from unidecode import unidecode
import matplotlib.pyplot as plt

Brasilia = pd.read_csv('DBras2020.CSV', sep=';', encoding='ISO-8859-1', skiprows=8)#, , on_bad_lines = False)


BraD = Brasilia.loc[Brasilia["Data"] == ("2020/10/10")]
print(BraD)

BraV = BraD.loc[BraD["UMIDADE REL. MIN. NA HORA ANT. (AUT) (%)"] ==('46.1')]
print(BraV)

BraDR = Brasilia[Brasilia["Data"].between("2020/01/01", "2020/01/31")]
print(BraDR)