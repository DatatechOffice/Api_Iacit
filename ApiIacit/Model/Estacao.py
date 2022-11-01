class Estacao:
    def init(self, est_codigo, est_nome_estacao, est_latitude, est_longitude, est_altitude, est_data_fundacao, etd_id):
        self.est_codigo = est_codigo
        self.est_nome_estacao = est_nome_estacao
        self.est_latitude = est_latitude
        self.est_longitude = est_longitude
        self.est_altitude = est_altitude
        self.est_data_dundacao = est_data_fundacao
        self.etd_id = etd_id

    def getEstCodigo(self):
        return self.est_codigo

    def setEstCodigo(self, est_codigo):
        self.est_codigo = est_codigo

    def getEstNomeEstacao(self):
        return self.est_nome_estacao

    def setEstNomeEstacao(self, est_nome_estacao):
        self.est_nome_estacao = est_nome_estacao

    def getEstLatitude(self):
        return self.est_latitude

    def setEstLatitude(self, est_latitude):
        self.est_latitude = est_latitude

    def getEstLongitude(self):
        return self.est_longitude

    def setEstLongitude(self, est_longitude):
        self.est_longitude = est_longitude

    def getEstAltitude(self):
        return self.est_altitude
    def setEstAltitude(self, est_altitude):
        self.est_altitude = est_altitude

    def getEstDataFundacao(self):
        return self.est_data_fundacao

    def setEstDataFundacao(self, est_data_fundacao):
        self.est_data_fundacao = est_data_fundacao

    def getEtdID(self):
        return self.etd_id

    def setEtdID(self, etd_id):
        self.etd_id = etd_id