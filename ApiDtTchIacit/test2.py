import psycopg2

conexao = psycopg2.connect(host='localhost',
                               database='Api_Iacit',
                               user='postgres',
                               password='082022')
banco = conexao.cursor()
banco.execute("select * from test")
for linha in banco.fetchall():
    print(linha[0], linha[1])