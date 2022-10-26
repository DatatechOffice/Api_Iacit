# https://www1.univap.br/alberson/apostilas/pooi/apostila_pooi_3bi.pdf
import psycopg2
try:
    conexao = psycopg2.connect(host='localhost', database='Api_Iacit', user='postgres', password='082022')
    if conexao.is_connected():
        print('Conexão OK!')
    else:
        print('Conexão não realizada com banco')
except Exception as erro:
    print(f'Erro: {erro}')
