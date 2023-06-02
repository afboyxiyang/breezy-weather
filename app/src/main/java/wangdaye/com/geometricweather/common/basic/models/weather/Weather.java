package wangdaye.com.geometricweather.common.basic.models.weather;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.io.Serializable;
import java.util.List;

public class Weather
        implements Serializable {

    @NonNull private final Base base;
    @Nullable private final Current current;
    @Nullable private History yesterday;
    @NonNull private final List<Daily> dailyForecast;
    @NonNull private final List<Hourly> hourlyForecast;
    @NonNull private final List<Minutely> minutelyForecast;
    @NonNull private final List<Alert> alertList;

    public Weather(@NonNull Base base, @Nullable Current current, @Nullable History yesterday,
                   @NonNull List<Daily> dailyForecast,
                   @NonNull List<Hourly> hourlyForecast,
                   @NonNull List<Minutely> minutelyForecast,
                   @NonNull List<Alert> alertList) {
        this.base = base;
        this.current = current;
        this.yesterday = yesterday;
        this.dailyForecast = dailyForecast;
        this.hourlyForecast = hourlyForecast;
        this.minutelyForecast = minutelyForecast;
        this.alertList = alertList;
    }

    @NonNull
    public Base getBase() {
        return base;
    }

    @Nullable
    public Current getCurrent() {
        return current;
    }

    public void setYesterday(@Nullable History yesterday) {
        this.yesterday = yesterday;
    }

    @Nullable
    public History getYesterday() {
        return yesterday;
    }

    @NonNull
    public List<Daily> getDailyForecast() {
        return dailyForecast;
    }

    @NonNull
    public List<Hourly> getHourlyForecast() {
        return hourlyForecast;
    }

    @NonNull
    public List<Minutely> getMinutelyForecast() {
        return minutelyForecast;
    }

    @NonNull
    public List<Alert> getAlertList() {
        return alertList;
    }

    public boolean isValid(Float pollingIntervalHours) {
        long updateTime = base.getUpdateTime();
        long currentTime = System.currentTimeMillis();
        return pollingIntervalHours == null
            || (currentTime >= updateTime
            && currentTime - updateTime < pollingIntervalHours * 60 * 60 * 1000);
    }
}
