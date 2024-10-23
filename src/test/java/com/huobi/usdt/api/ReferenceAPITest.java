package com.huobi.usdt.api;

import com.alibaba.fastjson.JSON;
import com.google.errorprone.annotations.Var;
import com.huobi.api.enums.DirectionEnum;
import com.huobi.api.enums.OffsetEnum;
import com.huobi.api.request.usdt.account.SwapLiquidationOrdersV3Request;
import com.huobi.api.request.usdt.trade.SwapCrossBatchorderRequest;
import com.huobi.api.request.usdt.trade.SwapCrossOrderRequest;
import com.huobi.api.response.coin_futures.account.*;
import com.huobi.api.response.coin_futures.market.*;
import com.huobi.api.response.coin_futures.market.MarketBboResponse;
import com.huobi.api.response.coin_futures.trade.*;
import com.huobi.api.response.coin_futures.transfer.FuturesTransferResponse;
import com.huobi.api.response.coin_swap.account.SwapSubAuthResponse;
import com.huobi.api.response.coin_swap.trade.SwapCancelResponse;
import com.huobi.api.response.coin_swap.trade.SwapTpslCancelallResponse;
import com.huobi.api.response.usdt.account.*;
import com.huobi.api.response.usdt.market.*;
import com.huobi.api.response.usdt.trade.*;
import com.huobi.api.response.usdt.transfer.UsdtSwapTransferResponse;
import com.huobi.api.service.usdt.reference.ReferenceAPIServiceImpl;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONString;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@FixMethodOrder(MethodSorters.JVM)
public class ReferenceAPITest implements BaseTest {
    ReferenceAPIServiceImpl huobiAPIService  = new ReferenceAPIServiceImpl();

    @Test
    public void getSwapFundingRateResponse() {
        SwapFundingRateResponse response = huobiAPIService.getSwapFundingRate("BTC-USDT");
        logger.debug("1.获取合约的资金费率:{}", JSON.toJSONString(response));
    }

    @Test
    public void getSwapBatchFundingRate(){
        SwapBatchFundingRateResponse response=huobiAPIService.getSwapBatchFundingRate("");
        logger.debug("2.批量获取合约资金费率:{}",JSON.toJSONString(response));
    }

    @Test
    public void getSwapHistoricalFundingRateResponse() {
        SwapHistoricalFundingRateResponse response = huobiAPIService.getSwapHistoricalFundingRate("BTC-USDT", 1, 10);
        logger.debug("3.获取合约的历史资金费率:{}", JSON.toJSONString(response));
    }

    @Test
    public void getSwapLiquidationOrdersV3(){
        SwapLiquidationOrdersV3Request request = SwapLiquidationOrdersV3Request.builder().tradeType(5).contract("BTC-USDT").build();
        SwapLiquidationOrdersV3Response response = huobiAPIService.getSwapLiquidationOrdersV3(request);
        logger.debug("4.获取强平订单(新):{}", JSON.toJSONString(response));
    }

    @Test
    public void getSwapSettlementRecords(){
        SwapSettlementRecordsResponse response=huobiAPIService.getSwapSettlementRecords("btc-usdt",0l,0l,1,20);
        logger.debug("5.查询平台历史结算记录:{}",JSON.toJSONString(response));
    }

    @Test
    public void getSwapEliteAccountRatioResponse() {
        SwapEliteAccountRatioResponse response = huobiAPIService.getSwapEliteAccountRatio("BTC-USDT", "60min");
        logger.debug("6.精英账户多空持仓对比-账户数:{}", JSON.toJSONString(response));
    }

    @Test
    public void getSwapElitePositionRatioResponse() {
        SwapElitePositionRatioResponse response = huobiAPIService.getSwapElitePositionRatio("BTC-USDT", "60min");
        logger.debug("7.精英账户多空持仓对比-持仓量:{}", JSON.toJSONString(response));
    }

    @Test
    public void getSwapApiStateResponse() {
        SwapApiStateResponse response = huobiAPIService.getSwapApiState("");
        logger.debug("8.查询系统状态:{}", JSON.toJSONString(response));
    }

    @Test
    public void getSwapLadderMargin(){
        SwapLadderMarginResponse response = huobiAPIService.getSwapLadderMargin("");
        logger.debug("9.获取平台阶梯保证金:{}", JSON.toJSONString(response));
    }

    @Test
    public void getSwapEstimatedSettlementPriceResponse() {
        SwapEstimatedSettlementPriceResponse response = huobiAPIService.getSwapEstimatedSettlementPrice("btc-usdt","","","");
        logger.debug("10.获取预估结算价:{}", JSON.toJSONString(response));
    }

    @Test
    public void getSwapAdjustfactorResponse() {
        SwapAdjustfactorResponse response = huobiAPIService.getSwapAdjustfactor("BTC-USDT");
        logger.debug("11.查询平台阶梯调整系数:{}", JSON.toJSONString(response));
    }

    @Test
    public void getSwapInsuranceFundResponse() {
        SwapInsuranceFundResponse response = huobiAPIService.getSwapInsuranceFund("BTC-USDT", null, null);
        logger.debug("12.查询合约风险准备金余额历史数据:{}", JSON.toJSONString(response));
    }

    @Test
    public void getSwapRiskInfoResponse() {
        SwapRiskInfoResponse response = huobiAPIService.getSwapRiskInfo("","");
        logger.debug("13.查询合约风险准备金余额和预估分摊比例:{}", JSON.toJSONString(response));
    }

