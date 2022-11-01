class Estado:
    def init(
            self, etd_id, etd_unidade_federativa, reg_id
    ):
        self.etd_id = etd_id
        self.etd_unidade_federativa = etd_unidade_federativa
        self.reg_id = reg_id


    def getEtdId(self):
        return self.etd_id

    def setEtdId(self, etd_id):
        self.etd_id = etd_id

    def getEtdUnidadeFederativa(self):
        return self.etd_unidade_federativa

    def setEtdUnidadeFederativa(self, etd_unidade_federativa):
        self.etd_unidade_federativa = etd_unidade_federativa

    def getRegId(self):
        return self.reg_id

    def setRegId(self, reg_id):
        self.reg_id = reg_id