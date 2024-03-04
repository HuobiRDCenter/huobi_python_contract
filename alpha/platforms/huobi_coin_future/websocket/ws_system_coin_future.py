from alpha.utils.ws_utils import *


class WsSystem(WsUtils):
    def __init__(self, host: str = None):
        super(WsSystem, self).__init__("/center-notification", host)

    def sub(self, data: dict, callback):
        self._sub(json.dumps(data), callback)
