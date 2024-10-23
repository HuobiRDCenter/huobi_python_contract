package com.huobi.api.service.usdt.unified_account;

import com.huobi.api.request.usdt.account.FixPositionMarginChangeRecordRequest;
import com.huobi.api.request.usdt.account.FixPositionMarginChangeRequest;
import com.huobi.api.response.usdt.account.*;

public interface UnifiedAccountAPIService {
    public UnifiedAccountInfoResponse getUnifiedAccountInfo(String contractCode);// 1.查询统一账户资产

    public LinearSwapOverviewAccountInfoResponse getLinearSwapOverviewAccountInfo();// 2.可抵扣HT资产查询

    public LinearSwapFeeSwitchResponse getLinearSwapFeeSwitch(Integer feeOption);// 3.设置U本位合约手续费抵扣方式

    public FixPositionMarginChangeResponse getFixPositionMarginChange(FixPositionMarginChangeRequest request);// 4.调整逐仓持仓保证金

    public FixPositionMarginChangeRecordResponse getFixPositionMarginChangeRecord(FixPositionMarginChangeRecordRequest request); // 5.查询调整逐仓持仓保证金记录

    public SwapUnifiedAccountTypeResponse getSwapUnifiedAccountType();// 6.账户类型查询

    public SwapSwitchAccountTypeResponse getSwapSwitchAccountType(Integer accountType);// 7.账户类型更改接口
}
