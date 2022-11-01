class Regiao:
    def init(self, reg_id, reg_sigla):
        self.reg_id = reg_id
        self.reg_sigla = reg_sigla

    @property
    def getSigla(self):
        return self.reg_sigla

    def setRegSigla(self, reg_sigla):
        self.reg_sigla = reg_sigla

    @property
    def getRedID(self):
        return self.reg_id

    def setRegId(self, reg_id):
        self.reg_id = reg_id