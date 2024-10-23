package com.huobi.api.response.coin_swap.market;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@AllArgsConstructor
@Data
public class HeartBeatResponse {
    private String status;
    private List<DataBean> data;

    @Data
    @AllArgsConstructor
    public static class DataBean {
        private Integer heartbeat;
        @SerializedName("swap_heartbeat")
        private Integer swapHeartbeat;

        @SerializedName("estimated_recovery_time")
        private Long estimatedRecoveryTime;
        @SerializedName("swap_estimated_recovery_time")
        private Long swapEstimatedRecoveryTime;
        @SerializedName("linear_swap_heartbeat")
        private Long linearSwapHeartbeat;
        @SerializedName("linear_swap_estimated_recovery_time")
        private Long linearSwapEstimatedRecoveryTime;
    }
}
