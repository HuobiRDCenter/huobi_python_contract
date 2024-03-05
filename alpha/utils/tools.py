# -*- coding:utf-8 -*-

"""
工具包

Author: QiaoXiaofeng
Date:   2018/04/28
Update: 2018/09/07 1. 增加函数datetime_to_timestamp;
        2019/09/18 2. 增加函数来处理浮点数截取不四舍五入noround_float
"""

import uuid
import time
import decimal
import datetime


def get_cur_timestamp():
    """ 获取当前时间戳
    """
    ts = int(time.time())
    return ts


def get_cur_timestamp_ms():
    """ 获取当前时间戳(毫秒)
    """
    ts = int(time.time() * 1000)
    return ts


def get_cur_datetime_m(fmt='%Y%m%d%H%M%S%f'):
    """ 获取当前日期时间字符串，包含 年 + 月 + 日 + 时 + 分 + 秒 + 毫秒
    """
    today = datetime.datetime.today()
    str_m = today.strftime(fmt)
    return str_m

def date_str_to_dt(date_str=None, fmt='%Y%m%d', delta_day=0):
    """ 日期字符串转换到datetime对象
    @param date_str 日期字符串
    @param fmt 日期字符串格式
    @param delta_day 相对天数，<0减相对天数，>0加相对天数
    """
    if not date_str:
        dt = datetime.datetime.today()
    else:
        dt = datetime.datetime.strptime(date_str, fmt)
    if delta_day:
        dt += datetime.timedelta(days=delta_day)
    return dt


def dt_to_date_str(dt=None, fmt='%Y%m%d', delta_day=0):
    """ datetime对象转换到日期字符串
    @param dt datetime对象
    @param fmt 返回的日期字符串格式
    @param delta_day 相对天数，<0减相对天数，>0加相对天数
    """
    if not dt:
        dt = datetime.datetime.today()
    if delta_day:
        dt += datetime.timedelta(days=delta_day)
    str_d = dt.strftime(fmt)
    return str_d

def ts_to_datetime_str(ts=None, fmt='%Y-%m-%d %H:%M:%S'):
    """ 将时间戳转换为日期时间格式，年-月-日 时:分:秒
    @param ts 时间戳，默认None即为当前时间戳
    @param fmt 返回的日期字符串格式
    """
    if not ts:
        ts = get_cur_timestamp()
    dt = datetime.datetime.fromtimestamp(int(ts))
    return dt.strftime(fmt)


def datetime_str_to_ts(dt_str, fmt='%Y-%m-%d %H:%M:%S'):
    """ 将日期时间格式字符串转换成时间戳
    @param dt_str 日期时间字符串
    @param fmt 日期时间字符串格式
    """
    ts = int(time.mktime(datetime.datetime.strptime(dt_str, fmt).timetuple()))
    return ts


def datetime_to_timestamp(dt=None, tzinfo=None):
    """ 将datetime对象转换成时间戳
    @param dt datetime对象，如果为None，默认使用当前UTC时间
    @param tzinfo 时区对象，如果为None，默认使用timezone.utc
    @return ts 时间戳(秒)
    """
    if not dt:
        dt = get_utc_time()
    if not tzinfo:
        tzinfo = datetime.timezone.utc
    ts = int(dt.replace(tzinfo=tzinfo).timestamp())
    return ts

def utctime_str_to_mts(utctime_str, fmt="%Y-%m-%dT%H:%M:%S.%fZ"):
    """ 将UTC日期时间格式字符串转换成时间戳（毫秒）
    @param utctime_str 日期时间字符串 eg: 2019-03-04T09:14:27.806Z
    @param fmt 日期时间字符串格式
    @return timestamp 时间戳(毫秒)
    """
    dt = datetime.datetime.strptime(utctime_str, fmt)
    timestamp = int(dt.replace(tzinfo=datetime.timezone.utc).astimezone(tz=None).timestamp() * 1000)
    return timestamp


def get_uuid1():
    """ make a UUID based on the host ID and current time
    """
    s = uuid.uuid1()
    return str(s)


def get_uuid3(str_in):
    """ make a UUID using an MD5 hash of a namespace UUID and a name
    @param str_in 输入字符串
    """
    s = uuid.uuid3(uuid.NAMESPACE_DNS, str_in)
    return str(s)


def get_uuid4():
    """ make a random UUID
    """
    s = uuid.uuid4()
    return str(s)


def get_uuid5(str_in):
    """ make a UUID using a SHA-1 hash of a namespace UUID and a name
    @param str_in 输入字符串
    """
    s = uuid.uuid5(uuid.NAMESPACE_DNS, str_in)
    return str(s)


def float_to_str(f, p=20):
    """ Convert the given float to a string, without resorting to scientific notation.
    @param f 浮点数参数
    @param p 精读
    """
    if type(f) == str:
        f = float(f)
    ctx = decimal.Context(p)
    d1 = ctx.create_decimal(repr(f))
    return format(d1, 'f')

def noround_float(f, n):
    """ Get the given n digit float to the string, without rounding up or rounding down.
    """
    f_str = str(f)
    a, b, c = f_str.partition('.')
    c = (c+"0"*n)[:n]
    return ".".join([a, c])

def decimal_digit(digit):
    """ Get the Decimal n digit present for Decimal.
    """
    f_str = '0.'
    for i in range(digit):
        f_str += '0'
    return f_str