    @Test
    public void getSwapPriceLimit() {
        SwapPriceLimitResponse result =
                huobiAPIService.getSwapPriceLimit("","","","all");
        logger.debug("14.获取合约最高限价和最低限价：{}", JSON.toJSONString(result));
    }

    @Test
    public void getSwapOpenInterest() {
        SwapOpenInterestResponse result =
                huobiAPIService.getSwapOpenInterest("btc-usdt","","","");
        logger.debug("15.获取当前可用合约总持仓量:{}", JSON.toJSONString(result));
        result = huobiAPIService.getSwapOpenInterest("","","","");
        logger.debug("15.获取当前可用合约总持仓量:{}", JSON.toJSONString(result));
    }

    @Test
    public void getSwapContractInfo() {
        SwapContractInfoResponse result =
                huobiAPIService.getSwapContractInfo("", "","","","");
        logger.debug("16.获取合约信息：{}", JSON.toJSONString(result));
    }

    @Test
    public void getSwapIndex() {
        SwapIndexResponse result = huobiAPIService.getSwapIndex("btc-usdt");
        logger.debug("17.获取合约指数信息：{}", JSON.toJSONString(result));
        result = huobiAPIService.getSwapIndex("");
        logger.debug("17.获取合约指数信息：{}", JSON.toJSONString(result));
    }

    @Test
    public void getSwapQueryElements(){
        SwapQueryElementsResponse response = huobiAPIService.getSwapQueryElements(null);
        logger.debug("18、合约要素:{}",JSON.toJSONString(response));
    }

    @Test
    public void jsonToObjext(){
        String body = "{\n" +
                "  \"status\": \"ok\",\n" +
                "  \"data\": {\n" +
                "    \"errors\": [],\n" +
                "    \"successes\": \"796038243887169536,796039239967260672,796039239971454976\"\n" +
                "  },\n" +
                "  \"ts\": 1609832157586\n" +
                "}";

        com.huobi.api.response.coin_swap.trade.SwapTpslCancelallResponse response = JSON.parseObject(body, SwapTpslCancelallResponse.class);

        logger.debug(JSON.toJSONString(response));
    }

    @Test
    public void test() {
        List<SwapCrossOrderRequest> list = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            SwapCrossOrderRequest request = SwapCrossOrderRequest.builder()
                    .contractCode("ETH-USDT")
                    .volume(1l)
                    .price(BigDecimal.valueOf(456))
                    .direction(DirectionEnum.SELL)
                    .offset(OffsetEnum.OPEN)
                    .leverRate(30)
                    .orderPriceType("limit")
                    .build();
            list.add(request);
            request = SwapCrossOrderRequest.builder()
                    .contractCode("BTC-USDT")
                    .volume(1l)
                    .price(BigDecimal.valueOf(45600))
                    .direction(DirectionEnum.SELL)
                    .offset(OffsetEnum.OPEN)
                    .leverRate(50)
                    .orderPriceType("limit")
                    .build();
            list.add(request);
        }
        SwapCrossBatchorderRequest request = SwapCrossBatchorderRequest.builder()
                .list(list)
                .build();
        List<Map<String, Object>> listMap = new ArrayList<>();
        request.getList().stream()
                .forEach(e -> {
                    Map<String, Object> params = new HashMap<>();
                    params.put("volume", e.getVolume());
                    params.put("direction", e.getDirection().getValue());
                    if (e.getOffset() != null) {
                        params.put("offset", e.getOffset().getValue());
                    }
                    params.put("order_price_type", e.getOrderPriceType());
                    params.put("lever_rate", e.getLeverRate());
                    if (StringUtils.isNotEmpty(e.getContractCode())) {
                        params.put("contract_code", e.getContractCode().toUpperCase());
                    }
                    if (StringUtils.isNotEmpty(e.getPair())) {
                        params.put("pair", e.getPair().toUpperCase());
                    }
                    if (e.getContractType() != null) {
                        params.put("contract_type", e.getContractType());
                    }
                    if (e.getPrice() != null) {
                        params.put("price", e.getPrice());
                    }
                    if (e.getClientOrderId() != null) {
                        params.put("client_order_id", e.getClientOrderId());
                    }
                    if (e.getTpTriggerPrice() != null && e.getTpTriggerPrice() != BigDecimal.valueOf(0)) {
                        params.put("tp_trigger_price", e.getTpTriggerPrice());
                    }
                    if (e.getTpOrderPrice() != null && e.getTpOrderPrice() != BigDecimal.valueOf(0)) {
                        params.put("tp_order_price", e.getTpOrderPrice());
                    }
                    if (e.getTpOrderPriceType() != null) {
                        params.put("tp_order_price_type", e.getTpOrderPriceType());
                    }
                    if (e.getSlTriggerPrice() != null && e.getSlTriggerPrice() != BigDecimal.valueOf(0)) {
                        params.put("sl_trigger_price", e.getSlTriggerPrice());
                    }
                    if (e.getSlOrderPrice() != null && e.getSlOrderPrice() != BigDecimal.valueOf(0)) {
                        params.put("sl_order_price", e.getSlOrderPrice());
                    }
                    if (e.getSlOrderPriceType() != null) {
                        params.put("sl_order_price_type", e.getSlOrderPriceType());
                    }
                    if (e.getReduceOnly() != null) {
                        params.put("reduce_only", e.getReduceOnly());
                    }
                    listMap.add(params);
                });
        Map<String, Object> params = new HashMap<>();
        params.put("orders_data", listMap);
        String body = JSON.toJSONString(params);
        System.out.println(body);


    }
}
