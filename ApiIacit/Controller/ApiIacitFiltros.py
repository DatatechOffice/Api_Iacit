import pandas as pd
import datetime as dt

from Model.Regiao import Regiao

df = pd.read_csv('../database.CSV', sep=';', encoding='ISO-8859-1')  # on_bad_lines = False
# Brasilia2 = pd.DataFrame(Brasilia, index=[0,1,2,3,4,5,6,7])
# Brasilia2 = Brasilia.head(7)
# BraV = BraD.loc[BraD["RADIACAO GLOBAL (Kj/m²)"] == ("155,7")]
xf = df[df["Data"] == ("2020/01/01")]
x = xf[xf["Hora UTC"] == ("0000 UTC")]
xx = x[x["DATA DE FUNDACAO"] == ("07/05/00")]
xd = xx["REGIAO"]
for i in xd:
    print(i)

Regiao.setRegSigla(self=Regiao, reg_sigla=i)
print(Regiao.getSigla)

dfData = df[df["Data"].between("2020/01/01", "2020/12/31")]
print(dfData)



