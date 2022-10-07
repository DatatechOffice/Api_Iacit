class Temperatura:
    def __init__(self, tem_max, tem_min, tem_bulbo_seco, tem_data_hora, est_codigo):
        self.tem_max = tem_max
        self.tem_min = tem_min
        self.tem_bulbo_seco = tem_bulbo_seco
        self.tem_data_hora = tem_data_hora
        self.est_codigo = est_codigo

temp = Temperatura(19.3, 12.8, 15.88, "2020-01-01 00:00:00", "A001")