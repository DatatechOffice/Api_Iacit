import pandas as pd
#from unidecode import unidecode
import matplotlib.pyplot as plt

Brasilia = pd.read_csv('DBras2020.CSV', sep=';', encoding='ISO-8859-1', skiprows=8)#, , on_bad_lines = False)


BraT = Brasilia.loc[Brasilia["Data"] == ("2020/10/10")]
print(BraT)