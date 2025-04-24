from alpha.utils.ws_utils import *


class WsAccount(WsUtils):
    def __init__(self, access_key: str, secret_key: str,sign :str, host: str = None):
        super(WsAccount, self).__init__("/swap-notification", host=host, access_key=access_key, secret_key=secret_key,sign=sign)

    def sub(self, data:dict, callback):
        self._sub(json.dumps(data), callback)

    def unsub(self, data:dict):
        self._unsub(json.dumps(data))
        