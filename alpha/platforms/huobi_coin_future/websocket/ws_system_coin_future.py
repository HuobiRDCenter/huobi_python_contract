from alpha.utils.ws_utils import *


class WsSystem(WsUtils):
    def __init__(self, host: str = None,sign: str=None):
        super(WsSystem, self).__init__("/center-notification",  host=host,sign=sign)

    def sub(self, data: dict, callback):
        self._sub(json.dumps(data), callback)
