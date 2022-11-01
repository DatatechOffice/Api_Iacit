import psycopg2

def conecta_db():
    con = psycopg2.connect(host='localhost',
                           database='Api_Iacit',
                           user='postgres',
                           password='123')
    return con

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

