import psycopg2 as PostgreSQL

#https://www.youtube.com/watch?v=KzQ2hkoTa9M&t=1358s
def conecta_db():
  conexao = PostgreSQL.connect(host='localhost',
                               database='Api_Iacit',
                               user='postgres',
                               password='123')
  return conexao
banco = conexao.cursor()
banco.execute("insert into")
# class Temperartura:
#     def __init__(self, temperaturaDoAr, temperaturaMaxima, temperaturaMinima):
#         self.temperaturaDoAr = temperaturaDoAr
#         self.temperaturaMaxima = temperaturaMaxima
#         self.temperaturaMinima = temperaturaMinima


    # Brasilia = pd.read_csv('BRASILIA2020.CSV', sep=';', encoding='ISO-8859-1', skiprows=8)  # on_bad_lines = False
    # # Brasilia2 = pd.DataFrame(Brasilia, index=[0,1,2,3,4,5,6,7])
    # # Brasilia2 = Brasilia.head(7)
    #
    # BraDR = Brasilia[Brasilia["Data"].between("2020/01/01", "2020/12/31")]