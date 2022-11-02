
class Regiao:
    def __init__(self, reg_id: int, reg_sigla: str):
        self._reg_id = reg_id
        self._reg_sigla = reg_sigla

    def getSigla(self):
        return self._reg_sigla

    def setRegSigla(self, reg_sigla):
        self._reg_sigla = reg_sigla

    def getRedID(self):
        return self._reg_id

    def setRegId(self, reg_id):
        self._reg_id = reg_id