[![Build Status](https://travis-ci.com/HuobiRDCenter/huobi_Java.svg?branch=master)](https://travis-ci.com/HuobiRDCenter/huobi_Java)

# Huobi Java SDK For Contracts v3

This is Huobi Java SDK v3, you can import to your project and use this SDK to query all market data, trading and manage your account. The SDK supports RESTful API invoking, and subscribing the market, account and order update from the WebSocket connection.

If you already use SDK v1 or v2, it is strongly suggested migrate to v3 as we refactor the implementation to make it simpler and easy to maintain. The SDK v3 is completely consistent with the API documentation of the new HTX open platform. Compared to SDK versions v1 and v2, due to changes in parameters of many interfaces, in order to match the latest interface parameter situation, v3 version has made adjustments to parameters of more than 80 interfaces to ensure that requests can be correctly initiated and accurate response data can be obtained. Meanwhile, the v3 version has added over 130 new interfaces available for use, greatly expanding the number of available interfaces.  We will stop the maintenance of v2 in the near future. Please refer to the instruction on how to migrate v1 or v2 to v3 in section [Migrate from v1 or v2](#Migrate-from-v1-or-v2)

## Table of Contents

- [Quick start](#Quick-start)
- [Usage](#Usage)
  - [Folder structure](#Folder-structure)
  - [Run examples](#Run-examples)
  - [Client](#client)
  - [Migrate from v1 or v2](#Migrate-from-v1-or-v2)
- [Request example](#Request-example)
  - [Reference data](#Reference-data)
  - [Market data](#Market-data)
  - [Account](#account)
  - [Trade](#trade)
  - [Transfer](#transfer)
  - [Strategy](#strategy)
- [Subscription example](#Subscription-example)
  - [Subscribe market update](#Subscribe-market-update)
  - [Request market update](#request-market-update)

## Quick start

*The SDK is compiled by Java8*, you can import the source code in java IDE (idea or eclipse)

The example code are in folder *src/test/java/com/huobi/usdt*, *src/test/java/com/huobi/swap*, *src/test/java/com/huobi/future* that you can run directly

If you want to create your own application, you can follow below steps:

* Create the client instance.
* Call the interfaces provided by client.

```java
// Create ReferenceAPIService instance and query funding rate
ReferenceAPIServiceImpl huobiAPIService  = new ReferenceAPIServiceImpl();

SwapFundingRateResponse response = huobiAPIService.getSwapFundingRate("BTC-USDT");
logger.debug("1.获取合约的资金费率:{}", JSON.toJSONString(response));

// Create MarketAPIService instance and get market depth
MarketAPIServiceImpl huobiAPIService = new MarketAPIServiceImpl();

SwapMarketDepthResponse result = huobiAPIService.getSwapMarketDepth("btc-usdt", "step15");
logger.debug("1.获取行情深度数据：{}", JSON.toJSONString(result));
```

## Usage

### Folder Structure

This is the folder and package structure of SDK source code and the description

- **src/main/java/com/huobi/api**: The core of the SDK for RESTful API
  - **constants**: The RESTful API interface path
  - **enums**: The enum and constant definition
  - **exception**: The exception definition
  - **request**: The data model for request
  - **response**: The data model for response
  - **service**: The client that are responsible to access data，and the internal implementation for each client
  - **utils**: The utilities that include signature, HTTP client etc
- **src/main/java/com/huobi/wss**: The core of the SDK for WebSocket API
  - **constants**: The RESTful API interface path
  - **event**: The data model for response
  - **handle**: The subscription and  request processor for contract market, order information
  - **request**: The data model for request
  - **utils**: The utilities that include signature, Zip tool etc

- **src/test/java/com/huobi**: The test of the SDK
  - **usdt**: The unit test for **USDT-M service** package
  - **future**: The unit test for **Coin-M Futures service** package
  - **swap**: The unit test for **Coin-M Swaps service** package

### Run Examples


This SDK provides examples that under **src/test/java/com/huobi** folder, if you want to run the examples to access private data, you need below additional steps:

1. Create an **API Key** first from Huobi official website
2. Fill your **API Access Key** and **Secret Key** into the constructor input parameters when creating a **Client instance**, as below:

```java
//API_KEY = "hrf5gdfghe-e74bebd8-2f4a33bc-e7963"
//SECRET_KEY = "fecbaab2-35befe7e-2ea695e8-67e56"
AccountAPIServiceImpl huobiAPIService = 
    new AccountAPIServiceImpl("hrf5gdfghe-e74bebd8-2f4a33bc-e7963", "fecbaab2-35befe7e-2ea695e8-67e56");
```

If you don't need to access private data, you can ignore the API key.

Regarding the difference between public data and private data you can find details in [Client](https://github.com/HuobiRDCenter/huobi_Python#Client) section below.

### Client

In this SDK, the client is the class to access the Huobi API. In order to isolate the private data with public data, and isolated different kind of data, the client category is designated to match the API category.

All the client is listed in below table. Each client is very small and simple, it is only responsible to operate its related data, you can pick up multiple clients to create your own application based on your business.

| Contract Category            | Data Category   | Client                                        | Privacy | API Protocol    |
| ---------------------------- | --------------- | --------------------------------------------- | ------- | --------------- |
| USDT-M(usdt)                 | Reference       | ReferenceAPIService,CrossRefferenceAPIService | Public  | Rest            |
| USDT-M(usdt)                 | Market          | MarketAPIService                              | Public  | Rest, WebSocket |
| USDT-M(usdt)                 | Account         | AccountAPIService,CrossAccountAPIService      | Private | Rest, WebSocket |
| USDT-M(usdt)                 | Trade           | TradeAPIService,CrossTradeAPIService          | Private | Rest            |
| USDT-M(usdt)                 | Transfer        | TransferAPISercie,CrossTransferAPIService     | Private | Rest            |
| USDT-M(usdt)                 | Strategy        | StrategyAPIService,CrossStrategyAPIService    | Private | Rest            |
| USDT-M(usdt)                 | Unified Account | UnifiedAccountAPIService                      | Private | Rest            |
| Coin-M Futures(coin_futures) | Reference       | ReferenceAPIService                           | Public  | Rest            |
| Coin-M Futures(coin_futures) | Market          | MarketAPIService                              | Public  | Rest, WebSocket |
| Coin-M Futures(coin_futures) | Account         | AccountAPIService                             | Private | Rest, WebSocket |
| Coin-M Futures(coin_futures) | Trade           | TradeAPIService                               | Private | Rest            |
| Coin-M Futures(coin_futures) | Transfer        | TransferAPISercie                             | Private | Rest            |
| Coin-M Futures(coin_futures) | Strategy        | StrategyAPIService                            | Private | Rest            |
| Coin-M Swaps(coin_futures)   | Reference       | ReferenceAPIService                           | Public  | Rest            |
| Coin-M Swaps(coin_swap)      | Market          | MarketAPIService                              | Public  | Rest, WebSocket |
| Coin-M Swaps(coin_swap)      | Account         | AccountAPIService                             | Private | Rest, WebSocket |
| Coin-M Swaps(coin_swap)      | Trade           | TradeAPIService                               | Private | Rest            |
| Coin-M Swaps(coin_swap)      | Transfer        | TransferAPISercie                             | Private | Rest            |
| Coin-M Swaps(coin_swap)      | Strategy        | StrategyAPIService                            | Private | Rest            |

#### Public and Private

There are two types of privacy that is correspondent with privacy of API:

**Public client**: It invokes public API to get public data (Reference data and Market data), therefore you can create a new instance without applying an API Key.

```java
// Create a ReferenceAPIService instance
ReferenceAPIServiceImpl huobiAPIService = new ReferenceAPIServiceImpl();

// Create a MarketAPIService instance
MarketAPIServiceImpl huobiAPIService = new MarketAPIServiceImpl();
```

**Private client**: It invokes private API to access private data, you need to follow the API document to apply an API Key first, and pass the API Key to the init function

```java
// Create an AccountAPIService instance with APIKey
AccountAPIServiceImpl huobiAPIService = 
    new AccountAPIServiceImpl("hrf5gdfghe-e74bebd8-2f4a33bc-e7963", "fecbaab2-35befe7e-2ea695e8-67e56");

// Create a TradeAPIService instance with API Key
TradeAPIServiceImpl huobiAPIService = 
    new TradeAPIServiceImpl("hrf5gdfghe-e74bebd8-2f4a33bc-e7963", "fecbaab2-35befe7e-2ea695e8-67e56");
```

The API key is used for authentication. If the authentication cannot pass, the invoking of private interface will fail.

#### Rest and WebSocket

There are two protocols of API, Rest and WebSocket

**Rest**: It invokes Rest API and get once-off response, it has two basic types of method: GET and POST

**WebSocket**: It establishes WebSocket connection with server and data will be pushed from server actively. There are two types of method for WebSocket client:

- Request method: The method name starts with "req-", it will receive the once-off data after sending the request.
- Subscription: The method name starts with "sub-", it will receive update after sending the subscription.

### Migrate from v1 or v2

#### Why v3

The major difference between v1 and v2 is that the client category.

In SDK v1, the client is categorized as two protocol, request client and subscription client. For example, for Rest API, you can operate everything in request client. It is simple to choose which client you use, however, when you have a client instance, you will have dozens of method, and it is not easy to choose the proper method.

The thing is different in SDK v2, the client class is categorized as seven data categories, so that the responsibility for each client is clear. For example, if you only need to access market data, you can use MarketClient without applying API Key, and all the market data can be retrieved from MarketClient. If you want to operate your order, then you know you should use TradeClient and all the order related methods are there. Since the category is exactly same as the API document, so it is easy to find the relationship between API and SDK. In SDK v2, each client is smaller and simpler, which means it is easier to maintain and less bugs.

Compared to SDK versions v1 and v2, due to changes and updates in the out and in parameters of many interfaces, in order to match the latest interface in and out parameter situation, v3 version has made adjustments and updates to the out and in parameters of more than 80 interfaces to ensure that requests can be correctly initiated and accurate response data can be obtained. Meanwhile, the v3 version has added over 130 new interfaces available for use, greatly expanding the number of available interfaces.

#### How to migrate

You don't need to change your business logic, what you need is to find the v1 or v2 request client and subscription client, and replace with the proper v3 client. The additional cost is that you need to have additional initialization for each v3 client.

## Request example

### Reference data

#### Query funding rate

```java
ReferenceAPIServiceImpl huobiAPIService  = new ReferenceAPIServiceImpl();
SwapFundingRateResponse response = huobiAPIService.getSwapFundingRate("BTC-USDT");
logger.debug("1.获取合约的资金费率:{}", JSON.toJSONString(response));
```

#### Query information on system status

```java
ReferenceAPIServiceImpl huobiAPIService  = new ReferenceAPIServiceImpl();
SwapApiStateResponse response = huobiAPIService.getSwapApiState("");
logger.debug("8.查询系统状态:{}", JSON.toJSONString(response));
```

### Market data

#### Depth

```java
MarketAPIServiceImpl huobiAPIService = new MarketAPIServiceImpl();
SwapMarketDepthResponse result = huobiAPIService.getSwapMarketDepth("btc-usdt", "step15");
logger.debug("1.获取行情深度数据：{}", JSON.toJSONString(result));
```

#### Get Market BBO Data

```java
MarketAPIServiceImpl huobiAPIService = new MarketAPIServiceImpl();
MarketBboResponse response= huobiAPIService.getMarketBbo("","");
logger.debug("2、获取市场最优挂单:{}",JSON.toJSONString(response));
```

### Account

*Authentication is required.*

#### Query Asset Valuation

```java
AccountAPIServiceImpl huobiAPIService = 
    new AccountAPIServiceImpl("hrf5gdfghe-e74bebd8-2f4a33bc-e7963", "fecbaab2-35befe7e-2ea695e8-67e56");
SwapBalanceValuationResponse response=huobiAPIService.getSwapBalanceValuation("cny");
logger.debug("1.获取账户总资产估值：{}", JSON.toJSONString(response));
```

### Trade

*Authentication is required.*

#### Automatic Order Cancellation

```java
TradeAPIServiceImpl huobiAPIService = 
    new TradeAPIServiceImpl("hrf5gdfghe-e74bebd8-2f4a33bc-e7963", "fecbaab2-35befe7e-2ea695e8-67e56");
LinearCancelAfterRequest request = LinearCancelAfterRequest.builder()
    .onOff(1)
    .build();
LinearCancelAfterResponse response = huobiAPIService.linearCancelAfterResponse(request);
logger.debug("1.【通用】自动撤单：{}", JSON.toJSONString(response));
```

#### Switch Position Mode

```java
TradeAPIServiceImpl huobiAPIService = 
    new TradeAPIServiceImpl("hrf5gdfghe-e74bebd8-2f4a33bc-e7963", "fecbaab2-35befe7e-2ea695e8-67e56");
SwapSwitchPositionModeResponse response = 
    huobiAPIService.swapSwitchPositionModeResponse("btc-usdt","dual_side");
logger.debug("2.切换持仓模式:{}", JSON.toJSONString(response));
```

### Transfer

*Authentication is required.*

#### Transfer margin between Spot account and USDT Margined Contracts account

```java
TransferAPIServiceImpl huobiAPIService = 
    new TransferAPIServiceImpl("hrf5gdfghe-e74bebd8-2f4a33bc-e7963", "fecbaab2-35befe7e-2ea695e8-67e56");
UsdtSwapTransferRequest request = UsdtSwapTransferRequest.builder()
    .from("spot")
    .to("linear-swap")
    .margin_account("btc-usdt")
    .currency("usdt")
    .amount(BigDecimal.valueOf(1))
    .build();
UsdtSwapTransferResponse response = huobiAPIService.transfer(request);
logger.debug("1.现货-USDT本位永续账户间进行资金的划转：{}", JSON.toJSONString(response));
```

### Strategy

*Authentication is required.*

#### Place Trigger Order

```java
StrategyAPIServiceImpl huobiAPIService  = 
    new StrategyAPIServiceImpl("hrf5gdfghe-e74bebd8-2f4a33bc-e7963", "fecbaab2-35befe7e-2ea695e8-67e56");
SwapTriggerOrderRequest request = SwapTriggerOrderRequest.builder()
    .contractCode("ETH-USDT")
    .triggerType("ge")
    .triggerPrice(BigDecimal.valueOf(377))
    .orderPrice(BigDecimal.valueOf(377))
    .orderPriceType("limit")
    .volume(BigDecimal.valueOf(1))
    .direction(DirectionEnum.BUY)
    .offset(OffsetEnum.OPEN)
    .leverRate(5)
    .build();
SwapTriggerOrderResponse response = huobiAPIService.swapTriggerOrderResponse(request);
logger.debug("1.计划委托下单：{}", JSON.toJSONString(response));
```

#### Cancel Trigger Order

```java
StrategyAPIServiceImpl huobiAPIService  = 
    new StrategyAPIServiceImpl("hrf5gdfghe-e74bebd8-2f4a33bc-e7963", "fecbaab2-35befe7e-2ea695e8-67e56");
SwapTriggerCancelRequest request = SwapTriggerCancelRequest.builder()
    .orderId("4699")
    .contractCode("eth-usdt")
    .build();
SwapTriggerCancelResponse response = huobiAPIService.swapTriggerCancelResponse(request);
logger.debug("2.计划委托撤单：{}", JSON.toJSONString(response));
```

## Subscription example

### Subscribe market update

```java
String URL = "wss://api.hbdm.com/linear-swap-ws";
WssMarketHandle wssMarketHandle = new WssMarketHandle(URL);
List<String> channels = Lists.newArrayList();
channels.add("market.BTC-USDT.kline.1min");
// channels.add("market.BTC-USDT.kline.5min");
// channels.add("market.BTC-USDT.kline.15min");
// channels.add("market.BTC-USDT.kline.30min");
// channels.add("market.BTC-USDT.kline.60min");
// channels.add("market.BTC-USDT.kline.4hour");
// channels.add("market.BTC-USDT.kline.1day");
// channels.add("market.BTC-USDT.kline.1week");
// channels.add("market.BTC-USDT.kline.1mon");
wssMarketHandle.sub(channels, response -> {
    logger.info("kLineEvent用户收到的数据===============:{}", JSON.toJSON(response));
    Long currentTimeMillis = System.currentTimeMillis();
    MarketKLineSubResponse event = JSON.parseObject(response, MarketKLineSubResponse.class);
    logger.info("kLineEvent的ts为：{},当前的时间戳为：{},时间间隔为：{}毫秒", event.getTs(), currentTimeMillis, currentTimeMillis - event.getTs());
});
Thread.sleep(Integer.MAX_VALUE);
```

### Request market update

```java
String URL = "wss://api.hbdm.com/linear-swap-ws";
WssMarketReqHandle wssMarketReqHandle = new WssMarketReqHandle(URL, response -> {
    logger.info("请求 KLine 数据用户收到的原始数据:{}", response);
    MarketKLineReqResponse marketKLineReqResponse = JSON.parseObject(response, MarketKLineReqResponse.class);
    logger.info("请求 KLine 数据解析之后的数据为:{}", JSON.toJSON(marketKLineReqResponse));
});
while (true) {
    try {
        Date fromDate = DateUtils.parseDate("2023-12-15T00:00:00", "yyyy-MM-dd'T'HH:mm:ss");
        Date toDate = DateUtils.parseDate("2024-01-15T00:00:01", "yyyy-MM-dd'T'HH:mm:ss");
        WssRequest wssRequest = WssRequest.builder()
            .req("market.BTC-USDT.kline.60min")
            .from(fromDate.getTime() / 1000)
            .to(toDate.getTime() / 1000)
            .build();
        wssMarketReqHandle.doReq(JSON.toJSONString(wssRequest));
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        Thread.sleep(1000);
    }
}
```