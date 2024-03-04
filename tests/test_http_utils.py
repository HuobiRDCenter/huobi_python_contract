import sys
import unittest

from alpha.utils.http_utils import get, post
from config import *

sys.path.append('..')


class TestHttpUtils(unittest.TestCase):
    def test_get(self):
        result = get(
            config['host'], '/linear-swap-api/v1/swap_contract_info', {'contract_code': 'BTC-USDT'})
        self.assertEqual('ok', result['status'])

    def test_post(self):
        result = post(config['access_key'], config['secret_key'], config['host'],
                      '/linear-swap-api/v1/swap_cross_account_info', {'margin_account': 'USDT'})
        self.assertEqual('ok', result['status'])


if __name__ == '__main__':
    unittest.main(verbosity=2)
