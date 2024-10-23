package com.huobi.api.request.coin_futures.trade;

import com.huobi.api.enums.DirectionEnum;
import com.huobi.api.enums.OffsetEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@Builder
public class ContractTriggerOrderRequest {
   private String symbol ;
   private String contractType;
   private String contractCode;
   private String triggerType;
   private BigDecimal triggerPrice;
   private BigDecimal orderPrice;
   private String orderPriceType;
   private Long volume;
   private DirectionEnum direction;
   private OffsetEnum offset;
   private Integer leverRate;
}
